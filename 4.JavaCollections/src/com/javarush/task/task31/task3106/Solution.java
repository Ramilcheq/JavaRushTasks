package com.javarush.task.task31.task3106;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String resultFileName = args[0];

        ArrayList<String> partsOfZipFile = new ArrayList<>();
        partsOfZipFile.addAll(Arrays.asList(args).subList(1, args.length));
        Collections.sort(partsOfZipFile);
        Vector files = new Vector(partsOfZipFile.size());
        System.out.println("Merge: ");
        for (int i = 0; i < partsOfZipFile.size(); i++) {
            files.addElement(new FileInputStream(partsOfZipFile.get(i)));
            System.out.println(partsOfZipFile.get(i));
        }

        SequenceInputStream sis = new SequenceInputStream(files.elements());
        ZipInputStream zis = new ZipInputStream(sis);
        FileOutputStream fos = new FileOutputStream(resultFileName);

        ZipEntry zipEntry = zis.getNextEntry();
        int c;
        byte[] buffer = new byte[1024];
        while ((c = zis.read(buffer)) > 0) {
            fos.write(buffer, 0, c);
            fos.flush();
        }

        sis.close();
        zis.closeEntry();
        zis.close();
        fos.close();
    }
}
