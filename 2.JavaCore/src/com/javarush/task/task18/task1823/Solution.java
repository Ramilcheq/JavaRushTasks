package com.javarush.task.task18.task1823;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fname;
        while (true) {
            fname = reader.readLine();
            if (fname.equals("exit")) break;
            ReadThread rt = new ReadThread(fname);
            rt.start();
        }
        /*for (Map.Entry entry : resultMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }*/
    }

    public static class ReadThread extends Thread {
        private FileInputStream file;
        private String fname;

        public ReadThread(String fileName) throws IOException {
            //implement constructor body
            this.file = new FileInputStream(fileName);
            this.fname = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут

        public void Search() throws IOException {
            Map<Integer, Integer> maxBytes = new TreeMap<Integer, Integer>();
            int freq = 0;
            int max = 1;
            int lenBytes = file.available();
            for (int i = 0; i < lenBytes; i++) {
                int fbyte = file.read();
                freq = (maxBytes.get(fbyte) != null) ? maxBytes.get(fbyte) + 1 : 1;
                maxBytes.put(fbyte, freq);
                max = (max < maxBytes.get(fbyte)) ? maxBytes.get(fbyte) : max;
            }
            for (Map.Entry<Integer, Integer> entry : maxBytes.entrySet()) {
                if (entry.getValue() == max) resultMap.put(fname, entry.getKey());
            }
            this.file.close();
        }

        @Override
        public void run() {
            try {
                Search();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
