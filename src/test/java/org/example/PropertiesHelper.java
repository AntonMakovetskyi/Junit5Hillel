package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHelper {
    public static String URL;

    public static String getProperty(String propertyName) {
        Properties properties = new Properties();

        try{
            File propFile = new File(String.format("files/%s.properties", getEnv()));
            FileReader fileReader = new FileReader(propFile);
            properties.load(fileReader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties.getProperty(propertyName);
    }

    private static String getEnv() {
        String env = System.getProperty("env");
        if(env == null) {
            return "qa";
        }
        return env;
    }

    public static void init() {
        URL = PropertiesHelper.getProperty("url");
    }
}
