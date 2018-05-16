package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //reader.readLine()
        FileInputStream inputStream = new FileInputStream((new BufferedReader(new InputStreamReader(System.in))).readLine());
        int q = 0;
        int max = 0;
        while (inputStream.available() > 0) {
            q = inputStream.read();
            max = (q > max) ? q : max;
        }
        System.out.println(max);
        inputStream.close();
    }
}
