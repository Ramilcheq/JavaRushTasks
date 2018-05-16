package com.javarush.task.task34.task3410.controller;

import com.javarush.task.task34.task3410.model.Direction;
import com.javarush.task.task34.task3410.model.GameObjects;
import com.javarush.task.task34.task3410.model.Model;
import com.javarush.task.task34.task3410.view.Field;
import com.javarush.task.task34.task3410.view.View;

import javax.swing.*;
import java.awt.*;

public class Controller implements EventListener{
    private View view;
    private Model model;
    private EventListener eventListener;
    

    public Controller() {
        this.view = new View(this);
        this.model = new Model();
        view.init();
        model.restart();
        view.setEventListener(this);
        model.setEventListener(this);
    }


    public static void main(String[] args){
        Controller controller = new Controller();
        //Field field = new Field(new View(controller));

    }


    @Override
    public void move(Direction direction) {
        model.move(direction);
        view.update();
    }

    @Override
    public void restart() {
        model.restart();
        view.update();
    }

    @Override
    public void startNextLevel() {
        model.startNextLevel();
        view.update();
    }

    @Override
    public void levelCompleted(int level) {
        view.completed(level);
    }

    public GameObjects getGameObjects(){
        return model.getGameObjects();
    }
}
