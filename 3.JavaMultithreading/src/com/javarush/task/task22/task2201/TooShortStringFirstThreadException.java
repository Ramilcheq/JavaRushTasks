package com.javarush.task.task22.task2201;

public class TooShortStringFirstThreadException extends RuntimeException {
    @Override
    public synchronized Throwable getCause() {
        return new StringIndexOutOfBoundsException(-1);
    }
}
