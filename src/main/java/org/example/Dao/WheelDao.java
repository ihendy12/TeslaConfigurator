package org.example.Dao;

import org.example.models.Exterior;
import org.example.models.Trim;
import org.example.models.Wheel;

import java.util.List;

public interface WheelDao {
    Wheel getWheel(int wheelId);

    Wheel getWheelName(String wheelName);
    List<Wheel> getAllWheels();

    Wheel createWheel(Wheel newWheel);
}
