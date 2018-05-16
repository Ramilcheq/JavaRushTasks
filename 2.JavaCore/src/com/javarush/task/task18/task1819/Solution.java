package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String f1name = null;
        String f2name = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        f1name = reader.readLine();
        f2name = reader.readLine();

        FileInputStream f1Input = new FileInputStream(f1name);
        byte[] buffer1 = new byte[f1Input.available()];
        f1Input.read(buffer1);
        FileOutputStream f1Output = new FileOutputStream(f1name);
        FileInputStream f2Input = new FileInputStream(f2name);
        byte[] buffer2 = new byte[f2Input.available()];
        f2Input.read(buffer2);
        f1Output.write(buffer2);
        f1Output.write(buffer1);
        reader.close();
        f1Input.close();
        f1Output.close();
        f2Input.close();
    }
}
