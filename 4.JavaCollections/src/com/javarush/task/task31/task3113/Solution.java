package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/
public class Solution extends SimpleFileVisitor<Path> {

    public static void main(String[] args) throws IOException {
        String dir = new BufferedReader(new InputStreamReader(System.in)).readLine();
        if (!Files.isDirectory(Paths.get(dir))) {
            System.out.println(dir + " - не папка");
            return;
        }

        final Solution solution = new Solution();
        Files.walkFileTree(Paths.get(dir), solution);
        System.out.println("Всего папок - " + (solution.getDirAmount()-1));
        System.out.println("Всего файлов - " + solution.getFilesAmount());
        System.out.println("Общий размер - " + solution.getTotalBytes());
    }

    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        filesAmount += 1;
        totalBytes += Files.size(file);

        return FileVisitResult.CONTINUE;
    }

    public FileVisitResult preVisitDirectory(Path file, BasicFileAttributes attrs) throws IOException {
        if (Files.isDirectory(file)) {
            dirAmount += 1;
        }

        return FileVisitResult.CONTINUE;
    }

    public int getDirAmount() {
        return dirAmount;
    }

    public long getTotalBytes() {
        return totalBytes;
    }

    public int getFilesAmount() {
        return filesAmount;
    }

    private int dirAmount;
    private int filesAmount;
    private long totalBytes;
}
