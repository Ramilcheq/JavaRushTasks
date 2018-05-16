package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String fname = (new BufferedReader(new InputStreamReader(System.in))).readLine();
        BufferedReader br = new BufferedReader(new FileReader(fname));
        String line;
        String words = "";
        while ((line = br.readLine()) != null) {
            words += line;
        }
        String[] w = words.split("\\s+");
        StringBuilder result = getLine(w);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        int max = 0;
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.length - 1; i++) {
            sb = recur(i, words);
            int len = sb.toString().split(" ").length;
            if (len > max) {
                result = sb;
                max = len;
            }
        }

        String[] strings = result.toString().split(" ");
        for (int i = 0; i < words.length; i++) {
            boolean notFound = true;
            for (int j = 0; j < strings.length; j++) {
                if (words[i].equals(strings[j])) {
                    notFound = false;
                    break;
                }
            }
            if (notFound) result.append(" ").append(words[i]);
        }
        return result;
    }

    public static StringBuilder recur(int index, String... words) {
        StringBuilder sb = new StringBuilder();
        sb.append(words[index]);
        String end = words[index].charAt(words[index].length() - 1) + "";
        HashSet<Integer> set = new HashSet<>();
        set.add(index);
        int i = 0;
        for (i = 0; i < words.length; i++) {
            if (set.contains(i)) {
                continue;
            }
            String begin = words[i].charAt(0) + "";
            if (end.equalsIgnoreCase(begin)) {
                set.add(i);
                sb.append(" ").append(words[i]);
                end = words[i].charAt(words[i].length() - 1) + "";
                i = -1;
            }
        }
        return sb;
    }
}
