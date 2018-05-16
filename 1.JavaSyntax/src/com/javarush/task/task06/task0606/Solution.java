package com.javarush.task.task06.task0606;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(r.readLine());
        even = 0;
        odd = 0;
        int celoe = 1; int ostatok;
        while (celoe>0)
        {
            celoe = q / 10;
            ostatok = q % 10;
            //int w = Character.getNumericValue(String.valueOf(q).charAt(i));
            if (ostatok % 2 == 0) even += 1;
            else odd += 1;
            q = celoe;
        }
        System.out.println("Even: " + even + " " + "Odd: " + odd);
    }
}
