package org.example.Dao;

import org.example.models.Exterior;
import org.example.models.Interior;

import java.util.List;

public interface InteriorDao {
    Interior getInterior(int interiorId);

    Interior getInteriorName(String interiorName);

    List<Interior> getAllInteriors();

    Interior createInterior(Interior newInterior);
}


