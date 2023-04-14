package org.example.Dao.Jdbc;

import org.example.Dao.InteriorDao;
import org.example.models.Interior;
import org.example.models.Wheel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.List;

public class JdbcInteriorDao implements InteriorDao {

    private JdbcTemplate jdbcTemplate;
    public JdbcInteriorDao(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Interior getInterior(int interiorId) {
            Interior interior = null;
            String sql = "SELECT * " +
                    "FROM interior_color " +
                    "WHERE interior_color_id = ?;";
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, interiorId);
            if (results.next()) {
                interior = mapRowToInterior(results);
            }
            return interior;



    }

    @Override
    public List<Interior> getAllInteriors() {
        return null;
    }

    @Override
    public Interior createInterior(Interior newInterior) {
        return null;
    }

    private Interior mapRowToInterior(SqlRowSet rowSet){
        Interior interior = new Interior();
        interior.setInteriorId(rowSet.getInt("interior_color_id"));
        interior.setInteriorName(rowSet.getString("interior_color_name"));
        interior.setInteriorPrice(rowSet.getDouble("interior_price"));
        return interior;
    }
}
