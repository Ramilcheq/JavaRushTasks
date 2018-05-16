package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> result = new HashSet<>();
        for (String str : strings) {
            result.add(shortener.getId(str));
        }
        return result;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> result = new HashSet<>();
        for (Long key : keys) {
            result.add(shortener.getString(key));
        }
        return result;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        System.out.println(strategy.getClass().getSimpleName());
        HashSet<String> randomStrings = new HashSet<>();

        for (long i = 0; i < elementsNumber; i++) {
            randomStrings.add(Helper.generateRandomString());
        }


        Shortener shortener = new Shortener(strategy);

        long start1 = new Date().getTime();
        Set<Long> ids = getIds(shortener, randomStrings);
        long finish1 = new Date().getTime();
        System.out.println(finish1 - start1);

        long start = new Date().getTime();
        Set<String> strs = getStrings(shortener,ids);
        long finish = new Date().getTime();
        System.out.println(finish - start);

        if(randomStrings.size()==strs.size()){
            System.out.println("Тест пройден.");
        }else{
            System.out.println("Тест не пройден. randomStrings.size = " + randomStrings.size()+" strs.size =  " +strs.size());
        }
    }

    public static void main(String... args) {
        StorageStrategy filemap = new FileStorageStrategy();
        StorageStrategy hashmap = new OurHashMapStorageStrategy();
        testStrategy(hashmap, 1000);
        testStrategy(filemap, 1000);
    }
}
