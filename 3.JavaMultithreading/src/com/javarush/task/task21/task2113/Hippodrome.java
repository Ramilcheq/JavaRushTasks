package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;
    public static Hippodrome game;

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            move();
            print();

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void move() {
        for (Horse h : horses) {
            h.move();
            h.print();
        }
    }

    public void print() {
        for (Horse h : horses) {
            h.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        Horse winner = null;
        double maxDistance = 0;
        for (Horse h : horses) {
            if (h.getDistance() > maxDistance) {
                maxDistance = h.getDistance();
                winner = h;
            }
        }
        return winner;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public static void main(String[] args) {
        Horse tigra = new Horse("Tigra", 3, 0);
        Horse voron = new Horse("Voron", 3, 0);
        Horse sobchak = new Horse("Sobchak", 3, 0);
        List<Horse> horses = new ArrayList<>();
        horses.add(tigra);
        horses.add(voron);
        horses.add(sobchak);
        game = new Hippodrome(horses);
        game.run();
        game.printWinner();
    }
}
