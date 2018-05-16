package com.javarush.task.task34.task3410.model;

import com.javarush.task.task34.task3410.controller.EventListener;

import java.nio.file.Paths;
import java.util.Set;

public class Model {
    public static final int FIELD_CELL_SIZE = 20;
    private EventListener eventListener;
    private GameObjects gameObjects;
    private int currentLevel = 1;
    private LevelLoader levelLoader = new LevelLoader(Paths.get("E:/JavaRushHomeWork/JavaRushTasks/out/production/4.JavaCollections/com/javarush/task/task34/task3410/res/levels.txt"));

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public GameObjects getGameObjects() {
        return gameObjects;
    }

    public void restartLevel(int level) {
        gameObjects = levelLoader.getLevel(level);
    }

    public void restart() {
        restartLevel(currentLevel);
    }

    public void startNextLevel() {
        currentLevel++;
        restartLevel(currentLevel);
    }

    public void move(Direction direction) {
        Player player = gameObjects.getPlayer();
        if(checkWallCollision(player,direction) || checkBoxCollisionAndMoveIfAvaliable(direction)) return;
        player.move(deltaXY(direction)[0], deltaXY(direction)[1]);
        checkCompletion();
    }

    public boolean checkWallCollision(CollisionObject gameObject, Direction direction) {
        for (GameObject wall : gameObjects.getWalls()) {
            if (gameObject.isCollision(wall, direction)) return true;
        }
        return false;
    }

    public boolean checkBoxCollisionAndMoveIfAvaliable(Direction direction) {
        Set<Box> boxes = gameObjects.getBoxes();
        Player player = gameObjects.getPlayer();
        for (Box box : boxes) {
            if (player.isCollision(box, direction)) {
                for (Box box1 : boxes) {
                    if (box.isCollision(box1, direction)) return true;
                }
                if (checkWallCollision(box, direction)) return true;
                box.move(deltaXY(direction)[0], deltaXY(direction)[1]);
                return false;
            }
        }
        return false;
    }

    public int[] deltaXY(Direction direction) {
        int[] result = new int[2];
        int q = FIELD_CELL_SIZE;
        switch (direction) {
            case UP:
                result[0] = 0;
                result[1] = -q;
                break;
            case DOWN:
                result[0] = 0;
                result[1] = q;
                break;
            case RIGHT:
                result[0] = q;
                result[1] = 0;
                break;
            case LEFT:
                result[0] = -q;
                result[1] = 0;
                break;
        }
        return result;
    }

    public void checkCompletion() {
        Set<Home> homes = gameObjects.getHomes();
        Set<Box> boxes = gameObjects.getBoxes();
        int sum = 0;
        for (Home home : homes) {
            for (Box box : boxes) {
                if (home.getX() == box.getX() && home.getY() == box.getY()) sum++;
            }
        }
        if (sum == homes.size()) eventListener.levelCompleted(currentLevel);
    }


}
