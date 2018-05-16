package com.javarush.task.task17.task1711;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    int KolPotokov = (args.length - 1) / 3;
                    for (int i = 0; i < KolPotokov; i++) {
                        String name = args[i * 3 + 1];
                        String sex = args[i * 3 + 2];
                        String bd = args[i * 3 + 3];

                        Sex s = (sex.equals("м")) ? Sex.MALE : Sex.FEMALE;
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                        try {
                            Date dr = dateFormat.parse(bd);
                            if (s == Sex.FEMALE) allPeople.add(Person.createFemale(name, dr));
                            if (s == Sex.MALE) allPeople.add(Person.createMale(name, dr));
                        } catch (Exception e) {
                            System.out.println("Не могу парсить дату");
                        }
                        System.out.println(allPeople.size() - 1);
                    }
                    break;
                }

            case "-u":
                synchronized (allPeople) {
                    int KolPotokov = (args.length - 1) / 4;
                    for (int i = 0; i < KolPotokov; i++) {
                        String id = args[i * 4 + 1];
                        String name = args[i * 4 + 2];
                        String sex = args[i * 4 + 3];
                        String bd = args[i * 4 + 4];
                        int Id = Integer.parseInt(id);
                        String Name = name;
                        Sex s = (sex.equals("м")) ? Sex.MALE : Sex.FEMALE;
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                        try {
                            Date dr = dateFormat.parse(bd);
                            allPeople.get(Id).setBirthDay(dr);
                        } catch (Exception e) {
                            System.out.println("Не могу парсить дату");
                        }
                        allPeople.get(Id).setName(name);
                        if (s == Sex.FEMALE) allPeople.get(Id).setSex(Sex.FEMALE);
                        if (s == Sex.MALE) allPeople.get(Id).setSex(Sex.MALE);
                    }

                }
                break;

            case "-d":
                synchronized (allPeople) {
                    int KolPotokov = (args.length - 1);
                    for (int i = 0; i < KolPotokov; i++) {
                        int id = Integer.parseInt(args[i + 1]);
                        allPeople.get(id).setSex(null);
                        allPeople.get(id).setBirthDay(null);
                        allPeople.get(id).setName(null);
                    }
                }
                break;

            case "-i":
                synchronized (allPeople) {
                    int KolPotokov = (args.length - 1);
                    for (int i = 0; i < KolPotokov; i++) {
                        int id = Integer.parseInt(args[i + 1]);
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                        String chel = allPeople.get(id).getName() + " ";
                        chel = (allPeople.get(id).getSex() == Sex.MALE) ? chel + "м" + " " : chel + "ж" + " ";
                        try {
                            Date bd = allPeople.get(id).getBirthDay();
                            chel = chel + dateFormat.format(bd);
                        } catch (Exception e) {
                            System.out.println("Не могу парсить дату");
                        }
                        System.out.println(chel);
                    }
                }
                break;

        }
    }
}
