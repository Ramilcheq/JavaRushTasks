package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fname = reader.readLine();
        reader.close();
        String id = args[1];

        if (args[0].equals("-u")) {
            String productName = addSpaces(args[2], 30);
            String price = addSpaces(args[3], 8);
            String quantity = addSpaces(args[4], 4);

            FileInputStream fstream = new FileInputStream(fname); // находим записи с заданным ид
            ArrayList<String> fLInes = new ArrayList<>();
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            int nomerStroki = 0;
            while ((strLine = br.readLine()) != null) {
                fLInes.add(strLine);
                String currentId = addSpaces(strLine, 8).trim();
                if (currentId.equals(id)) {
                    fLInes.set(nomerStroki, addSpaces(id, 8) + productName + price + quantity);
                }
                nomerStroki += 1;
            }

            FileWriter fileWriter = new FileWriter(fname); //запись
            for (String s : fLInes) {
                fileWriter.write(s + "\n");
            }
            fileWriter.close();
            fstream.close();
        }

        if(args[0].equals("-d")){
            FileInputStream fstream = new FileInputStream(fname); // находим записи с заданным ид
            ArrayList<String> fLInes = new ArrayList<>();
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            int nomerStroki = 0;
            while ((strLine = br.readLine()) != null) {
                fLInes.add(strLine);
                String currentId = addSpaces(strLine, 8).trim();
                if (currentId.equals(id)) {
                    fLInes.remove(nomerStroki);
                }
                nomerStroki += 1;
            }

            FileWriter fileWriter = new FileWriter(fname); //запись
            for (String s : fLInes) {
                fileWriter.write(s + "\n");
            }
            fileWriter.close();
            fstream.close();
        }
    }

    public static String addSpaces(String str, int length) {
        int q = length - str.length();
        if (q > 0) {
            for (int i = 0; i < q; i++) {
                str = str + " ";
            }
        } else {
            str = str.substring(0, length);
        }
        return str;
    }
}
