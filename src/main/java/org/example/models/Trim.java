package org.example.models;

public class Trim {
   /* trim_level_id serial,
    trim_level_name varchar (40) not null,
    trim_price numeric (9,2) not null*/


    private int trimId;
    private String trimName;
    private double trimPrice;

    public Trim() {
    }

    public int getTrimId() {
        return trimId;
    }

    public void setTrimId(int trimId) {
        this.trimId = trimId;
    }

    public String getTrimName() {
        return trimName;
    }

    public void setTrimName(String trimName) {
        this.trimName = trimName;
    }

    public double getTrimPrice() {
        return trimPrice;
    }

    public void setTrimPrice(double trimPrice) {
        this.trimPrice = trimPrice;
    }
}
