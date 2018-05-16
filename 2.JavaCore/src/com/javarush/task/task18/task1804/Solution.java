package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filepath = reader.readLine();
        reader.close();
        FileInputStream fileInputStream = new FileInputStream(filepath);
        int freq = 1;
        int min;
        int q;
        Map<Integer, Integer> MapBytes = new HashMap<Integer, Integer>();
        while (fileInputStream.available() > 0) {
            q = fileInputStream.read();
            if (MapBytes.get(q) == null) {
                MapBytes.put(q, freq);
            } else {
                freq = MapBytes.get(q) + 1;
                MapBytes.put(q, freq);
                freq = 1;
            }
        }
        fileInputStream.close();
        min = Collections.min(MapBytes.entrySet(), Map.Entry.comparingByValue()).getValue();
        for (Map.Entry<Integer, Integer> entry : MapBytes.entrySet()) {
            if (entry.getValue() == min) System.out.print(entry.getKey() + " ");
        }
    }
}
