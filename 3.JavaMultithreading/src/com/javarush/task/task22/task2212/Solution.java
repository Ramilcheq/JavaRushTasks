package com.javarush.task.task22.task2212;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        Pattern p1 = Pattern.compile("(?=(^([^\\d]*?\\d){12}$))^\\+");
        Pattern p2 = Pattern.compile("");
        Matcher m = p1.matcher(telNumber);
        return m.matches();
    }

    public static void main(String[] args) {
        String s = "+380501234567";
        s = "+123456789111";
        System.out.println(s+" "+checkTelNumber(s)+" need true");
        s = "38xx501A34567";
        System.out.println(s+" "+checkTelNumber(s)+" need fa");
        s = "3805012345";
        System.out.println(s+" "+checkTelNumber(s)+" need true");
        s = "+380501234567";
        System.out.println(s+" "+checkTelNumber(s)+" need true");
        s = "++380501234567";
        System.out.println(s+" "+checkTelNumber(s)+" need fa");
        s = "+38(0501234567";
        System.out.println(s+" "+checkTelNumber(s)+" need fa");
        s = "+38)050(1234567";
        System.out.println(s+" "+checkTelNumber(s)+" need fa");
        s = "+38(050)1234567";
        System.out.println(s+" "+checkTelNumber(s)+" need true");
        s = "+38(05)1234567";
        System.out.println(s+" "+checkTelNumber(s)+" need fa");
        s = "(3)80501234567";
        System.out.println(s+" "+checkTelNumber(s)+" need fa");
        s = "(380)501234567";
        System.out.println(s+" "+checkTelNumber(s)+" need fa");
        s = "380-50123-45";
        System.out.println(s+" "+checkTelNumber(s)+" need true");
        s = "(380)501-234567";
        System.out.println(s+" "+checkTelNumber(s)+" need fa");
        s = "(38-0)501234567";
        System.out.println(s+" "+checkTelNumber(s)+" need fa");
        s = "380-(501)234567";
        System.out.println(s+" "+checkTelNumber(s)+" need fa");
        s = "380(50-1)234567";
        System.out.println(s+" "+checkTelNumber(s)+" need fa");
        s = "380(501)(23)4567";
        System.out.println(s+" "+checkTelNumber(s)+" need fa");
        s = "+38050123(456)7";
        System.out.println(s+" "+checkTelNumber(s)+" need true");
        s = "+38050123(456)76";
        System.out.println(s+" "+checkTelNumber(s)+" need fa");
        s = "+380501234(567)";
        System.out.println(s+" "+checkTelNumber(s)+" need fa");
        s = "3-805-0123-45";
        System.out.println(s+" "+checkTelNumber(s)+" need fa");
        s = "-3805-012345";
        System.out.println(s+" "+checkTelNumber(s)+" need fa");
        s = "3805-012345-";
        System.out.println(s+" "+checkTelNumber(s)+" need fa");
        s = "+380501234567";
        System.out.println(s+" "+checkTelNumber(s)+" need true");
        s = "+38(050)1234567";
        System.out.println(s+" "+checkTelNumber(s)+" need true");
        s = "+38(05)01234567";
        System.out.println(s+" "+checkTelNumber(s)+" need fa");
        s = "+38(0501)234567";
        System.out.println(s+" "+checkTelNumber(s)+" need fa");
        s = "+38050123-45-67";
        System.out.println(s+" "+checkTelNumber(s)+" need true");
        s = "050123-4567";
        System.out.println(s+" "+checkTelNumber(s)+" need true");
        s = "+38)050(1234567";
        System.out.println(s+" "+checkTelNumber(s)+" need fa");
        s = "+38(050)1-23-45-6-7";
        System.out.println(s+" "+checkTelNumber(s)+" need fa");
        s = "050ххх4567";
        System.out.println(s+" "+checkTelNumber(s)+" need fa");
        s = "050123456";
        System.out.println(s+" "+checkTelNumber(s)+" need fa");
        s = "+38-(050)1234567";
        System.out.println(s+" "+checkTelNumber(s)+" need fa");
        s = "+38((050)1234567";
        System.out.println(s+" "+checkTelNumber(s)+" need fa");
        s = "+5(0--5)1234567";
        System.out.println(s+" "+checkTelNumber(s)+" need fa");
        s = "7-4-4123689-5";
        System.out.println(s+" "+checkTelNumber(s)+" need fa");
        s = "1-23456789-0";
        System.out.println(s+" "+checkTelNumber(s)+" need true");
        s = "+38051202(345)7";
        System.out.println(s+" "+checkTelNumber(s)+" need true");
        s = "+38051202(345)-7";
        System.out.println(s+" "+checkTelNumber(s)+" need true");
        s = "+-313450531202";
        System.out.println(s+" "+checkTelNumber(s)+" need true");
        s = "+313450--531202";
        System.out.println(s+" "+checkTelNumber(s)+" need fa");
    }
}
