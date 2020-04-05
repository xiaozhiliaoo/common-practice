### roaringbitmap研究

cardinality counting  基数计数：不重复元素个数

https://en.wikipedia.org/wiki/Count-distinct_problem

1 represent IP addresses of packets passing through a router, 
2 unique visitors to a web site, 
3 elements in a large database, 
4 motifs in a DNA sequence,  
5 elements of RFID/sensor networks.

https://en.wikipedia.org/wiki/Bloom_filter
可能在，绝对不在。false positive(假阳性-化验阳性，但是对肺部进行检查，实际没得) ，false negatives(假阴性-肯定得了，但是没检查出来)
possibly in set" or "definitely" not in set
https://en.wikipedia.org/wiki/Category:Probabilistic_data_structures

https://en.wikipedia.org/wiki/Run-length_encoding
https://en.wikipedia.org/wiki/Bitmap_index
https://en.wikipedia.org/wiki/Cardinality_(SQL_statements)

MySQL does not have bitmap indexes.
MySQL只支持BTree和Hash索引，不支持位图索引：https://dev.mysql.com/doc/refman/8.0/en/create-index.html

cardinal number

MySQL，Oracle 执行计划里面：cardinality  
show index from table;索引中不重复记录预估值

Engineering Fast Indexes for Big Data Applications:

有40亿个无符号的整型数据，现在给定一个目标数字，判断这个数字是否在这40亿数据中?
40亿个数据中出现过两次的数据？
一个int 4 byte，10亿 4G，40亿 16G
4 bytes存一个数字，现在位图4 bytes=32 bits存储了32个数字，16G/32=500M存储40亿
2^32=4294967296
2^64=18446744073709551616
Java Integer.MAX_VALUE=(2^31)-1
BMP位图文件-Bitmap-File

10亿个字符串中出现一次的那个字符串？布隆过滤器
https://redis.io/topics/data-types-intro#hyperloglogs
https://oss.redislabs.com/redisbloom/

BitSet,RoaringBitmap(压缩的BitSet)

Membership problem：HashSet.constains, BitSet.get, Bloom Filter，Counting Bloom Filter(元素是否在一个集合中)
Cardinality problem：HashSet.size, BitSet.cardinality, Linear counter，Log Log，HyperLogLog(集合不重复元素个数)
Frequency problem：HashMap.put, HashMultiset.count, Count Sketch，Count-Min Sketch(集合元素某元素出现频率)


https://www.youtube.com/watch?v=F7EhDBfsTA8
Bloom Filter(set membership)
Count-Min Sketch(count tracking-frequency)
HyperLogLog(cardiality-unique vistor,)

System Design Interview - Top K Problem (Heavy Hitters)
 
CS369G: Algorithmic Techniques for Big Data
http://web.stanford.edu/class/cs369g/index.html

PDSA:https://github.com/gakhov/pdsa