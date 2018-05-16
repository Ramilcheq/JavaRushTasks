package com.javarush.task.task39.task3913;

import java.io.*;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;

public class MyLog {
    protected String ip;
    protected String user;
    protected Date date;
    protected Event event;
    protected int taskNumber;
    protected Status status;

    public static ArrayList<MyLog> getAllLogs(Path logDir) {
        ArrayList<MyLog> result = new ArrayList<>();
        String[] logFiles = logDir.toFile().list(new FilenameFilter() {
            @Override
            public boolean accept(File folder, String name) {
                return name.endsWith(".log");
            }
        });
        if (logFiles.length == 0) return null;
        for (String logFile : logFiles) {
            try {
                FileInputStream fstream = new FileInputStream(logDir.toString() + File.separator + logFile);
                BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
                String strLine;
                while ((strLine = br.readLine()) != null) {
                    String[] splitted = strLine.split("\t");
                    MyLog myLog = new MyLog();
                    myLog.ip = splitted[0];
                    myLog.user = splitted[1];
                    myLog.date = myLog.getDate(splitted[2]);
                    String[] ev = splitted[3].split(" ");
                    myLog.event = Event.valueOf(ev[0]);
                    myLog.taskNumber = ev.length > 1 ? Integer.parseInt(ev[1]) : 0;
                    myLog.status = Status.valueOf(splitted[splitted.length - 1]);
                    result.add(myLog);
                }
            } catch (IOException e) {
                System.out.println("Ошибка");
            }
        }
        return result;
    }

    public static Date getDate(String strDate) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        try {
            return format.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean chekField(String[] strings, String field) {
        if (field == null) return true;
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].equals(field)) return true;
        }
        return false;
    }

    public static ArrayList<MyLog> getRecords(Path logDir, String ip, String user, Date after, Date before, Event event, int taskNumber, Status status) {

        ArrayList<MyLog> myLogs = getAllLogs(logDir);
        ArrayList<MyLog> myLogsFiltered = new ArrayList<>();

        if (after == null) after = new Date(0);
        if (before == null) before = new Date(9999999999999999L);
        boolean flag = true;
        for (MyLog mylog : myLogs) {
            flag = flag && (ip == null) || flag && mylog.ip.equals(ip);
            flag = flag && (user == null) || flag && mylog.user.equals(user);
            flag = flag && (event == null) || flag && mylog.event == event;
            flag = flag && (taskNumber == 0) || flag && mylog.taskNumber == taskNumber;
            flag = flag && (status == null) || flag && mylog.status == status;
            if ((mylog.date.after(after) || mylog.date.equals(after)) && (mylog.date.before(before) ||
                    mylog.date.equals(before)) && flag) myLogsFiltered.add(mylog);
            flag = true;
        }
        return myLogsFiltered;
    }


}
