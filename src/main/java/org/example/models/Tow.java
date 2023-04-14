package org.example.models;

public class Tow {
    private int towId;
    private String towConfirmed;
    private double towPrice;

    public Tow(){

    }

    public int getTowId() {
        return towId;
    }

    public void setTowId(int towId) {
        this.towId = towId;
    }

    public String getTowConfirmed() {
        return towConfirmed;
    }

    public void setTowConfirmed(String towConfirmed) {
        this.towConfirmed = towConfirmed;
    }

    public double getTowPrice() {
        return towPrice;
    }

    public void setTowPrice(double towPrice) {
        this.towPrice = towPrice;
    }
}
