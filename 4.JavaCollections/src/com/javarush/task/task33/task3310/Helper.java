package com.javarush.task.task33.task3310;

import java.security.SecureRandom;
import java.math.BigInteger;

public class Helper {

    public static String generateRandomString() {
        SecureRandom random = new SecureRandom();
        return new BigInteger(130, random).toString(32);
    }

    public static void printMessage(String message){
        System.out.println(message);
    }
}
