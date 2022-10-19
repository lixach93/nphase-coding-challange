package com.nphase.task_3.properties;

import java.util.Map;

public final class PropertyLoader {

    private PropertyLoader() {

    }

    private static final Map<String, String> propertiesMap = Map.of("item", "3", "discount", "10");

    public static String getProperty(final String key) {
        String value = propertiesMap.get(key);
        if (value == null || value.isEmpty()) {
            throw new RuntimeException("Value is null or empty");
        }
        return value;
    }
}
