package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        ArrayList<Integer> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            list.add(Integer.parseInt(reader.readLine()));
        }
        int q = list.get(0);
        int max = 1;
        int sum = 1;
        for (int i = 1; i < 10; i++) {
            if (list.get(i) == q) {
                sum += 1;
            } else {
                if (sum > max) max = sum;
                sum = 1;
            }
            q = list.get(i);
        }
        System.out.println(sum > max ? sum : max);
    }
}