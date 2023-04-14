package org.example.models;

public class Charging {
    private int chargingId;
    private String chargingName;
    private double chargingPrice;

    public Charging(){

    }

    public int getChargingId() {
        return chargingId;
    }

    public void setChargingId(int chargingId) {
        this.chargingId = chargingId;
    }

    public String getChargingName() {
        return chargingName;
    }

    public void setChargingName(String chargingName) {
        this.chargingName = chargingName;
    }

    public double getChargingPrice() {
        return chargingPrice;
    }

    public void setChargingPrice(double chargingPrice) {
        this.chargingPrice = chargingPrice;
    }
}
