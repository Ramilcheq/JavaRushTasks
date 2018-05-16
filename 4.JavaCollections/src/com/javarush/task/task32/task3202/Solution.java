package com.javarush.task.task32.task3202;

import java.io.*;

/* 
Читаем из потока
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("d:/1/1.txt"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter writer = new StringWriter();

        if (is != null) {
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;
            //читаем строку из Reader’а

            while ((line = br.readLine()) != null) {
                writer.write(line);
            }
        }

        return writer;
    }
}