package org.example.models;

public class Wheel {

    private int wheelId;
    private String wheelName;
    private double wheelPrice;

    public Wheel(){

    }

    public int getWheelId() {
        return wheelId;
    }

    public void setWheelId(int wheelId) {
        this.wheelId = wheelId;
    }

    public String getWheelName() {
        return wheelName;
    }

    public void setWheelName(String wheelName) {
        this.wheelName = wheelName;
    }

    public double getWheelPrice() {
        return wheelPrice;
    }

    public void setWheelPrice(double wheelPrice) {
        this.wheelPrice = wheelPrice;
    }
}
