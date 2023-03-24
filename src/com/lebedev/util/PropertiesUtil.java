package com.lebedev.util;

import com.lebedev.exception.ReadPropertiesException;

import java.io.IOException;
import java.util.Properties;

public final class PropertiesUtil {
    public static final Properties PROPERTIES = new Properties();

    private PropertiesUtil() {
    }

    static {
        loadProperties();
    }

    private static void loadProperties() {
        try (var resourceAsStream = PropertiesUtil.class
                .getClassLoader()
                .getResourceAsStream("application.properties")) {
            PROPERTIES.load(resourceAsStream);
        } catch (IOException e) {
            throw new ReadPropertiesException(e);
        }
    }


    public static String get(String key) {
        return PROPERTIES.getProperty(key);
    }
}
