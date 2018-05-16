package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filepath = reader.readLine();
        reader.close();
        FileInputStream fileInputStream = new FileInputStream(filepath);
        Set SetBytes = new TreeSet<Byte>();
        while (fileInputStream.available() > 0) {
            int b = fileInputStream.read();
            SetBytes.add(b);
        }
        for (Iterator iterator = SetBytes.iterator(); iterator.hasNext(); ) {
            System.out.print(iterator.next() + " ");
        }
        fileInputStream.close();
    }
}
