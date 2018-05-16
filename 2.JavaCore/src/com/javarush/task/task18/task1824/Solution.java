package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        String fname = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            try {
                fname = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                FileInputStream file = new FileInputStream(fname);
                try {
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                System.out.println(fname);
                return;
            }
        }
    }
}
