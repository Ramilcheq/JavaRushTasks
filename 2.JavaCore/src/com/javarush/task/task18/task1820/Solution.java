package com.javarush.task.task18.task1820;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Solution {
    public static void main(String[] args) throws IOException {
        String f1name;// = "e:/1";//null;
        String f2name;// = "e:/2";//null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        f1name = reader.readLine();
        f2name = reader.readLine();
        reader.close();
        FileInputStream f1Input = new FileInputStream(f1name);
        FileOutputStream f2Output = new FileOutputStream(f2name);
        String str = "";
        BigDecimal number;
        byte[] chislo;
        byte[] buffer = new byte[f1Input.available()];
        f1Input.read(buffer);
        for (int i = 0; i < buffer.length; i++) {
            if (buffer[i] != 32) {
                str = str + (char) buffer[i];
            } else {
                number = BigDecimal.valueOf(Double.parseDouble(str));
                number = (number.compareTo(BigDecimal.ZERO) > 0) ? number.setScale(0, RoundingMode.HALF_UP) : number.setScale(0, RoundingMode.HALF_DOWN);
                str = number.toString();
                chislo = str.getBytes();
                for (int j = 0; j < chislo.length; j++) {
                    f2Output.write(chislo[j]);
                }
                f2Output.write(32);
                str = "";
            }
        }

        number = BigDecimal.valueOf(Double.parseDouble(str));
        number = number.setScale(0, RoundingMode.HALF_UP);
        str = number.toString();
        chislo = str.getBytes();
        for (int j = 0; j < chislo.length; j++) {
            f2Output.write(chislo[j]);
        }

        f1Input.close();
        f2Output.close();
    }
}
