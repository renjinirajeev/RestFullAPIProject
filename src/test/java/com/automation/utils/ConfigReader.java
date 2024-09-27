package com.automation.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    static Properties prop;
    public static void initConfig(){
        prop = new Properties();
        try {
            prop.load(new FileReader("src/test/resources/config/Config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getConfig(String key){
        return prop.getProperty(key);
    }

    public static void setConfig(String key,String value){
        prop.setProperty(key,value);
    }
}
