package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fname = "";
        try {
            fname = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int sum = 0;
        try {
            FileInputStream inputStream = new FileInputStream(fname);
            try {
                while (inputStream.available() > 0) {
                    int b = inputStream.read();
                    if (b == 44) sum = sum + 1;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                inputStream.close();
            } catch (IOException e) {
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(sum);
    }
}
