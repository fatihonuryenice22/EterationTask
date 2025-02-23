package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    //Reads the configurations from config.properties
    private static Properties properties;
    static {
        try {
            String path = "config.properties";
            FileInputStream input = new FileInputStream(path);
            properties = new Properties();
            properties.load(input);
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String getProperty(String keyName){
        String systemProperty = System.getProperty(keyName);
        if (systemProperty != null) {
            return systemProperty;
        }
        // If we dont't have any command from terminal read it from config properties
        return properties.getProperty(keyName);
    }
}
