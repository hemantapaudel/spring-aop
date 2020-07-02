package com.aop.application.config;

import net.sf.ehcache.config.CacheConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
/**
 * We need to add Spring's @EnableCaching annotation to a Spring bean so that Spring's
 * annotation-driven cache management is enabled.
 *
 * Spring's auto-configuration finds Ehcache's implementation of JSR-107. However, no caches are created by default.
 */
public class CacheConfig extends CachingConfigurerSupport {


    @Bean("ehCacheManger")
    net.sf.ehcache.CacheManager ehCacheManger(){

        CacheConfiguration tenSecondCache = new CacheConfiguration();
        tenSecondCache.setName("tenSecondCache");
        tenSecondCache.setMemoryStoreEvictionPolicy("LRU");
        tenSecondCache.setMaxEntriesLocalHeap(1000);
        tenSecondCache.setTimeToLiveSeconds(10);

        CacheConfiguration twentySecondCache = new CacheConfiguration();
        twentySecondCache.setName("user-cache-2");
        twentySecondCache.setMemoryStoreEvictionPolicy("LRU");
        twentySecondCache.setMaxEntriesLocalHeap(1000);
        twentySecondCache.setTimeToLiveSeconds(20);


        net.sf.ehcache.config.Configuration configuration = new net.sf.ehcache.config.Configuration();
        configuration.addCache(tenSecondCache);
        configuration.addCache(twentySecondCache);

        return net.sf.ehcache.CacheManager.newInstance(configuration);

    }


    @Bean
    public CacheManager cacheManager() {
        return new EhCacheCacheManager(ehCacheManger());
    }


}
