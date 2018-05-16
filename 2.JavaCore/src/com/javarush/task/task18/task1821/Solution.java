package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fname = args[0];
        FileInputStream file = new FileInputStream(fname);
        TreeMap<String, Integer> symbolsMap = new TreeMap<String, Integer>();
        int freq = 1;
        String symbol;
        while (file.available() > 0) {
            symbol = Character.toString((char) file.read());
            freq = (symbolsMap.get(symbol) != null) ? symbolsMap.get(symbol) + 1 : freq;
            symbolsMap.put(symbol, freq);
            freq = 1;
        }

        for (Map.Entry entry : symbolsMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        file.close();
    }
}
