package com.javarush.task.task38.task3804;

/* 
Фабрика исключений
*/

import org.apache.commons.collections4.functors.ExceptionFactory;

public class Solution {
    public static Class getFactoryClass() {
        return ExceptionsFactory.class;
    }

    public static void main(String[] args) {
        ExceptionsFactory.exc(ExceptionApplicationMessage.UNHANDLED_EXCEPTION);
    }
}