package com.haoer.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class JsonUtils {

    private static ObjectMapper mapper = new ObjectMapper();

    public static <T> T stringToObject(String content, Class<T> clazz) {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            T object = mapper.readValue(content, clazz);
            return object;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String objectToString(Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> List<T> stringToList(String content, Class<T> clazz) {
        try {
            JavaType collectionType = getCollectionType(mapper, List.class, clazz);
            List<T> list = (List<T>) mapper.readValue(content, collectionType);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static JavaType getCollectionType(ObjectMapper mapper, Class<?> collectionClass, Class<?>... elementClasses) {
        return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }

}
