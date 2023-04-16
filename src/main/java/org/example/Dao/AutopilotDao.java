package org.example.Dao;

import org.example.models.Autopilot;
import org.example.models.Exterior;

import java.util.List;

public interface AutopilotDao {
    Autopilot getAutopilot(int autopilotId);

    Autopilot getAutopilotName(String autopilotName);

    List<Autopilot> getAllAutopilotOptions();

    Autopilot createAutopilot(Autopilot newAutopilot);
}
