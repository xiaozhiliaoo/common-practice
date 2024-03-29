/*
package org.lili.ehcache;

import lombok.extern.log4j.Log4j2;
import org.ehcache.Cache;
import org.ehcache.PersistentCacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.config.units.EntryUnit;
import org.ehcache.config.units.MemoryUnit;
import org.ehcache.expiry.Expirations;

import java.io.File;
import java.time.Duration;
import java.time.temporal.TemporalUnit;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

*/
/**
 * @author lili
 * @date 2020/1/29 22:42
 * @description
 *//*

@Log4j2
public class DialogCache {

    private static final String STRING_CACHE_NAME = "stringcache";
    private static final String QUEUE_CACHE_NAME = "queuecache";

    private PersistentCacheManager getPersistentCacheManager() {
        ResourcePoolsBuilder resourcePoolsBuilder = ResourcePoolsBuilder.newResourcePoolsBuilder()
                .heap(10, EntryUnit.ENTRIES)
                .disk(20, MemoryUnit.MB, true);

        PersistentCacheManager persistentCacheManager = CacheManagerBuilder.newCacheManagerBuilder()
                .with(CacheManagerBuilder.persistence(new File(getStoragePath(), "cacheData")))
                .withCache(STRING_CACHE_NAME,
                        CacheConfigurationBuilder.newCacheConfigurationBuilder(String.class, String.class,
                                resourcePoolsBuilder
                        ).withExpiry(Expirations.timeToLiveExpiration(Duration.of(10, TimeUnit.MINUTES)))
                )
                .withCache(QUEUE_CACHE_NAME,
                        CacheConfigurationBuilder.newCacheConfigurationBuilder(String.class, ConcurrentLinkedQueue.class,
                                resourcePoolsBuilder
                        ).withExpiry(Expirations.timeToLiveExpiration(Duration.of(10, (TemporalUnit) TimeUnit.MINUTES)))
                )
                .build(true);

        return persistentCacheManager;
    }

    public String readString(String key) {
        PersistentCacheManager persistentCacheManager = getPersistentCacheManager();
        Cache<String, String> stringCache = persistentCacheManager.getCache(STRING_CACHE_NAME, String.class, String.class);
        String val = stringCache.get(key);
        persistentCacheManager.close();
        return val;
    }


    public void saveString(String key, String value) {
        PersistentCacheManager persistentCacheManager = getPersistentCacheManager();
        Cache<String, String> stringCache = persistentCacheManager.getCache(STRING_CACHE_NAME, String.class, String.class);
        stringCache.put(key, value);
        persistentCacheManager.close();
    }

    public void removeCache(String key) {
        PersistentCacheManager persistentCacheManager = getPersistentCacheManager();
        Cache<String, String> stringCache = persistentCacheManager.getCache(STRING_CACHE_NAME, String.class, String.class);
        Cache<String, ConcurrentLinkedQueue> queueCache = persistentCacheManager.getCache(QUEUE_CACHE_NAME, String.class, ConcurrentLinkedQueue.class);

        if(stringCache.containsKey(key)) {
            stringCache.remove(key);
        }
        if(queueCache.containsKey(key)) {
            queueCache.remove(key);
        }

        persistentCacheManager.close();
    }

    public int getQueueLen(String key) {
        PersistentCacheManager persistentCacheManager = getPersistentCacheManager();
        Cache<String, ConcurrentLinkedQueue> queueCache = persistentCacheManager.getCache(QUEUE_CACHE_NAME, String.class, ConcurrentLinkedQueue.class);
        ConcurrentLinkedQueue<String> queue = queueCache.get(key);
        int len = queue == null ? 0 : queue.size();
        persistentCacheManager.close();
        return len;
    }

    public ConcurrentLinkedQueue<String> getQueue(String key) {
        PersistentCacheManager persistentCacheManager = getPersistentCacheManager();
        Cache<String, ConcurrentLinkedQueue> queueCache = persistentCacheManager.getCache(QUEUE_CACHE_NAME, String.class, ConcurrentLinkedQueue.class);
        ConcurrentLinkedQueue<String> queue = queueCache.get(key);
        persistentCacheManager.close();
        return queue;
    }

    public void popFromQueue(String key) {
        PersistentCacheManager persistentCacheManager = getPersistentCacheManager();
        Cache<String, ConcurrentLinkedQueue> queueCache = persistentCacheManager.getCache(QUEUE_CACHE_NAME, String.class, ConcurrentLinkedQueue.class);
        ConcurrentLinkedQueue<String> queue = queueCache.get(key);
        if(queue != null && queue.size() > 0) {
            queue.poll();
            queueCache.put(key, queue);
        }
        persistentCacheManager.close();
    }

    public void pushToQueue(String key, String value) {
        PersistentCacheManager persistentCacheManager = getPersistentCacheManager();
        Cache<String, ConcurrentLinkedQueue> queueCache = persistentCacheManager.getCache(QUEUE_CACHE_NAME, String.class, ConcurrentLinkedQueue.class);
        ConcurrentLinkedQueue<String> queue = queueCache.get(key);
        if(queue == null) {
            queue = new ConcurrentLinkedQueue<>();
        }
        queue.offer(value);
        queueCache.put(key, queue);
        persistentCacheManager.close();
    }

    public String getQueueByIndex(String key, int index) {
        PersistentCacheManager persistentCacheManager = getPersistentCacheManager();
        Cache<String, ConcurrentLinkedQueue> queueCache = persistentCacheManager.getCache(QUEUE_CACHE_NAME, String.class, ConcurrentLinkedQueue.class);
        ConcurrentLinkedQueue<String> queue = queueCache.get(key);
        if(queue == null) {
            return null;
        }

        int count = 0;
        Iterator<String> iter = queue.iterator();
        while(iter.hasNext()) {
            count++;
            if(count == index) {
                return iter.next();
            }
        }
        return null;
    }


    private String getStoragePath() {
        return System.getProperties().getProperty("user.home");
    }
}
*/
