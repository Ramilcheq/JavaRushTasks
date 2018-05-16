package com.javarush.task.task34.task3410.model;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class LevelLoader {
    private Path levels;
    private static final int lvlAmount = 60;
    private static final String lvlSeparator = "*************************************";

    public LevelLoader(Path levels) {
        this.levels = levels;
    }

    public GameObjects getLevel(int level) {
        Player player = null;
        Set<Home> homes = new HashSet<>();
        Set<Box> boxes = new HashSet<>();
        Set<Wall> walls = new HashSet();

        int x0 = Model.FIELD_CELL_SIZE / 2;
        int y0 = Model.FIELD_CELL_SIZE / 2;
        int j = 0;
        for (String lvlStr : lvlFromFile(levels, level)) {
            for (int i = 0; i < lvlStr.length(); i++) {
                switch (lvlStr.charAt(i)) {
                    case 'X':
                        walls.add(new Wall(x0 + i * Model.FIELD_CELL_SIZE, y0 + j * Model.FIELD_CELL_SIZE));
                        break;
                    case '*':
                        boxes.add(new Box(x0 + i * Model.FIELD_CELL_SIZE, y0 + j * Model.FIELD_CELL_SIZE));
                        break;
                    case '.':
                        homes.add(new Home(x0 + i * Model.FIELD_CELL_SIZE, y0 + j * Model.FIELD_CELL_SIZE));
                        break;
                    case '&':
                        boxes.add(new Box(x0 + i * Model.FIELD_CELL_SIZE, y0 + j * Model.FIELD_CELL_SIZE));
                        homes.add(new Home(x0 + i * Model.FIELD_CELL_SIZE, y0 + j * Model.FIELD_CELL_SIZE));
                        break;
                    case '@':
                        player = new Player(x0 + i * Model.FIELD_CELL_SIZE, y0 + j * Model.FIELD_CELL_SIZE);
                        break;
                }
            }
            j++;
        }

        return new GameObjects(walls, boxes, homes, player);
    }

    public ArrayList<String> lvlFromFile(Path lvlPath, int level) {
        if (level > 60) {
            level = level % 60;
        }
        if (level == 0) level = 60;
        FileReader fileReader = null;
        String line;
        int sum = 0;
        ArrayList<String> lines = new ArrayList<>();
        try {
            fileReader = new FileReader(lvlPath.toFile());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader reader = new BufferedReader(fileReader);
        try {
            while ((line = reader.readLine()) != null) {
                if (line.equals(lvlSeparator)) sum++;
                if (sum == level) {
                    lines.add(line);
                }
                //return lines;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 8; i++) {
            lines.remove(0);
        }
        return lines;
    }

}
