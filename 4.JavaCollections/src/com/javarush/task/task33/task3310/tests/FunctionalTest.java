package com.javarush.task.task33.task3310.tests;

import com.google.common.annotations.VisibleForTesting;
import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.*;
import org.junit.Assert;
import org.junit.Test;

public class FunctionalTest {
    public void testStorage(Shortener shortener) {
        String s1 = "джигурда";
        String s2 = "пизда";
        String s3 = "джигурда";

        Long id1 = shortener.getId(s1);
        Long id2 = shortener.getId(s2);
        Long id3 = shortener.getId(s3);

        Assert.assertNotEquals(id1, id2);
        Assert.assertNotEquals(id3, id2);
        Assert.assertEquals(id1,id3);

        String s11 = shortener.getString(id1);
        String s21 = shortener.getString(id2);
        String s31 = shortener.getString(id3);

        Assert.assertEquals(s1,s11);
        Assert.assertEquals(s2,s21);
        Assert.assertEquals(s3,s31);
    }

    @Test
    public void testHashMapStorageStrategy() {
        StorageStrategy hashmap=new HashMapStorageStrategy();
        Shortener shortener = new Shortener(hashmap);
        testStorage(shortener);
    }

    @Test
    public void testOurHashMapStorageStrategy() {
        StorageStrategy hashmap = new OurHashMapStorageStrategy();
        Shortener shortener = new Shortener(hashmap);
        testStorage(shortener);
    }

    @Test
    public void testFileStorageStrategy() {
        StorageStrategy filemap = new FileStorageStrategy();
        Shortener shortener = new Shortener(filemap);
        testStorage(shortener);
    }

    @Test
    public void testHashBiMapStorageStrategy() {
        StorageStrategy bimap = new HashBiMapStorageStrategy();
        Shortener shortener = new Shortener(bimap);
        testStorage(shortener);
    }

    @Test
    public void testDualHashBidiMapStorageStrategy() {
        StorageStrategy dual = new DualHashBidiMapStorageStrategy();
        Shortener shortener = new Shortener(dual);
        testStorage(shortener);
    }

    @Test
    public void testOurHashBiMapStorageStrategy() {
        StorageStrategy ourhashbimap = new OurHashBiMapStorageStrategy();
        Shortener shortener = new Shortener(ourhashbimap);
        testStorage(shortener);
    }
}
