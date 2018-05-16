package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fname1 = reader.readLine();
        String fname2 = reader.readLine();
        reader.close();

        BufferedReader file1 = new BufferedReader(new FileReader(fname1));
        int i = 0;
        String s = "";
        String numbers = "";
        Pattern p = Pattern.compile("[0-9]+");
        while (file1.ready()) {
            int buffer = file1.read();
            if (buffer == 32) {
                Matcher m = p.matcher(s);
                if (m.matches()) numbers = numbers + s + " ";
                s = "";
            } else {
                s += (char) buffer;
            }
        }
        file1.close();
        Matcher m = p.matcher(s);
        if (m.matches()) numbers += s;

        BufferedWriter file2 = new BufferedWriter(new FileWriter(fname2));
        file2.write(numbers);
        file2.close();

        System.out.println(numbers);
    }
}