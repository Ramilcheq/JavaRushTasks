package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
������ �����
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fname = reader.readLine();
        FileReader fileReader = new FileReader(fname);
        BufferedReader freader = new BufferedReader(fileReader);
        String str;
        while ((str = freader.readLine()) != null) {
            String[] arstr = str.split(" ");
            String astr = "";
            for (int i = 0; i < arstr.length; i++) {
                Pattern p = Pattern.compile("\\d+");
                Matcher m = p.matcher(arstr[i]);
                if (m.matches()) {
                    int chislo = Integer.parseInt(arstr[i]);
                    if (map.containsKey(chislo)) arstr[i] = map.get(chislo);
                }
                astr = astr + arstr[i] + " ";
            }
            System.out.println(astr.trim());
        }
        reader.close();
        fileReader.close();
        freader.close();
    }
}
