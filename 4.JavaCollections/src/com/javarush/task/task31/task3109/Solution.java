package com.javarush.task.task31.task3109;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

/* 
Читаем конфиги
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        Solution solution = new Solution();
        Properties properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {
        //String fullPath = System.getProperty("user.dir") + File.separator + fileName;
        Properties result = new Properties();
        try {
            result.loadFromXML(new FileInputStream(fileName));
            return result;
        } catch (Exception e) {
            result.load(new FileReader(fileName));
            return result;
        } finally {
            return result;
        }
    }
}
