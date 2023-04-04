package com.hikmetcakir.configuration;

import com.google.gson.*;
import org.springframework.boot.autoconfigure.gson.GsonBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Configuration
public class GsonConfiguration {

    @Bean
    public GsonBuilder gsonBuilder(List<GsonBuilderCustomizer> customizers) {
        GsonBuilder builder = new GsonBuilder();
        customizers.forEach((c) -> c.customize(builder));
        builder.registerTypeHierarchyAdapter(LocalDateTime.class, new JsonSerializer<LocalDateTime>() {
            @Override
            public JsonElement serialize(LocalDateTime src, Type typeOfSrc, JsonSerializationContext context) {
                return new JsonPrimitive(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(src));
            }
        }).registerTypeAdapter(LocalDateTime.class, new JsonDeserializer<LocalDateTime>() {
            @Override
            public LocalDateTime deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) {
                return LocalDateTime.parse(json.getAsJsonPrimitive().getAsString(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            }
        });
        return builder;
    }
}
