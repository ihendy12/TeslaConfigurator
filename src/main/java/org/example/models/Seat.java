package org.example.models;

public class Seat {
    private int seatId;
    private String numOfSeats;
    private double seatPrice;

    public Seat(){

    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public String getNumOfSeats() {
        return numOfSeats;
    }

    public void setNumOfSeats(String numOfSeats) {
        this.numOfSeats = numOfSeats;
    }

    public double getSeatPrice() {
        return seatPrice;
    }

    public void setSeatPrice(double seatPrice) {
        this.seatPrice = seatPrice;
    }
}
