package com.javarush.task.task16.task1630;

import java.io.*;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;
    public static StringBuilder sb;
    //add your code here - добавьте код тут
    static {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = br.readLine();
            secondFileName = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws InterruptedException, IOException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        //add your code here - добавьте код тут
        f.join();

        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут
    public static class ReadFileThread extends Thread implements ReadFileInterface  {
        private String fileName;

        public void setFileName(String fullFileName) {
            fileName = fullFileName;
        }

        public String getFileContent() {
            if (sb == null) return "";
            else return sb.toString();
        }

        @Override
        public void run() {
            sb = new StringBuilder();
            try {
                FileInputStream fs = new FileInputStream(getFileName());
                BufferedReader br = new BufferedReader(new InputStreamReader(fs));
                String str = br.readLine();

                while (str != null) {
                    sb.append(str).append(" ");
                    str = br.readLine();
                }
            }
            catch (IOException e) {
                System.out.println("Не могу найти файл");
            }
        }

        public String getFileName() {
            return fileName;
        }
    }
}
