package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        Thread t1 = new T1();
        threads.add(t1);
        Thread t2 = new T2();
        threads.add(t2);
        Thread t3 = new T3();
        threads.add(t3);
        Thread t4 = new T4();
        threads.add(t4);
        Thread t5 = new T5();
        threads.add(t5);

    }

    public static class T1 extends Thread {
        public void run(){
            while (true){}
        }
    }

    public static class T2 extends Thread {
        public void run(){
            try {
                sleep(1);
            }
            catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class T3 extends Thread {
        public void run(){
            try {
                while (true) {
                    System.out.println("Ура");
                    sleep(500);
                }
            }
            catch (Exception e) {
            }
        }
    }

    public static class T4 extends Thread implements Message {
        public void run(){
            while (!isInterrupted()) {}
        }

        @Override
        public void showWarning() {
            interrupt();
        }
    }

    public static class T5 extends Thread {
        public void run(){
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str;
            int sum = 0;

            try {
                while (true) {
                    str = br.readLine();
                    if (!str.equals("N")) {
                        sum = sum + Integer.parseInt(str);
                    }
                    else System.out.println(sum);;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = -1;
        try {
            q = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        switch (q) {
            case 1: threads.get(0).start(); break;
            case 2: threads.get(1).start(); break;
            case 3: threads.get(2).start(); break;
            case 4: threads.get(3).start();                    break;
            case 5: threads.get(4).start(); break;
        }
        threads.get(3).sho*/
    }
}