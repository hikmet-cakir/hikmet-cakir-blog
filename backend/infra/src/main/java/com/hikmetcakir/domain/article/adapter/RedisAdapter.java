package com.hikmetcakir.domain.article.adapter;

import com.google.gson.Gson;
import com.hikmetcakir.article.model.Article;
import com.hikmetcakir.configuration.RedisConfigurationProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class RedisAdapter {

    private final Gson gson;

    private final RedisTemplate<String, String> redisTemplate;

    private final RedisConfigurationProperties redisConfigurationProperties;

    public Article getValue(String key) {
        String value = redisTemplate.opsForValue().get(key);
        return gson.fromJson(value, Article.class);
    }

    public void setValue(Article article) {
        String key = article.getId();
        redisTemplate.opsForValue().set(key, gson.toJson(article));
        redisTemplate.expire(key, redisConfigurationProperties.getExpireTime(), TimeUnit.MINUTES);
    }
}
