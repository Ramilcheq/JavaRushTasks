package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fname = reader.readLine();

        FileInputStream fileInputStream = new FileInputStream(fname);
        load(fileInputStream);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        save(outputStream);
    }

    public void save(OutputStream outputStream) throws Exception {
        Properties prop = new Properties();
        prop.putAll(properties);
        prop.store(outputStream, "huy");
    }

    public void load(InputStream inputStream) throws Exception {
        Properties prop = new Properties();
        prop.load(inputStream);
        for (final String name: prop.stringPropertyNames())
            properties.put(name, prop.getProperty(name));
    }

    public static void main(String[] args) throws Exception{
        new Solution().fillInPropertiesMap();
    }
}
