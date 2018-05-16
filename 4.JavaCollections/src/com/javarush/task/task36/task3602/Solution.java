package com.javarush.task.task36.task3602;

import java.util.Collections;
import java.util.LinkedList;

/* 
Найти класс по описанию
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        Class[] classes = Collections.class.getDeclaredClasses();
        Class result = null;
        for (Class c : classes) {
            if (c.getName().equals("java.util.Collections$EmptyList")) result = c;
        }
        return result;
    }
}
