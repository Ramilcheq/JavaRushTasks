package com.javarush.task.task25.task2512;

/* 
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    public Solution() {
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        cause(e);
    }

    public void cause(Throwable e) {
        if (e.getCause() == null)
            System.out.println(e);
        else {
            cause(e.getCause());
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        try {
            throw new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")));
        } catch (Exception e) {
            new Solution().uncaughtException(Thread.currentThread(), e);
        }
    }

}
