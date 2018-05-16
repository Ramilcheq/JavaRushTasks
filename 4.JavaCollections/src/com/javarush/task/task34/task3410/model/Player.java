package com.javarush.task.task34.task3410.model;

import com.javarush.task.task34.task3410.view.Field;

import java.awt.*;

public class Player extends CollisionObject implements Movable {
    public Player(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.BLUE);
        graphics.drawOval(this.getX(), this.getY(), 20, 20);
        graphics.fillOval(this.getX(), this.getY(), 20, 20);
    }

    @Override
    public void move(int x, int y) {
        this.setX(this.getX() + x);
        this.setY(this.getY() + y);
    }


}
