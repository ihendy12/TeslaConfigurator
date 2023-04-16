package org.example.Dao;

import org.example.models.Exterior;
import org.example.models.Tow;

public interface TowDao {

    Tow getTow(int towId);
    Tow getTowName(String towName);
}
