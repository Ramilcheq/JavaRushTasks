package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.util.Random;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        //System.out.println(password.toString());

        for (int i = 0; i < 100; i++) {

            String s = new String(getRandomDigit());
            System.out.println(s);
        }
    }

    public static ByteArrayOutputStream getPassword() {

        return null;
    }

    public static byte[] getRandomDigit(){
        Random random = new Random();

        return null;//= {(byte) (random.nextInt(10) + 48)};
    }
}