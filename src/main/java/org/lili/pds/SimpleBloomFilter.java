package org.lili.pds;

/**
 * Created by erichan 六翁
 * on 15/8/25
 */

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.nio.charset.Charset;
import java.util.BitSet;

//Counting Bloom filter相比传统的Bloom filter，由于采用了计数，因此支持remove操作。
//基于BitSet来实现，性能上可能存在问题
public class SimpleBloomFilter<T> {
    private static final int DEFAULT_SIZE = 2 << 24;//2的25次方
    private static final int[] seeds = new int[]{5, 7, 11, 13, 31, 37, 61};//质数
    private BitSet bits = new BitSet(DEFAULT_SIZE);
    private SimpleHash[] hashFunctions = new SimpleHash[seeds.length];

    public SimpleBloomFilter() {
        for (int i = 0; i < seeds.length; i++) {
            hashFunctions[i] = new SimpleHash(DEFAULT_SIZE, seeds[i]);
        }
    }

    public void add(T value) {
        if (value != null) {
            for (SimpleHash f : hashFunctions) {
                bits.set(f.hash(value), true);
            }
        }
    }

    public boolean exist(T value) {
        if (value == null) {
            return false;
        }
        for (SimpleHash f : hashFunctions) {
            //需要所有的位都为1，才代表包含
            if (!bits.get(f.hash(value))) {
                return false;
            }
        }
        return true;
    }

    class SimpleHash<T> {
        private int capacity;
        private int seed;

        public SimpleHash(int capacity, int seed) {
            this.capacity = capacity;
            this.seed = seed;
        }

        //计算hash值的具体算法,hash函数，采用简单的加权和hash
        public int hash(T value) {
            String hashValue = value.hashCode() + "";
            //int的范围最大是2的31次方减1，或超过值则用负数来表示
            int result = 0;
            for (int i = 0; i < hashValue.length(); i++) {
                result = seed * result + hashValue.charAt(i);
            }
            //&是java中的位逻辑运算，用于过滤负数--负数与进算转换成反码进行
            return (capacity - 1) & result;
        }
    }

    public static void main(String[] args) {
        SimpleBloomFilter filter = new SimpleBloomFilter();
        System.out.println("拥抱变化 existed ? " + filter.exist("拥抱变化"));
        filter.add("客户第一");
        filter.add("团队合作");
        filter.add("拥抱变化");
        filter.add("诚信");
        filter.add("激情");
        filter.add("敬业");
        System.out.println("拥抱变化 existed ? " + filter.exist("拥抱变化"));

        BloomFilter<String> bf= BloomFilter.create(
                Funnels.stringFunnel(Charset.defaultCharset()),
                100_000_000,
                0.9);
        System.out.println("拥抱变化 existed ? " + bf.mightContain("客户第一"));
        bf.put("客户第一");
        System.out.println("拥抱变化 existed ? " + bf.mightContain("客户第一"));
    }
}