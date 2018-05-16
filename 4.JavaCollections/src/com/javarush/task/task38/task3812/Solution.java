package com.javarush.task.task38.task3812;

/* 
Обработка аннотаций
*/

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Solution {
    public static void main(String[] args) {
        printFullyQualifiedNames(Solution.class);
        printFullyQualifiedNames(SomeTest.class);

        printValues(Solution.class);
        printValues(SomeTest.class);
    }

    public static boolean printFullyQualifiedNames(Class c) {
        PrepareMyTest p = (PrepareMyTest) c.getAnnotation(PrepareMyTest.class);
        if (p == null) return false;
        else {
            for (String s : p.fullyQualifiedNames()) {
                System.out.println(s);
            }
            return true;
        }
    }

    public static boolean printValues(Class c) {
        PrepareMyTest p = (PrepareMyTest) c.getAnnotation(PrepareMyTest.class);
        if (p == null) return false;
        else {
            for (Class s : p.value()) {
                System.out.println(s.getSimpleName());
            }
            return true;
        }
    }
}
