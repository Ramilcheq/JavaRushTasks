package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(r.readLine());
        BufferedReader reader = new BufferedReader(fileReader);

        String line = "";
        while ((line = reader.readLine()) != null) {
            String rev = new StringBuilder(line).reverse().toString();
            System.out.println(rev);
        }
        r.close();
        fileReader.close();
        reader.close();
    }
}
