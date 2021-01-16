package com.tech.microservices.payment.config;

import lombok.extern.log4j.Log4j2;
import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;
import org.springframework.context.annotation.Configuration;

/**
 * @author Haytham DAHRI
 */
@Configuration
@Log4j2
public class CacheEventLogger implements CacheEventListener<Object, Object> {


    @Override
    public void onEvent(CacheEvent<? extends Object, ? extends Object> cacheEvent) {
        log.info("Cache key: {} | Cache Old Value: {} | Cache New Value: {}", cacheEvent.getKey(), cacheEvent.getOldValue(), cacheEvent.getNewValue());
    }
}
