package org.example.Dao.Jdbc;

import org.example.Dao.ChargingDao;
import org.example.models.Charging;
import org.example.models.Exterior;
import org.example.models.Interior;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;

public class JdbcChargingDao implements ChargingDao {
    private JdbcTemplate jdbcTemplate;
    public JdbcChargingDao(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Charging getCharging(int chargingId) {
        Charging charging = null;
        String sql = "SELECT * " +
                "FROM charging " +
                "WHERE charging_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, chargingId);
        if (results.next()) {
            charging = mapRowToCharging(results);
        }
        return charging;



    }

    @Override
    public Charging getChargingName(String chargingName){
        Charging charging = null;
        String sql = "SELECT * " +
                "FROM charging " +
                "WHERE charging_type = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, chargingName);
        if(results.next()){
            charging = mapRowToCharging(results);
        }
        return charging;
    }

    private Charging mapRowToCharging(SqlRowSet rowSet){
        Charging charging = new Charging();
        charging.setChargingId(rowSet.getInt("charging_id"));
        charging.setChargingName(rowSet.getString("charging_type"));
        charging.setChargingPrice(rowSet.getDouble("charging_price"));
        return charging;
    }
}
