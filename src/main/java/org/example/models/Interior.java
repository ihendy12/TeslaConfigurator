package org.example.models;

public class Interior {
    private int interiorId;
    private String interiorName;
    private double interiorPrice;

    public Interior(){

    }

    public int getInteriorId() {
        return interiorId;
    }

    public void setInteriorId(int interiorId) {
        this.interiorId = interiorId;
    }

    public String getInteriorName() {
        return interiorName;
    }

    public void setInteriorName(String interiorName) {
        this.interiorName = interiorName;
    }

    public double getInteriorPrice() {
        return interiorPrice;
    }

    public void setInteriorPrice(double interiorPrice) {
        this.interiorPrice = interiorPrice;
    }
}
