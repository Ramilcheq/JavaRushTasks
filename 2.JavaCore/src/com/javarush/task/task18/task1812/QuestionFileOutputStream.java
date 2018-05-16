package com.javarush.task.task18.task1812;

import java.io.*;

/* 
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {
    private AmigoOutputStream original;

    public QuestionFileOutputStream(AmigoOutputStream a) {
        this.original = a;
    }

    public void flush() throws IOException {
        original.flush();
    }

    public void write(int b) throws IOException {
        original.write(b);
    }

    public void write(byte[] b) throws IOException {
        original.write(b);
    }

    public void write(byte[] b, int off, int len) throws IOException {
        original.write(b, off, len);
    }

    public void close() throws IOException {
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        String str = (new BufferedReader(new InputStreamReader(System.in))).readLine();
        if (str.equals("Д")) original.close();
    }
}

