package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    static int code = 1;

    public static void main(String[] args) throws IOException {
        String fileName = args[1];
        String fileOutputName = args[2];
        switch (args[0]) {
            case "-e":
                encrypt(fileName, fileOutputName);
                break;
            case "-d":
                decrypt(fileName, fileOutputName);
                break;
        }
    }

    public static void encrypt(String fileName, String fileOutputName) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(fileName);
        FileOutputStream fileOutputStream = new FileOutputStream(fileOutputName);
        int size = fileInputStream.available();
        int buffer;

        for (int i = 0; i < size; i++) {
            buffer = fileInputStream.read();
            fileOutputStream.write(buffer + code);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }

    public static void decrypt(String fileName, String fileOutputName) throws IOException{
        FileInputStream fileInputStream = new FileInputStream(fileName);
        FileOutputStream fileOutputStream = new FileOutputStream(fileOutputName);
        int size = fileInputStream.available();
        int buffer;

        for (int i = 0; i < size; i++) {
            buffer = fileInputStream.read();
            fileOutputStream.write(buffer - code);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }

}
