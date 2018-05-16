package com.javarush.task.task22.task2201;

public class TooShortStringSecondThreadException extends RuntimeException {
    @Override
    public synchronized Throwable getCause() {
        return new StringIndexOutOfBoundsException(-1);
    }
}
