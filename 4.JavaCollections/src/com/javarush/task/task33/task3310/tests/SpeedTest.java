package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SpeedTest {
    @Test
    public void testHashMapStorage() {
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());

        Set<String> origStrings = new HashSet<>();
        for (int i = 0; i < 10000; i++) {
            origStrings.add(Helper.generateRandomString());
        }

        Set<Long> ids = new HashSet<>();
        Long time1 = getTimeForGettingIds(shortener1, origStrings, ids);
        Long time2 = getTimeForGettingIds(shortener2, origStrings, ids);
        Assert.assertTrue(time1 > time2);

        Set<String> newStrings = new HashSet<>();
        Long time11 = getTimeForGettingStrings(shortener1, ids, newStrings);
        Long time12 = getTimeForGettingStrings(shortener2, ids, newStrings);
        Assert.assertEquals(time11, time12, 30);
    }


    public long getTimeForGettingIds(Shortener shortener, Set<String> strings, Set<Long> ids) {
        long start1 = new Date().getTime();
        for (String str : strings) {
            ids.add(shortener.getId(str));
        }
        long finish1 = new Date().getTime();
        return finish1 - start1;
    }


    public long getTimeForGettingStrings(Shortener shortener, Set<Long> ids, Set<String> strings) {
        Long start = new Date().getTime();
        for (Long key : ids) {
            strings.add(shortener.getString(key));
        }
        long finish = new Date().getTime();
        return finish - start;
    }


}
