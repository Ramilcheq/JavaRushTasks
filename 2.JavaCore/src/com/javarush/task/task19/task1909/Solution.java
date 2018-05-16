package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fname1 = reader.readLine();
        String fname2 = reader.readLine();
        reader.close();
        reader = new BufferedReader(new FileReader(fname1));
        String str = "";
        while (reader.ready()) {
            int q = reader.read();
            if (q == 46)
                str = str + "!";
            else
                str += (char) q;
        }
        reader.close();

        BufferedWriter writer = new BufferedWriter(new FileWriter(fname2));
        writer.write(str);
        writer.close();
    }
}
