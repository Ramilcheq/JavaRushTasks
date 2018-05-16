package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

/*
Алгоритмы-числа
*/
public class Solution {

    public static long[] getNumbers(long N) {

        List<Long> longs = ArmstrongNumbersMultiSetLongOpt.generate(DigitAmount(N) + 1);

       /* long pow = 0;

        for (long i = 1; i < N + 1; i++) {

            if (GetDigits(i) != null) {
                ArrayList<Integer> digits = GetDigits(i);
                int DigAmount = digits.size();

                for (int j = DigAmount - 1; j >= 0; j--) {
                    pow += Power(digits.get(j), DigAmount);
                    /*if (pow > i) {
                        pow = 0;
                        break;
                    }
                }
                if (DigitAmount(pow) == DigAmount) {
                    long num = pow;
                    ArrayList<Integer> PowDigits = new ArrayList<>();
                    while (num != 0) {
                        PowDigits.add((int) num % 10);
                        num = num / 10;
                    }
                    Collections.sort(digits);
                    Collections.sort(PowDigits);
                    if (digits.equals(PowDigits)) longs.add(pow);
                    //System.out.println(pow + " " + (System.currentTimeMillis() - time));
                }
                pow = 0;
            }
        }*/
        int i = 0;
        while (i < longs.size()) {
            if (longs.get(i) >= N) {
                longs.remove(i);
            } else {
                i++;
            }
        }
        long[] result = new long[longs.size()];

        for (int w = 0; w < result.length; w++) {
            result[w] = longs.get(w);
        }


        return result;
    }

    public static void main(String[] args) {
        long num = 1634L;
        long[] longs = getNumbers(num);
        //System.out.println(GetDigits(num).toString() + "  " + MaxDigit(GetDigits(num)));

        for (int i = 0; i < longs.length; i++) {
            System.out.print(longs[i] + " ");
        }

    }

    public static ArrayList<Integer> GetDigits(long num) {

        ArrayList<Integer> digits = new ArrayList<>();
        int prev = 10;

        while (num != 0) {
            int ostatok = (int) num % 10;
            if (ostatok > prev && prev != 0) return null;
            digits.add((int) ostatok);
            num = num / 10;
            prev = ostatok;
        }
        return digits;
    }

    public static int DigitAmount(long num) {
        int result = 0;
        while (num != 0) {
            result += 1;
            num = num / 10;
        }
        return result;
    }

    public static long Power(int i, int j) {
        if (j == 1) return i;
        else return i * Power(i, j - 1);
    }


    public static int MaxDigit(ArrayList<Integer> A) {

        int maxDigit = 0;

        for (int i : A) {
            if (maxDigit < i) maxDigit = i;
        }

        return maxDigit;
    }
}
