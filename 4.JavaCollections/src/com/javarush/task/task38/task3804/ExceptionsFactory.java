package com.javarush.task.task38.task3804;

public class ExceptionsFactory {
    public static Throwable exc(Enum exceptionType) {
        if (exceptionType == null) return new IllegalArgumentException();
        if (exceptionType instanceof ExceptionApplicationMessage) {
            char[] ch = exceptionType.name().toLowerCase().replace("_"," ").toCharArray();
            ch[0] = Character.toUpperCase(ch[0]);
            return new Exception(new String(ch));
        }
        if (exceptionType instanceof ExceptionDBMessage) {
            char[] ch = exceptionType.name().toLowerCase().replace("_"," ").toCharArray();
            ch[0] = Character.toUpperCase(ch[0]);
            return new RuntimeException(new String(ch));
        }
        if (exceptionType instanceof ExceptionUserMessage) {
            char[] ch = exceptionType.name().toLowerCase().replace("_"," ").toCharArray();
            ch[0] = Character.toUpperCase(ch[0]);
            return new Error(new String(ch));
        }

        return new IllegalArgumentException();

    }
}
