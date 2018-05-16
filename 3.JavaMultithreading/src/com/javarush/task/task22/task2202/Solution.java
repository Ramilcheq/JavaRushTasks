package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
        System.out.println(getPartOfString("Амиго и Диего лучшие друзья!"));
    }

    public static String getPartOfString(String string) {
        try {
            int first = string.indexOf(" ") + 1;
            int second = string.indexOf(" ", first) + 1;
            int third = string.indexOf(" ", second) + 1;
            int fourth = string.indexOf(" ", third) + 1;
            if (fourth ==0) throw new TooShortStringException();
            int five = string.indexOf(" ", fourth) == -1 ? string.length() : string.indexOf(" ", fourth);
            return string.substring(first, five);
        } catch (Exception e) {
            throw new TooShortStringException();
        }
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
