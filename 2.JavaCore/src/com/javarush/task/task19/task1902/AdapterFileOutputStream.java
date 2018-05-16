package com.javarush.task.task19.task1902;

/* 
Адаптер
*/

import java.io.FileOutputStream;
import java.io.IOException;

public class AdapterFileOutputStream implements AmigoStringWriter {
    private FileOutputStream fileOutputStream;

    public static void main(String[] args) {

    }

    public AdapterFileOutputStream(FileOutputStream amigo) {
        this.fileOutputStream = amigo;
    }

    @Override
    public void flush() throws IOException {
        fileOutputStream.flush();
    }

    @Override
    public void writeString(String b) throws IOException {
        fileOutputStream.write(b.getBytes());
    }

    @Override
    public void close() throws IOException {
        fileOutputStream.close();
    }

}

