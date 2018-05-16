package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fname1;
        String fname2;
        String fname3;

        fname1 = reader.readLine();
        fname2 = reader.readLine();
        fname3 = reader.readLine();
        FileInputStream f1input = new FileInputStream(fname1);
        FileOutputStream f2output = new FileOutputStream(fname2);
        FileOutputStream f3output = new FileOutputStream(fname3);
        int size = f1input.available();
        if ((size % 2) == 0) {
            byte[] buffer = new byte[size / 2];
            f1input.read(buffer);
            f2output.write(buffer);
            f1input.read(buffer);
            f3output.write(buffer);
        } else {
            byte[] buffer = new byte[(size / 2) + 1];
            f1input.read(buffer);
            f2output.write(buffer);
            buffer = new byte[(size / 2)];
            f1input.read(buffer);
            f3output.write(buffer);
        }
        reader.close();
        f1input.close();
        f2output.close();
        f3output.close();
    }
}
