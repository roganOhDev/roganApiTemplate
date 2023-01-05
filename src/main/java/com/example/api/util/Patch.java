package com.example.api.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.util.Map;

public class Patch {
    public static <EntityT, EntityClass, RequestT> EntityClass entityByRequest(EntityT entity, Class<EntityClass> entityClazz, RequestT request) {
        final var entityMapper = new ObjectMapper();

        Map<String, Object> entityAsMap = mapper(entity, entityMapper);
        Map<String, Object> requestAsMap = mapper(request);

        merge(entityAsMap, requestAsMap);

        return entityMapper.convertValue(entityAsMap, entityClazz);
    }

    private static void merge(final Map<String, Object> entityAsMap, final Map<String, Object> requestAsMap) {
        for (String key : entityAsMap.keySet()) {
            final var sourceValue = requestAsMap.get(key);
            if (sourceValue != null) {
                entityAsMap.put(key, sourceValue);
            }
        }
    }

    private static <T> Map<String, Object> mapper(T o, ObjectMapper mapper) {
        mapper.registerModule(new JavaTimeModule());

        return mapper.convertValue(o, new TypeReference<Map<String, Object>>() {
        });
    }

    private static <T> Map<String, Object> mapper(T o) {
        final var mapper = new ObjectMapper();
        return mapper(o, mapper);
    }
}
