package com.javarush.task.task18.task1810;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws DownloadException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fname1;
        while (true) {
            try {
                fname1 = reader.readLine();
                FileInputStream finput = new FileInputStream(fname1);
                if (finput.available() < 1000) {
                    reader.close();
                    finput.close();
                    throw new DownloadException();
                }
            } catch (IOException e) {
            }
        }

    }

    public static class DownloadException extends Exception {

    }
}
