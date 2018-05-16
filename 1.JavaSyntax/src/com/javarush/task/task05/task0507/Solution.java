package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        int amount = 0;
        String num;
        while (!(num = bufferedReader.readLine()).equals("-1")) {
            sum += Integer.parseInt(num);
            amount+=1;
        }
        System.out.println(sum*1.0/amount);
    }
}

