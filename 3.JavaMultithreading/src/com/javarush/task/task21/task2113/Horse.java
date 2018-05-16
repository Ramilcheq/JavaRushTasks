package com.javarush.task.task21.task2113;

import java.util.List;

public class Horse {
    private String name;
    private double speed;
    private double distance;

    public void setName(String name) {
        this.name = name;
    }

    public void setSpeed(double speed) {

        this.speed = speed;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getName() {

        return name;
    }

    public double getSpeed() {
        return speed;
    }

    public double getDistance() {
        return distance;
    }

    public Horse(String name, double speed, double distance) {

        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public void move() {
        double s = speed * Math.random();
        distance += s;
    }

    public void print() {
        int dotAmount = (int) distance;
        String dots = "";
        for (int i = 0; i < dotAmount; i++) {
            dots += ".";
        }

        System.out.println(dots + name);
    }
}
