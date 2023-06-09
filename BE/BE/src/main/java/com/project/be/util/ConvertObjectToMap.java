package com.project.be.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class ConvertObjectToMap {

    public static Map<String, Object> convert(Object obj) {
        Map<String, Object> map = new HashMap<>();
        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                map.put(field.getName(), field.get(obj));
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return map;
    }


}
