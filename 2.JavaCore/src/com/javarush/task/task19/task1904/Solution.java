package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {
        String s = "Иванов Иван Иванович 31 12 1950";
        String[] strings = s.split(" ");
        GregorianCalendar c = new GregorianCalendar(Integer.parseInt(strings[5]), Integer.parseInt(strings[4]) - 1, Integer.parseInt(strings[3]));
        //c.set(Integer.parseInt(strings[5]), Integer.parseInt(strings[4]) - 1, Integer.parseInt(strings[3]));                     //вводим дату
        Date d = c.getTime();
        Person person = new Person(strings[1], strings[2], strings[0], d);
        System.out.println(person.toString());
    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner scanner) {
            this.fileScanner = scanner;
        }

        @Override
        public Person read() throws IOException {
            String s = fileScanner.nextLine();
            String[] strings = s.split(" ");
            GregorianCalendar c = new GregorianCalendar(Integer.parseInt(strings[5]), Integer.parseInt(strings[4]) - 1, Integer.parseInt(strings[3]));
            //c.set(Integer.parseInt(strings[5]), Integer.parseInt(strings[4]) - 1, Integer.parseInt(strings[3]));                     //вводим дату
            Date d = c.getTime();
            Person person = new Person(strings[1], strings[2], strings[0], d);
            return person;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
