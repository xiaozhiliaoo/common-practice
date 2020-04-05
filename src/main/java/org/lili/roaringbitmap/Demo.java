package org.lili.roaringbitmap;

import org.junit.Test;
import org.roaringbitmap.RoaringBitmap;

/**
 * @author lili
 * @date 2020/4/5 12:47
 * @description
 * @notes
 */

public class Demo {
    @Test
    public void test() {
        //0,1,2,3
        RoaringBitmap rr = RoaringBitmap.bitmapOf(1,2,3,1000);
        RoaringBitmap rr2 = new RoaringBitmap();
        rr2.add(4000L,4255L);
        System.out.println(rr.select(3));
        System.out.println(rr.rank(2));
        rr.contains(1000); // will return true
        rr.contains(7); // will return false

        RoaringBitmap rror = RoaringBitmap.or(rr, rr2);// new bitmap
        rr.or(rr2); //in-place computation
        boolean equals = rror.equals(rr);// true
        if(!equals) throw new RuntimeException("bug");
        // number of values stored?
        long cardinality = rr.getLongCardinality();
        System.out.println(cardinality);
        // a "forEach" is faster than this loop, but a loop is possible:
        for(int i : rr) {
            System.out.print(i+" ,");
        }


    }
}
