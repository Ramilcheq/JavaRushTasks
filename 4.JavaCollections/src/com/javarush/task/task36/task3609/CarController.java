package com.javarush.task.task36.task3609;

public class CarController {
    private CarModel model;
    private SpeedometerView view;
    private int speed;

    public CarController(CarModel model, SpeedometerView view) {
        this.model = model;
        this.view = view;
    }

    public void speedUp(int seconds) {
        if (speed < model.getMaxSpeed()) {
            speed += (3.5 * seconds);
        }
        if (speed > model.getMaxSpeed()) {
            speed = model.getMaxSpeed();
        }
    }

    public void speedDown(int seconds) {
        if (speed > 0) {
            speed -= (12 * seconds);
        }
        if (speed < 0) {
            speed = 0;
        }
    }

    public String getCarBrand() {
        return model.getBrand();
    }

    public String getCarModel() {
        return model.getModel();
    }

    public void setCarSpeed(int speed) {
        model.setSpeed(speed);
    }

    public int getCarSpeed() {
        return speed;
    }

    public int getCarMaxSpeed() {
        return model.getMaxSpeed();
    }

    public void updateView() {
        view.printCarDetails(getCarBrand(), getCarModel(), getCarSpeed());
    }
}