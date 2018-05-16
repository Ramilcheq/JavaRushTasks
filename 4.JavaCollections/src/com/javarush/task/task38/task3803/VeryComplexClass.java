package com.javarush.task.task38.task3803;

/* 
Runtime исключения (unchecked exception)
*/

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        Object a = new Object();
        int b = (int) a;
    }

    public void methodThrowsNullPointerException() {
        int[] array = null;
        System.out.println(array.length);
    }

    public static void main(String[] args) {
        VeryComplexClass o = new VeryComplexClass();
        o.methodThrowsNullPointerException ();
    }
}
