package org.example.models;

public class Customer {

    private int customerId;
    private int modelId;
    private int trimId;
    private int exteriorId;
    private int wheelId;
    private int interiorId;
    private int autopilotId;
    private int chargingId;
    private int seatId;
    private int totalPrice;

    public Customer() {
    }

    public Customer(int customerId, int modelId, int trimId, int exteriorId, int wheelId, int interiorId, int autopilotId, int chargingId, int seatId) {
        this.customerId = customerId;
        this.modelId = modelId;
        this.trimId = trimId;
        this.exteriorId = exteriorId;
        this.wheelId = wheelId;
        this.interiorId = interiorId;
        this.autopilotId = autopilotId;
        this.chargingId = chargingId;
        this.seatId = seatId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public int getTrimId() {
        return trimId;
    }

    public void setTrimId(int trimId) {
        this.trimId = trimId;
    }

    public int getExteriorId() {
        return exteriorId;
    }

    public void setExteriorId(int exteriorId) {
        this.exteriorId = exteriorId;
    }

    public int getWheelId() {
        return wheelId;
    }

    public void setWheelId(int wheelId) {
        this.wheelId = wheelId;
    }

    public int getInteriorId() {
        return interiorId;
    }

    public void setInteriorId(int interiorId) {
        this.interiorId = interiorId;
    }

    public int getAutopilotId() {
        return autopilotId;
    }

    public void setAutopilotId(int autopilotId) {
        this.autopilotId = autopilotId;
    }

    public int getChargingId() {
        return chargingId;
    }

    public void setChargingId(int chargingId) {
        this.chargingId = chargingId;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
