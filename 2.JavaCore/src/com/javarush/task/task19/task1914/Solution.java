package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.*;
import java.lang.Math;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String result = outputStream.toString();
        System.setOut(consoleStream);

        /*Pattern p = Pattern.compile("[0-9]+");
        Matcher m = p.matcher(result);
        result = "";
        while (m.find()) result += m.group();*/

        //result = result.substring(0, result.length() - 1);
        String[] res = result.split(" "); //result.replaceAll("(\\D+$)", "").split("\\s");
        int q = Integer.parseInt(res[0]);
        int w = Integer.parseInt(res[2]);
        int e;
        switch (res[1]) {

            case "-":
                e = q - w;
                result = q + " - " + w + " = " + e;
                break;
            case "*":
                e = q *w;
                result = q + " * " + w + " = " + e;
                break;
            case "+":
                e = q + w;
                result = q + " + " + w + " = " + e;
                break;
        }

        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

