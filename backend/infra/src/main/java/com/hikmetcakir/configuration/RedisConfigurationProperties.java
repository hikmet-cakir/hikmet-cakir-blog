package com.hikmetcakir.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "spring.redis")
public class RedisConfigurationProperties {
    private int port;
    private String host;
    private int expireTime;
}
