package com.javarush.task.task39.task3913;

import java.nio.file.Paths;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        LogParser logParser = new LogParser(Paths.get("c:/1/"));
        /*System.out.println(logParser.getNumberOfUniqueIPs(new Date(1), new Date()));
        System.out.println(logParser.getUniqueIPs(null, null));
        System.out.println(logParser.getIPsForUser("Amigo",null, new Date()));
        System.out.println(logParser.getIPsForEvent(Event.WRITE_MESSAGE,null, null));
        System.out.println(logParser.getIPsForStatus(Status.FAILED,null, null));
        logParser.getAllUsers().forEach(System.out::println);
        System.out.println(logParser.getDateWhenUserLoggedFirstTime("Amigo", null, null));
        Map<Integer,Integer> q = logParser.getAllSolvedTasksAndTheirNumber(null,null);*/
        //logParser.execute("get status for user = \"Amigo\"").forEach(System.out::println);
        //logParser.execute("get ip for date = \"30.01.2014 12:56:22\"").forEach(System.out::println);
        //logParser.execute("get ip").forEach(System.out::println);
        //logParser.execute("get ip for user = \"Eduard Petrovich Morozko\" and date " +
        //        "between \"11.12.2013 0:00:00\" and \"03.01.2014 23:59:59\"").forEach(System.out::println);
        logParser.execute("get date for event = \"SOLVE_TASK\" and date " +
                        "between \"11.12.2011 0:00:00\" and \"03.01.2022 23:59:59\"").forEach(System.out::println);
    }

}