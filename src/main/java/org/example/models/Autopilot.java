package org.example.models;

public class Autopilot {
    private int autopilotId;
    private String autopilotName;
    private double autopilotPrice;

    public Autopilot(){

    }

    public int getAutopilotId() {
        return autopilotId;
    }

    public void setAutopilotId(int autopilotId) {
        this.autopilotId = autopilotId;
    }

    public String getAutopilotName() {
        return autopilotName;
    }

    public void setAutopilotName(String autopilotName) {
        this.autopilotName = autopilotName;
    }

    public double getAutopilotPrice() {
        return autopilotPrice;
    }

    public void setAutopilotPrice(double autopilotPrice) {
        this.autopilotPrice = autopilotPrice;
    }
}
