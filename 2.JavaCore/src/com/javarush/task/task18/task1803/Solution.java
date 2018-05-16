package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;


/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filepath = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(filepath);
        int freq = 1;
        int max = 1;
        int q;
        Map MapBytes = new HashMap<Integer, Integer>();
        while (fileInputStream.available() > 0) {
            q = fileInputStream.read();
            if (MapBytes.get(q) == null) {
                MapBytes.put(q, freq);
            } else {
                freq = (Integer) MapBytes.get(q) + 1;
                MapBytes.put(q, freq);
                max = (freq > max) ? freq : max;
                freq = 1;
            }
        }
        Set<Map.Entry<Integer, Integer>> set = MapBytes.entrySet();
        for (Map.Entry<Integer, Integer> entry : set) {
            if (entry.getValue() == max) System.out.print(entry.getKey() + " ");
        }
        fileInputStream.close();
        reader.close();
    }
}
