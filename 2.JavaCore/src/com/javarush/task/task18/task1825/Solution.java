package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        TreeSet<String> fileNames = new TreeSet<>();
        String fname;
        String originalFname = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            fname = reader.readLine();
            if (fname.equals("end")) break;
            fileNames.add(fname);
        }

        originalFname = fileNames.first().substring(0, fileNames.first().length() - 6);

        FileOutputStream fileOutput = new FileOutputStream(originalFname);
        for (String file : fileNames) {
            FileInputStream fileInput = new FileInputStream(file);
            byte[] buffer = new byte[fileInput.available()];
            fileInput.read(buffer);
            fileOutput.write(buffer);
            fileInput.close();
        }
        fileOutput.close();
    }


}
