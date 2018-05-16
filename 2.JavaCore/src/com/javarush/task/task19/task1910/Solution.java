package com.javarush.task.task19.task1910;

/* 
Пунктуация
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
            str += (char) q;
        }
        reader.close();

        char[] symbols = str.toCharArray();
        //String[] prepinaniya={"!","?",".",",","\"","...",":",";","-","(",")"};
        String prepinaniya = "-!?.,\":;()\n\r#$%'*+/=@[\\]^_`{|}~";
        String strNujnoe="";
        for (char c : symbols) {
            if (prepinaniya.indexOf(c) == -1) strNujnoe+=c;
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(fname2));
        writer.write(strNujnoe);
        writer.close();
    }
}