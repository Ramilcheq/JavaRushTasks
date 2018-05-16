package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        File fileRoot = new File(root);
        List<String> result = new ArrayList<>();
        ArrayDeque<File> queueFiles = new ArrayDeque<>();

        for (File file : fileRoot.listFiles()) {
            queueFiles.add(file);
        }

        while (!queueFiles.isEmpty()) {
            File curFile = queueFiles.poll();
            if (curFile.isFile()) {
                result.add(curFile.getAbsolutePath());
            } else {
                for (File file : curFile.listFiles()) {
                    queueFiles.add(file);
                }
            }
        }

        return result;

    }

    public static void main(String[] args) throws IOException {
        for (String s : getFileTree("e:/!downloads")) {
            System.out.println(s);
        }
    }
}
