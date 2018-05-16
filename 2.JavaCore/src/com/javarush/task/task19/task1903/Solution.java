package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
        String phone = "501234567";
        String zeroes = "";
        if (phone.length() < 10) {
            for (int i = 0; i < 10 - phone.length(); i++) zeroes += "0";
        }
        phone = zeroes + phone;
        phone = "(" + phone.substring(0, 3) + ")" + phone.substring(3, 6) + "-" + phone.substring(6, 8) + "-" + phone.substring(8, 10);
        System.out.println(phone);
    }

    public static class IncomeDataAdapter implements Customer, Contact {
        private IncomeData data;

        public IncomeDataAdapter(IncomeData id) {
            this.data = id;
        }

        @Override
        public String getCompanyName() {
            return data.getCompany();
        }

        @Override
        public String getCountryName() {
            return countries.get(data.getCountryCode());
        }

        @Override
        public String getName() {
            return data.getContactLastName() + ", " + data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {
            String phone = String.valueOf(data.getPhoneNumber());
            String zeroes = "";
            if (phone.length() < 10) {
                for (int i = 0; i < 10 - phone.length(); i++) zeroes += "0";
            }
            phone = zeroes + phone;
            phone = "(" + phone.substring(0, 3) + ")" + phone.substring(3, 6) + "-" + phone.substring(6, 8) + "-" + phone.substring(8, 10);
            return "+" + data.getCountryPhoneCode() + phone;
        }
    }


    public static interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }
}