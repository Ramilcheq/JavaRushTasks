package com.javarush.task.task34.task3410.model;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GameObjects {
    private Set<Wall> walls;
    private Set<Box> boxes;
    private Set<Home> homes;
    private Player player;

    public GameObjects(Set<Wall> walls, Set<Box> boxes, Set<Home> homes, Player player) {
        this.walls = walls;
        this.boxes = boxes;
        this.homes = homes;
        this.player = player;
    }

    public Set<GameObject> getAll(){
        Set<GameObject> all = new HashSet<>();
        all.addAll(this.getWalls());
        all.addAll(this.getBoxes());
        all.addAll(this.getHomes());
        all.add(this.getPlayer());
        return all;
    }

    public Set<Wall> getWalls() {
        return walls;
    }

    public Set<Box> getBoxes() {
        return boxes;
    }

    public Set<Home> getHomes() {
        return homes;
    }

    public Player getPlayer() {
        return player;
    }
}
