package org.example.testConfigProject.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class PropertiesUtils {
    private static final String FILE_PATH = "src/main/resources/config/config.properties";
    private static final String DEFAULT_VALUE = "";

    public static String getProperty(String key) {
        Properties properties = new Properties();

        try (FileInputStream fis = new FileInputStream(FILE_PATH)) {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties.getProperty(key, DEFAULT_VALUE);
    }

    public static void setProperty(String key, String value) {
        Properties properties = new Properties();

        try (FileInputStream fis = new FileInputStream(FILE_PATH)) {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileOutputStream fos = new FileOutputStream(FILE_PATH)) {
            properties.setProperty(key, value);
            properties.store(fos, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> getStringListProperty(String key) {
        String propertyValue = getProperty(key);
        if (!propertyValue.isEmpty()) {
            return Arrays.asList(propertyValue.split(","));
        }
        return new ArrayList<>();
    }

    public static void setStringListProperty(String key, List<String> values) {
        setProperty(key, String.join(",", values));
    }

}