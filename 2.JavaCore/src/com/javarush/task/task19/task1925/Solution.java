package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fName1 = args[0];
        String fName2 = args[1];

        FileReader fileReader = new FileReader(fName1);
        FileWriter fileWriter = new FileWriter(fName2);

        BufferedReader freader = new BufferedReader(fileReader);

        String line = "";
        String str = "";
        while ((line = freader.readLine()) != null) {
            String[] strings = line.split(" ");

            for (int i = 0; i < strings.length; i++) {
                String word = strings[i];
                if (word.length() > 6) {
                    str = str + word + ",";
                }
            }
        }
        fileWriter.write(str.substring(0, str.length() - 1));
        fileReader.close();
        fileWriter.close();
        //freader.close();
    }
}
