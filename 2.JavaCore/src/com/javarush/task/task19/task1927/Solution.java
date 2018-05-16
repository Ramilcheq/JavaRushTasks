package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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

        /*StringBuilder stringBuilder = new StringBuilder(result);
        stringBuilder.insert(15, "JavaRush - курсы Java онлайн\n");
        stringBuilder.insert(59, "JavaRush - курсы Java онлайн\n");
        String reverseString = stringBuilder.toString();*/

        String[] res = result.split("\\n");
        int i = 0;

        for (String r : res) {
            i++;
            System.out.println(r);
            if (i % 2 == 0) System.out.println("JavaRush - курсы Java онлайн");
        }

        //выводим ее в консоль
        //System.out.println(reverseString);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
