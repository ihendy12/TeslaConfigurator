package org.example.Dao.Jdbc;

import org.example.Dao.WheelDao;
import org.example.models.Exterior;
import org.example.models.Trim;
import org.example.models.Wheel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.List;

public class JdbcWheelDao implements WheelDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcWheelDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Wheel getWheel(int wheelId) {
        Wheel wheel = null;
        String sql = "SELECT * " +
                "FROM wheel_type " +
                "WHERE wheel_type_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, wheelId);
        if (results.next()) {
            wheel = mapRowToWheel(results);
        }
        return wheel;

    }

    @Override
    public Wheel getWheelName(String wheelName){
        Wheel wheel = null;
        String sql = "SELECT * " +
                "FROM wheel_type " +
                "WHERE wheel_type_name = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, wheelName);
        if(results.next()){
            wheel = mapRowToWheel(results);
        }
        return wheel;
    }

    @Override
    public List<Wheel> getAllWheels() {
        return null;
    }

    @Override
    public Wheel createWheel(Wheel newWheel) {
        return null;
    }

    private Wheel mapRowToWheel(SqlRowSet rowSet){
        Wheel wheel = new Wheel();
        wheel.setWheelId(rowSet.getInt("wheel_type_id"));
        wheel.setWheelName(rowSet.getString("wheel_type_name"));
        wheel.setWheelPrice(rowSet.getDouble("wheel_price"));
        return wheel;
    }

}
