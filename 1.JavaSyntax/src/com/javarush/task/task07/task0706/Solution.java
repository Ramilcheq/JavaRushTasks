package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int nechet = 0;
        int chet = 0;
        int tmp;
        int[] doma;
        doma = new int[15];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < doma.length; i++) {
            tmp = Integer.parseInt(br.readLine());
            if (((i + 1) % 2) == 0) nechet = nechet + tmp;
            else chet = chet + tmp;
        }

        if (chet > nechet) System.out.println("В домах с четными номерами проживает больше жителей.");
        else System.out.println("В домах с нечетными номерами проживает больше жителей.");
    }
}
