package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fname1 = reader.readLine();
        String fname2 = reader.readLine();
        reader.close();
        FileReader file1 = new FileReader(fname1);
        FileWriter file2 = new FileWriter(fname2);
        int i = 1;
        while (file1.ready()) {
            int buffer = file1.read();
            if (i % 2 == 0) {
                file2.write(buffer);
            }
            i++;
        }
        file1.close();
        file2.close();
    }
}
