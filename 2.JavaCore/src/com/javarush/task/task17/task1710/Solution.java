package com.javarush.task.task17.task1710;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        String param = args[0];
        switch (param) {
            case "-c": {
                try {
                    String name = args[1];
                    String sex = args[2];
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                    Date bd = dateFormat.parse(args[3]);
                    switch (sex) {
                        case "ж": allPeople.add(Person.createFemale(name, bd)); break;
                        case "м": allPeople.add(Person.createMale(name, bd)); break;
                    }

                }
                catch (Exception e) {
                    System.out.println("Введите параметры!");
                }
                System.out.println(allPeople.size() - 1);
                break;
            }

            case "-u": {
                int id = Integer.parseInt(args[1]);
                String name = args[2];
                String sex = args[3];
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                try {
                    Date bd = dateFormat.parse(args[4]);
                    allPeople.get(id).setBirthDay(bd);
                }
                catch (Exception e) {System.out.println("Не могу парсить дату");}
                allPeople.get(id).setName(name);
                switch (sex) {
                    case "ж": allPeople.get(id).setSex(Sex.FEMALE); break;
                    case "м": allPeople.get(id).setSex(Sex.MALE); break;
                }
                break;
            }

            case "-d": {
                int id = Integer.parseInt(args[1]);
                allPeople.get(id).setSex(null);
                allPeople.get(id).setBirthDay(null);
                allPeople.get(id).setName(null);
                break;
            }

            case "-i": {
                int id = Integer.parseInt(args[1]);
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                String chel = allPeople.get(id).getName() + " ";
                switch (allPeople.get(id).getSex()) {
                    case MALE: chel = chel + "м" + " "; break;
                    case FEMALE: chel = chel + "ж" + " "; break;
                }
                try {
                    Date bd = allPeople.get(id).getBirthDay();
                    chel = chel + dateFormat.format(bd);
                }
                catch (Exception e) {System.out.println("Не могу парсить дату");}
                System.out.println(chel);
            }

        }
    }
}
