package org.example.models;

public class Exterior {
  /*  exterior_color_id serial,
    exterior_color_name varchar (40) not null,
    exterior_price numeric (9,2) not null,*/

    private int exteriorId;
    private String exteriorName;
    private double exteriorPrice;

    public Exterior() {
    }

    public int getExteriorId() {
        return exteriorId;
    }

    public void setExteriorId(int exteriorId) {
        this.exteriorId = exteriorId;
    }

    public String getExteriorName() {
        return exteriorName;
    }

    public void setExteriorName(String exteriorName) {
        this.exteriorName = exteriorName;
    }

    public double getExteriorPrice() {
        return exteriorPrice;
    }

    public void setExteriorPrice(double exteriorPrice) {
        this.exteriorPrice = exteriorPrice;
    }
}
