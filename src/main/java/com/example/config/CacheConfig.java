//package com.example.config;
//
//import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
////import org.springframework.cache.jcache.JCacheCacheManager;//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//
//import javax.cache.Caching;
//import javax.cache.configuration.MutableConfiguration;
//import javax.cache.expiry.CreatedExpiryPolicy;
//import javax.cache.expiry.Duration;
//
//@Configuration
//public class CacheConfig {
//
//    @Bean
//    public JCacheManagerCustomizer cacheManagerCustomizer() {
//        return cm -> {
//            cm.createCache("products", new MutableConfiguration<>()
//                    .setExpiryPolicyFactory(CreatedExpiryPolicy.factoryOf(Duration.TEN_MINUTES))
//                    .setStoreByValue(false)
//                    .setStatisticsEnabled(true));
//        };
//    }
//
//    @Bean
//    public JCacheCacheManager cacheManager() throws Exception {
//        javax.cache.CacheManager jCacheManager = Caching.getCachingProvider()
//                .getCacheManager(getClass().getResource("/ehcache_bkp").toURI(), getClass().getClassLoader());
//        return new JCacheCacheManager(jCacheManager);
//    }
//}