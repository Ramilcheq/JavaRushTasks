package com.javarush.task.task17.task1714;

/* 
Comparable
*/

public class Beach implements Comparable<Beach>{
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized int compareTo(Beach b) {
        int distance = (int)(this.getDistance() - b.getDistance());
        int quality = 10*(this.getQuality() - b.getQuality());
        return (distance + quality);
    }
    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    public static void main(String[] args) {
        Beach b = new Beach("asdf",1,1);
        Beach a = new Beach("asdf",1,2);
        System.out.println(a.compareTo(b));
    }
}
