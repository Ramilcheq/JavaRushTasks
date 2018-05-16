package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //if (args.length == 0) System.exit(0);
        if (args[0].equals("-c")) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fname = reader.readLine();
            reader.close();
            int maxId = 0;

            FileInputStream fstream = new FileInputStream(fname); // вычленяем ид из последней строчки файла и увеличиваем на 1
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                int currentId = Integer.parseInt(addSpaces(strLine, 8).trim());
                if (maxId < currentId) maxId = currentId;
            }


            String id = addSpaces(((Integer) (maxId + 1)).toString(), 8); // добавляем пробелы к параметрам
            String productName = addSpaces(args[1], 30);
            String price = addSpaces(args[2], 8);
            String quantity = addSpaces(args[3], 4);

            FileWriter fileWriter = new FileWriter(fname, true);
            //fileWriter.append("\n");
            fileWriter.write("\n" + id + productName + price + quantity);
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
