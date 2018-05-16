package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fname1 = null;
        String fname2 = null;
        try {
            fname1 = br.readLine();
            fname2 = br.readLine();br.close();


        BufferedReader fbr1 = new BufferedReader(new InputStreamReader(new FileInputStream(fname1)));
        BufferedReader fbr2 = new BufferedReader(new InputStreamReader(new FileInputStream(fname2)));
        String line;
        int i = 0;
        while ((line = fbr1.readLine()) != null) {
            allLines.add(i, line);
            i++;
        }
        i = 0;
        while ((line = fbr2.readLine()) != null) {
            forRemoveLines.add(i, line);
            i++;
        }
        fbr1.close();
        fbr2.close();
        new Solution().joinData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void joinData() throws CorruptedDataException {
        boolean StringIsDeleted = false;
        List<String> backupLines = new ArrayList<String>();
        int j = 0;

        for (int i = 0; i < forRemoveLines.size(); i++) {
            while (j < allLines.size()) {
                if (forRemoveLines.get(i).equals(allLines.get(j))) {
                    allLines.remove(j);
                    StringIsDeleted = true;
                } else j++;
            }
            if (!StringIsDeleted) {
                allLines.clear();
                throw (new CorruptedDataException());
            } else {
                StringIsDeleted = false;
                j = 0;
            }
        }
    }
}
