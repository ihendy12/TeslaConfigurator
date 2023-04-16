package org.example.Dao;

import org.example.models.Exterior;
import org.example.models.Seat;

public interface SeatDao {

    Seat getSeat(int seatId);
    Seat getSeatName(String seatName);
}
