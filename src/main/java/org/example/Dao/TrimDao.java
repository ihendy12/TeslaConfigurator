package org.example.Dao;

import org.example.models.Model;
import org.example.models.Trim;

import java.util.List;

public interface TrimDao{

    Trim getTrim(int trimId);

    Trim getTrimName(String trimName);

    Trim createTrim(Trim newTrim);
}
