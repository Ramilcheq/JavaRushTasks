package com.javarush.task.task06.task0612;

/* 
Калькулятор
*/

public class Calculator {
    public static int plus(int a, int b) {
        //напишите тут ваш код
        return a+b;
    }

    public static int minus(int a, int b) {
        //напишите тут ваш код
        return a-b;
    }

    public static int multiply(int a, int b) {
        //напишите тут ваш код
        return a*b;
    }

    public static double division(int a, int b) {
        //напишите тут ваш код
        return (double)a/b;
    }

    public static double percent(int a, int b) {
        //напишите тут ваш код
        return (double)b*a/100;
    }

    public static void main(String[] args) {
        int a = 50; int b = 10;
        System.out.println(plus(a,b));
        System.out.println(minus(a,b));
        System.out.println(multiply(a,b));
        System.out.println(division(a,b));
        System.out.println(percent(a,b));
    }
}