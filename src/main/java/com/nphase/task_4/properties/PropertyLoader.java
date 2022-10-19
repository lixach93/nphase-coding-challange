package com.nphase.task_4.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class PropertyLoader {

    private PropertyLoader() {

    }


    public static String getProperty(String key) {
        try (InputStream input = PropertyLoader.class.getClassLoader().getResourceAsStream("config.properties")) {

            Properties prop = new Properties();
            prop.load(input);
            return prop.getProperty(key);
        } catch (IOException io) {
            throw new RuntimeException("Resources is not founded", io);
        }
    }
}
