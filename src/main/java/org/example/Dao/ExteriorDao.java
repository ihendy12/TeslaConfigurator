package org.example.Dao;

import org.example.models.Exterior;
import org.example.models.Trim;

import java.util.List;

public interface ExteriorDao {

    Exterior getExterior(int exteriorId);

    Exterior getExteriorName(String exteriorName);

    List<Exterior> getAllExteriors();

    Exterior createExterior(Exterior newExterior);
}
