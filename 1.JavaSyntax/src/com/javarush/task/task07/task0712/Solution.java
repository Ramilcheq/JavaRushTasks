package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int min = 1000;
        int max = 0;
        int minIndex = 0;
        int maxIndex = 0;
        for (int i = 0; i < 10; i++) {
            list.add(reader.readLine());
            if (list.get(i).length() < min) {
                min = list.get(i).length();
                minIndex = i;
            }
            if (list.get(i).length() > max) {
                max = list.get(i).length();
                maxIndex = i;
            }
        }
        if (minIndex < maxIndex) System.out.println(list.get(minIndex));
        else System.out.println(list.get(maxIndex));

    }
}
