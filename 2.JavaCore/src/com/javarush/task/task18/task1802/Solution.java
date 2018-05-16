package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream((new BufferedReader(new InputStreamReader(System.in))).readLine());
        int q = 0;
        int min = fileInputStream.read();
        while (fileInputStream.available() > 1) {
            q = fileInputStream.read();
            min = (min < q) ? min : q;
        }
        System.out.println(min);
        fileInputStream.close();
    }
}
