package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fname = args[0];
        FileInputStream fstream = new FileInputStream(fname); //65-122
        int englishsum = 0;
        int letter;
        while (fstream.available() > 0) {
            letter = fstream.read();
            if ((letter > 64 & letter < 91) || (letter < 123 & letter > 96)) englishsum = englishsum + 1;
        }
        System.out.println(englishsum);
        fstream.close();
    }
}
