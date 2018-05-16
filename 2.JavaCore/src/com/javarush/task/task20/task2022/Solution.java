package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
    private String fname;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        fname = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(fname, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Solution sol = new Solution("e:\\1.txt");
        sol.writeObject("huy pizda i djigurda");
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("e:\\3.txt"));
        out.writeObject(sol);
        out.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("e:\\3.txt"));
        Solution sol2 = (Solution) in.readObject();
        sol2.writeObject("sukanah");
        in.close();
    }
}
