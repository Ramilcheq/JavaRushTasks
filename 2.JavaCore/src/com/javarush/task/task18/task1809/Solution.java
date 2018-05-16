package com.javarush.task.task18.task1809;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fname1;
        String fname2;

        fname1 = reader.readLine();
        fname2 = reader.readLine();
        FileInputStream f1input = new FileInputStream(fname1);
        FileOutputStream f2output = new FileOutputStream(fname2);
        byte[] buffer = new byte[f1input.available()];
        f1input.read(buffer);
        for (int i = buffer.length - 1; i + 1 > 0; i--) {
            f2output.write(buffer[i]);
        }
        reader.close();
        f1input.close();
        f2output.close();
    }
}
