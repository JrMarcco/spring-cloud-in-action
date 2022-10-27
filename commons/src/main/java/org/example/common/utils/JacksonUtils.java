package org.example.common.utils;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;

@Slf4j
public class JacksonUtils {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    static {
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
        OBJECT_MAPPER.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        OBJECT_MAPPER.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        OBJECT_MAPPER.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        OBJECT_MAPPER.setDefaultPropertyInclusion(JsonInclude.Include.NON_NULL);
    }

    private JacksonUtils() {
    }

    public static ObjectMapper instance() {
        return OBJECT_MAPPER;
    }

    public static <T> String toJsonString(T object) {
        try {
            return OBJECT_MAPPER.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.error("### [Error] Jackson write json string error: {} ###", e.getMessage(), e);
        }
        return "";
    }

    public static <T> byte[] toJsonBytes(T object) {
        try {
            return OBJECT_MAPPER.writeValueAsBytes(object);
        } catch (JsonProcessingException e) {
            log.error("### [Error] Jackson write json bytes error: {} ###", e.getMessage(), e);
        }
        return new byte[]{};
    }

    public static <T> T parseObject(String json, Class<T> objectClass) {
        try {
            return OBJECT_MAPPER.readValue(json, objectClass);
        } catch (IOException e) {
            log.error("### [Error] Jackson parse object error: {} ###", e.getMessage(), e);
        }
        return null;
    }

    public static <T> T parseObject(byte[] bytes, Class<T> objectClass) {
        return parseObject(bytes, StandardCharsets.UTF_8, objectClass);
    }

    public static <T> T parseObject(byte[] bytes, Charset charset, Class<T> objectClass) {
        try {
            return OBJECT_MAPPER.readValue(new String(bytes, charset), objectClass);
        } catch (IOException e) {
            log.error("### [Error] Jackson parse object error: {} ###", e.getMessage(), e);
        }
        return null;
    }

    public static <T> List<T> parseList(String json, Class<T> elementClass) {
        try {
            return OBJECT_MAPPER.readValue(
                    json, OBJECT_MAPPER.getTypeFactory().constructCollectionType(List.class, elementClass)
            );
        } catch (IOException e) {
            log.error("### [Error] Jackson parse list error: {} ###", e.getMessage(), e);
        }
        return Collections.emptyList();
    }

    public static <T> T convertValue(String fromValue, Class<T> toValueType) {
        return OBJECT_MAPPER.convertValue(fromValue, toValueType);
    }
}
