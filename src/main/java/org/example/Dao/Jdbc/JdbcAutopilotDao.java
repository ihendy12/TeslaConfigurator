package org.example.Dao.Jdbc;

import org.example.Dao.AutopilotDao;
import org.example.models.Autopilot;
import org.example.models.Exterior;
import org.example.models.Interior;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.List;


public class JdbcAutopilotDao implements AutopilotDao {
    private JdbcTemplate jdbcTemplate;
    public JdbcAutopilotDao(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Autopilot getAutopilot(int autopilotId) {
        Autopilot autopilot = null;
        String sql = "SELECT * " +
                "FROM autopilot_level " +
                "WHERE autopilot_level_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, autopilotId);
        if (results.next()) {
            autopilot = mapRowToAutopilot(results);
        }
        return autopilot;



    }

    @Override
    public Autopilot getAutopilotName(String autopilotName){
        Autopilot autopilot = null;
        String sql = "SELECT * " +
                "FROM autopilot_level " +
                "WHERE autopilot_level_name = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, autopilotName);
        if(results.next()){
            autopilot = mapRowToAutopilot(results);
        }
        return autopilot;
    }

    @Override
    public List<Autopilot> getAllAutopilotOptions() {
        return null;
    }

    @Override
    public Autopilot createAutopilot(Autopilot newAutopilot) {
        return null;
    }

    private Autopilot mapRowToAutopilot(SqlRowSet rowset){
        Autopilot autopilot = new Autopilot();
        autopilot.setAutopilotId(rowset.getInt("autopilot_level_id"));
        autopilot.setAutopilotName(rowset.getString("autopilot_level_name"));
        autopilot.setAutopilotPrice(rowset.getDouble("autopilot_price"));
        return autopilot;
    }
}
