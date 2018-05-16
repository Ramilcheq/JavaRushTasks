package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
   /* public static void main(String[] args) throws IOException {
        String id = args[0];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fname = reader.readLine();
        FileInputStream file = new FileInputStream(fname);
        String str = "";
        ArrayList<String> list=new ArrayList<>();

        while (file.available() > 0) {
            str = str + Character.toString((char) file.read());
            if (str.endsWith("\r\n")) {
                /*if (str.startsWith(id + " ")) {
                    System.out.println(str.substring(0, str.length() - 2));
                }
                list.add(str.substring(0, str.length() - 2));
                str = "";
            }
        }

        list.add(str);
        /*if (str.startsWith(id + " ")) {
            System.out.println(str);
        }
        for(String s:list){
            if(s.startsWith(id + " ")) System.out.println(s);
        }

        file.close();
        reader.close();
    }*/
   public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedReader fr = new BufferedReader(new FileReader(new File(br.readLine())));
       br.close();

       String id = args[0];

       ArrayList<String> list = new ArrayList<>();

       while (fr.ready()){
           list.add(fr.readLine());
       }
       fr.close();

       for (String s : list){
           if(s.startsWith(id + " "))
               System.out.println(s);
       }

   }
}
