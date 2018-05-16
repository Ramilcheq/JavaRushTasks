package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String f1Name;// = "e:/1";//null;
        String f2Name;// = "e:/2";//null;
        String f3Name;// = "e:/3";//null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        f1Name = reader.readLine();
        f2Name = reader.readLine();
        f3Name = reader.readLine();

        FileOutputStream f1Stream = new FileOutputStream(f1Name);
        FileInputStream f2Stream = new FileInputStream(f2Name);
        FileInputStream f3Stream = new FileInputStream(f3Name);
        byte[] buffer = new byte[f2Stream.available()];
        f2Stream.read(buffer);
        f1Stream.write(buffer);
        buffer = new byte[f3Stream.available()];

        f3Stream.read(buffer);
        f1Stream.write(buffer);

        reader.close();
        f1Stream.close();
        f2Stream.close();
        f3Stream.close();
    }


}
