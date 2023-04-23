package com.hikmetcakir.common.port;

public interface CachePort {

    void deleteValue(String key);

    <T> T getValue(String key, Class<T> type);

    <T> void putValue(String key, T value);
}
