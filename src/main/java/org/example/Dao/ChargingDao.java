package org.example.Dao;

import org.example.models.Charging;
import org.example.models.Exterior;

public interface ChargingDao {

    Charging getCharging(int chargingId);
    Charging getChargingName(String chargingName);
}
