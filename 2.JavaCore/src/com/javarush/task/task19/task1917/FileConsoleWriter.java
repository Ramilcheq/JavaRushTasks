package com.javarush.task.task19.task1917;

/* 
Свой FileWriter
*/

import java.io.*;

public class FileConsoleWriter {
    private FileWriter fileWriter;

    public static void main(String[] args) {

    }

    public FileConsoleWriter(String filename) throws IOException {
        fileWriter = new FileWriter(filename);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        fileWriter = new FileWriter(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException {
        fileWriter = new FileWriter(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
        fileWriter = new FileWriter(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd) {
        fileWriter = new FileWriter(fd);
    }

    public void write(char[] cbuf, int off, int len) throws IOException {
        fileWriter.write(cbuf, off, len);
        fileWriter.close();
        String result = "";
        for (int i = off; i < off+len; i++) {
            result = result + cbuf[i];
        }
        System.out.println(result);
    }

    public void write(int c) throws IOException {
        fileWriter.write(c);
        fileWriter.close();
        String result = String.valueOf(c);
        System.out.println(result);
    }

    public void write(String str) throws IOException {
        fileWriter.write(str);
        fileWriter.close();
        System.out.println(str);
    }

    public void write(String str, int off, int len) throws IOException {
        fileWriter.write(str, off, len);
        fileWriter.close();
        String result = str.substring(off, len+off);
        System.out.println(result);
    }

    public void write(char[] cbuf) throws IOException {
        fileWriter.write(cbuf);
        fileWriter.close();
        String result = "";
        for (int i = 0; i < cbuf.length; i++) {
            result = result + cbuf[i];
        }
        System.out.println(result);
    }

    public void close() throws IOException {
        fileWriter.close();
    }

}
