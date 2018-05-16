package com.javarush.task.task22.task2211;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String fname1 = args[0];
        String fname2 = args[1];

        Charset utf8 = Charset.forName("UTF-8");
        Charset windows1251 = Charset.forName("Windows-1251");

        try (FileInputStream inputStream = new FileInputStream(fname1);
             FileOutputStream outputStream = new FileOutputStream(fname2);) {
            while (inputStream.available() > 0) {
                byte[] buffer = new byte[1000];
                inputStream.read(buffer);
                String s = new String(buffer, windows1251);
                buffer = s.getBytes(utf8);
                outputStream.write(buffer);
            }
        }
    }
}
