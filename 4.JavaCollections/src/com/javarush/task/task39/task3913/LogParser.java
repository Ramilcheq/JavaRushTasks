package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.*;

import java.nio.file.Path;
import java.util.*;

public class LogParser implements IPQuery, UserQuery, DateQuery, EventQuery, QLQuery {
    private Path logDir;

    public LogParser(Path logDir) {
        this.logDir = logDir;
    }

    // ========================================================================================
    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        ArrayList<MyLog> logs = MyLog.getRecords(logDir, null, null, after, before, null, 0, null);
        TreeSet<String> result = new TreeSet<>();
        logs.forEach(myLog -> result.add(myLog.ip));
        return result.size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        ArrayList<MyLog> logs = MyLog.getRecords(logDir, null, null, after, before, null, 0, null);
        TreeSet<String> result = new TreeSet<>();
        logs.forEach(myLog -> result.add(myLog.ip));
        return result;
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        ArrayList<MyLog> logs = MyLog.getRecords(logDir, null, user, after, before, null, 0, null);
        TreeSet<String> result = new TreeSet<>();
        logs.forEach(myLog -> result.add(myLog.ip));
        return result;
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        ArrayList<MyLog> logs = MyLog.getRecords(logDir, null, null, after, before, event, 0, null);
        TreeSet<String> result = new TreeSet<>();
        logs.forEach(myLog -> result.add(myLog.ip));
        return result;
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        ArrayList<MyLog> logs = MyLog.getRecords(logDir, null, null, after, before, null, 0, status);
        TreeSet<String> result = new TreeSet<>();
        logs.forEach(myLog -> result.add(myLog.ip));
        return result;
    }


    @Override
    public Set<String> getAllUsers() {
        ArrayList<MyLog> logs = MyLog.getRecords(logDir, null, null, null, null, null, 0, null);
        TreeSet<String> result = new TreeSet<>();
        logs.forEach(myLog -> result.add(myLog.user));
        return result;
    }

    @Override
    public int getNumberOfUsers(Date after, Date before) {
        ArrayList<MyLog> logs = MyLog.getRecords(logDir, null, null, after, before, null, 0, null);
        TreeSet<String> result = new TreeSet<>();
        logs.forEach(myLog -> result.add(myLog.user));
        return result.size();
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {
        ArrayList<MyLog> logs = MyLog.getRecords(logDir, null, user, after, before, null, 0, null);
        TreeSet<Event> result = new TreeSet<>();
        logs.forEach(myLog -> result.add(myLog.event));
        return result.size();
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        ArrayList<MyLog> logs = MyLog.getRecords(logDir, ip, null, after, before, null, 0, null);
        TreeSet<String> result = new TreeSet<>();
        logs.forEach(myLog -> result.add(myLog.user));
        return result;
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
        ArrayList<MyLog> logs = MyLog.getRecords(logDir, null, null, after, before, Event.LOGIN, 0, null);
        TreeSet<String> result = new TreeSet<>();
        logs.forEach(myLog -> result.add(myLog.user));
        return result;
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        ArrayList<MyLog> logs = MyLog.getRecords(logDir, null, null, after, before, Event.DOWNLOAD_PLUGIN, 0, null);
        TreeSet<String> result = new TreeSet<>();
        logs.forEach(myLog -> result.add(myLog.user));
        return result;
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {
        ArrayList<MyLog> logs = MyLog.getRecords(logDir, null, null, after, before, Event.WRITE_MESSAGE, 0, null);
        TreeSet<String> result = new TreeSet<>();
        logs.forEach(myLog -> result.add(myLog.user));
        return result;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        ArrayList<MyLog> logs = MyLog.getRecords(logDir, null, null, after, before, Event.SOLVE_TASK, 0, null);
        TreeSet<String> result = new TreeSet<>();
        logs.forEach(myLog -> result.add(myLog.user));
        return result;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        ArrayList<MyLog> logs = MyLog.getRecords(logDir, null, null, after, before, Event.SOLVE_TASK, task, null);
        TreeSet<String> result = new TreeSet<>();
        logs.forEach(myLog -> result.add(myLog.user));
        return result;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        ArrayList<MyLog> logs = MyLog.getRecords(logDir, null, null, after, before, Event.DONE_TASK, 0, null);
        TreeSet<String> result = new TreeSet<>();
        logs.forEach(myLog -> result.add(myLog.user));
        return result;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        ArrayList<MyLog> logs = MyLog.getRecords(logDir, null, null, after, before, Event.DONE_TASK, task, null);
        TreeSet<String> result = new TreeSet<>();
        logs.forEach(myLog -> result.add(myLog.user));
        return result;
    }

    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before) {
        ArrayList<MyLog> logs = MyLog.getRecords(logDir, null, user, after, before, event, 0, null);
        TreeSet<Date> result = new TreeSet<>();
        logs.forEach(myLog -> result.add(myLog.date));
        return result;
    }

    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) {
        ArrayList<MyLog> logs = MyLog.getRecords(logDir, null, null, after, before, null, 0, Status.FAILED);
        TreeSet<Date> result = new TreeSet<>();
        logs.forEach(myLog -> result.add(myLog.date));
        return result;
    }

    @Override
    public Set<Date> getDatesWhenErrorHappened(Date after, Date before) {
        ArrayList<MyLog> logs = MyLog.getRecords(logDir, null, null, after, before, null, 0, Status.ERROR);
        TreeSet<Date> result = new TreeSet<>();
        logs.forEach(myLog -> result.add(myLog.date));
        return result;
    }

    @Override
    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before) {
        ArrayList<MyLog> logs = MyLog.getRecords(logDir, null, user, after, before, Event.LOGIN, 0, null);
        TreeSet<Date> result = new TreeSet<>();
        logs.forEach(myLog -> result.add(myLog.date));
        return result.size() != 0 ? result.iterator().next() : null;
    }

    @Override
    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before) {
        ArrayList<MyLog> logs = MyLog.getRecords(logDir, null, user, after, before, Event.SOLVE_TASK, task, null);
        TreeSet<Date> result = new TreeSet<>();
        logs.forEach(myLog -> result.add(myLog.date));
        return result.size() != 0 ? result.iterator().next() : null;
    }

    @Override
    public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before) {
        ArrayList<MyLog> logs = MyLog.getRecords(logDir, null, user, after, before, Event.DONE_TASK, task, null);
        TreeSet<Date> result = new TreeSet<>();
        logs.forEach(myLog -> result.add(myLog.date));
        return result.size() != 0 ? result.iterator().next() : null;
    }

    @Override
    public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before) {
        ArrayList<MyLog> logs = MyLog.getRecords(logDir, null, user, after, before, Event.WRITE_MESSAGE, 0, null);
        TreeSet<Date> result = new TreeSet<>();
        logs.forEach(myLog -> result.add(myLog.date));
        return result;
    }

    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before) {
        ArrayList<MyLog> logs = MyLog.getRecords(logDir, null, user, after, before, Event.DOWNLOAD_PLUGIN, 0, null);
        TreeSet<Date> result = new TreeSet<>();
        logs.forEach(myLog -> result.add(myLog.date));
        return result;
    }

    @Override
    public int getNumberOfAllEvents(Date after, Date before) {
        ArrayList<MyLog> logs = MyLog.getRecords(logDir, null, null, after, before, null, 0, null);
        TreeSet<Event> result = new TreeSet<>();
        logs.forEach(myLog -> result.add(myLog.event));
        return result.size();
    }

    @Override
    public Set<Event> getAllEvents(Date after, Date before) {
        ArrayList<MyLog> logs = MyLog.getRecords(logDir, null, null, after, before, null, 0, null);
        TreeSet<Event> result = new TreeSet<>();
        logs.forEach(myLog -> result.add(myLog.event));
        return result;
    }

    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before) {
        ArrayList<MyLog> logs = MyLog.getRecords(logDir, ip, null, after, before, null, 0, null);
        TreeSet<Event> result = new TreeSet<>();
        logs.forEach(myLog -> result.add(myLog.event));
        return result;
    }

    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before) {
        ArrayList<MyLog> logs = MyLog.getRecords(logDir, null, user, after, before, null, 0, null);
        TreeSet<Event> result = new TreeSet<>();
        logs.forEach(myLog -> result.add(myLog.event));
        return result;
    }

    @Override
    public Set<Event> getFailedEvents(Date after, Date before) {
        ArrayList<MyLog> logs = MyLog.getRecords(logDir, null, null, after, before, null, 0, Status.FAILED);
        TreeSet<Event> result = new TreeSet<>();
        logs.forEach(myLog -> result.add(myLog.event));
        return result;
    }

    @Override
    public Set<Event> getErrorEvents(Date after, Date before) {
        ArrayList<MyLog> logs = MyLog.getRecords(logDir, null, null, after, before, null, 0, Status.ERROR);
        TreeSet<Event> result = new TreeSet<>();
        logs.forEach(myLog -> result.add(myLog.event));
        return result;
    }

    @Override
    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before) {
        ArrayList<MyLog> logs = MyLog.getRecords(logDir, null, null, after, before, Event.SOLVE_TASK, task, null);
        return logs.size();
    }

    @Override
    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before) {
        ArrayList<MyLog> logs = MyLog.getRecords(logDir, null, null, after, before, Event.DONE_TASK, task, null);
        return logs.size();
    }

    @Override
    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before) {
        ArrayList<MyLog> logs = MyLog.getRecords(logDir, null, null, after, before, Event.SOLVE_TASK, 0, null);
        TreeMap<Integer, Integer> result = new TreeMap<>();
        logs.forEach(myLog -> result.put(myLog.taskNumber, result.get(myLog.taskNumber) == null ? 1 : result.get(myLog.taskNumber) + 1));
        return result;
    }

    @Override
    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before) {
        ArrayList<MyLog> logs = MyLog.getRecords(logDir, null, null, after, before, Event.DONE_TASK, 0, null);
        TreeMap<Integer, Integer> result = new TreeMap<>();
        logs.forEach(myLog -> result.put(myLog.taskNumber, result.get(myLog.taskNumber) == null ? 1 : result.get(myLog.taskNumber) + 1));
        return result;
    }

    @Override
    public Set<Object> execute(String query) {
        String[] queryArray = query.split(" ");
        String field1 = queryArray[1];
        ArrayList<MyLog> logs = new ArrayList<>();
        String[] q = query.split("\"");
        if (q.length == 2) {
            logs = getLogs(query, 1);
        } else if (q.length == 1) {
            logs = getLogs(query, 0);
        } else {
            logs = getLogs(query, 2);
        }
        Set<Object> result = new TreeSet<>();
        switch (field1) {
            case "ip":
                logs.forEach(myLog -> result.add(myLog.ip));
                return result;
            case "user":
                logs.forEach(myLog -> result.add(myLog.user));
                return result;
            case "date":
                logs.forEach(myLog -> result.add(myLog.date));
                return result;
            case "event":
                logs.forEach(myLog -> result.add(myLog.event));
                return result;
            case "status":
                logs.forEach(myLog -> result.add(myLog.status));
                return result;
        }
        return result;
    }

    public ArrayList<MyLog> getLogs(String query, Integer flag) {
        if (flag == 0) return MyLog.getRecords(logDir, null, null, null, null, null, 0, null);
        String[] params = query.split(" ");
        String field2 = params[3];
        String[] params2 = query.split("\"");
        String value1 = params2[1];
        ArrayList<MyLog> result = new ArrayList<>();

        switch (field2) {
            case "ip":
                result = MyLog.getRecords(logDir, value1, null, null, null, null, 0, null);
                break;
            case "user":
                result = MyLog.getRecords(logDir, null, value1, null, null, null, 0, null);
                break;
            case "date":
                result = MyLog.getRecords(logDir, null, null, MyLog.getDate(value1), MyLog.getDate(value1), null, 0, null);
                break;
            case "event":
                result = MyLog.getRecords(logDir, null, null, null, null, Event.valueOf(value1), 0, null);
                break;
            case "status":
                result = MyLog.getRecords(logDir, null, null, null, null, null, 0, Status.valueOf(value1));
                break;
        }
        if (flag == 2) {
            Date after = MyLog.getDate(params2[3]);
            Date before = MyLog.getDate(params2[5]);
            ArrayList<MyLog> result2 = new ArrayList<>();
            result.removeIf(myLog -> myLog.date.getTime()<=after.getTime() || myLog.date.getTime()>=before.getTime());
        }
        return result;
    }

}