package com.javarush.task.task20.task2021;

import java.io.*;

/* 
Сериализация под запретом
*/
public class Solution implements Serializable {
    public static class SubSolution extends Solution {


        //@Override
        private void writeObject(ObjectOutputStream out) throws IOException {
            throw new NotSerializableException();
        }

        //@Override
        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
            throw new NotSerializableException();
        }
    }

    public static void main(String[] args) {

    }
}
