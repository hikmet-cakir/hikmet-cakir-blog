package com.hikmetcakir.article.port;

public interface CachePort {

    <T> T getValue(String key, Class<T> type);

    <T> void putValue(String key, T value);

    void deleteValue(String key);
}
