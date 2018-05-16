package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.*;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fname1 = reader.readLine();
        reader.close();

        FileReader file1 = new FileReader(fname1);
        int i = 0;
        String s = "";
        while (file1.ready()) {
            int buffer = file1.read();
            if (buffer > 96 && buffer < 123) s += (char) buffer;
            else {
                if(s.equals("world")) {
                    i++;
                }
                s="";
            }
        }
        file1.close();
        if(s.equals("world")) {
            i++;
        }
        System.out.println(i);
    }
}
