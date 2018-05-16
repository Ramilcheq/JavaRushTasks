package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
        //System.out.println(a1[0][3]);
    }

    public static int getRectangleCount(byte[][] a) {

        int width = a[0].length;
        int hight = a.length;
        int RectAmount = 0;

        for (int i = 0; i < hight; i++) {
            for (int j = 0; j < width; j++) {
                if (isNewRect(a, i, j)) {
                    RectAmount += 1;
                }
            }
        }

        return RectAmount;
    }

    public static boolean isNewRect(byte[][] b, int i, int j) {
        boolean result = false;

        if (b[i][j] == 1) {

            if (i == 0 && j == 0) result = true;
            if (i != 0 && j != 0) {
                if (b[i - 1][j] == 0 && b[i][j - 1] == 0) result = true;
            }
            if (i != 0 && j == 0) {
                if (b[i - 1][j] == 0) result = true;
            }
            if (i == 0 && j != 0) {
                if (b[i][j - 1] == 0) result = true;
            }

        }
        return result;
    }
}
