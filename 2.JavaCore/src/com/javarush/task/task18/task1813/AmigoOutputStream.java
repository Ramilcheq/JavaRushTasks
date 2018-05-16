package com.javarush.task.task18.task1813;

import java.io.*;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream {
    public static String fileName = "C:/tmp/result.txt";
    private FileOutputStream original;

    public AmigoOutputStream(FileOutputStream fileOutputStream) throws FileNotFoundException {
        super(fileName);
        this.original = fileOutputStream;
    }

    public void flush() throws IOException {
        original.flush();
    }

    public void write(byte[] b, int off, int len) throws IOException {
        original.write(b, off, len);
    }

    public void write(byte[] b) throws IOException {
        original.write(b);
    }

    public void write(int b) throws IOException {
        original.write(b);
    }

    public void close() throws IOException {
        original.flush();
        byte[] java = "JavaRush © All rights reserved.".getBytes();
        original.write(java);
        original.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

}
