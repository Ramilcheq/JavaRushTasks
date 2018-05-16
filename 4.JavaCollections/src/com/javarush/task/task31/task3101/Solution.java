package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.*;

/*
Проход по дереву файлов
*/
public class Solution {
    static final ArrayList<File> listOfFiles = new ArrayList<File>();

    public static void main(String[] args) throws IOException {
        String path = args[0];

        File file = new File(path);
        File resultFileAbsolutePath = new File(args[1]);
        File allFilesContent = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");
        FileUtils.renameFile(resultFileAbsolutePath, allFilesContent);

        searchFiles(file);
        Collections.sort(listOfFiles, Comparator.comparing(File::getName));

        FileWriter fOut = new FileWriter(allFilesContent);
        fOut.close();
        for (File curFile : listOfFiles) {
            FileInputStream fIn = new FileInputStream(curFile);
            while (fIn.available() != 0) {
                fOut.write(fIn.read());
            }
            fOut.write("\n");
            fOut.flush();
            fIn.close();
        }

    }

    public static void searchFiles(File dirOrFile) {
        //ArrayList<File> result = new ArrayList<>();

        if (dirOrFile.isDirectory()) {
            File[] listFiles = dirOrFile.listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    searchFiles(file);
                }
            }
        } else {
            if (dirOrFile.length() <= 50) listOfFiles.add(dirOrFile);
        }

    }

    /*public static ArrayList<File> sortByFname(ArrayList<File> list) {
        Collections.sort(list, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                String fileName1 = o1.getName();
                String fileName2 = o2.getName();
                return fileName1.compareTo(fileName2);
            }
        });
        return list;
    }

    public static ArrayList<File> search50BytesFilesInCurDir(File[] listFile) {
        ArrayList<File> result = new ArrayList<>();

        for (File aListFile : listFile) {
            if (aListFile.isFile() && aListFile.length() <= 50) {
                result.add(aListFile);
            }
        }
        return result;
    }*/
}
