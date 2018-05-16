package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fname = args[0];
        FileInputStream fstream = new FileInputStream(fname);
        int probels = 0;
        int sum = fstream.available();
        int symbol;
        while (fstream.available() > 0) {
            symbol = fstream.read();
            if (symbol == 32) probels = probels + 1;
        }
        fstream.close();
        System.out.println(Math.rint(100*100.0*probels/sum)/100);
    }
}
