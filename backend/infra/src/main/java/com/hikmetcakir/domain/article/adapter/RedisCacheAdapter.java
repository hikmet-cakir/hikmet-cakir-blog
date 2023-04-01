package com.hikmetcakir.domain.article.adapter;

import com.google.gson.Gson;
import com.hikmetcakir.article.port.CachePort;
import com.hikmetcakir.configuration.RedisConfigurationProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class RedisCacheAdapter implements CachePort {

    private final RedisConfigurationProperties redisConfigurationProperties;

    private final RedisTemplate<String, String> redisTemplate;

    private final Gson gson;

    public <T> T getValue(String key, Class<T> type) {
        String value = redisTemplate.opsForValue().get(key);
        return gson.fromJson(value, type);
    }

    @Override
    public <T> void putValue(String key, T value) {
        redisTemplate.opsForValue().set(key, gson.toJson(value));
        redisTemplate.expire(key, redisConfigurationProperties.getExpireTime(), TimeUnit.MINUTES);
    }

    @Override
    public void deleteValue(String key) {
        redisTemplate.delete(key);
    }
}
