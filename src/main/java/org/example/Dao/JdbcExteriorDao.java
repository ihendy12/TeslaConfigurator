package org.example.Dao;

import org.example.models.Exterior;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.List;

public class JdbcExteriorDao implements ExteriorDao{

        private JdbcTemplate jdbcTemplate;

        public JdbcExteriorDao(DataSource dataSource) {
            this.jdbcTemplate = new JdbcTemplate(dataSource);
        }

    @Override
    public Exterior getExterior(int exteriorId) {
        Exterior exterior = null;
        String sql = "SELECT * " +
                     "FROM exterior_color " +
                     "WHERE exterior_color_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, exteriorId);
        if(results.next()){
            exterior = mapRowToExterior(results);
        }

        return exterior;
    }

    @Override
    public List<Exterior> getAllExteriors() {
        return null;
    }

    @Override
    public Exterior createExterior(Exterior newExterior) {
        return null;
    }

    private Exterior mapRowToExterior(SqlRowSet rowSet){
            Exterior exterior = new Exterior();
            exterior.setExteriorId(rowSet.getInt("exterior_color_id"));
            exterior.setExteriorName(rowSet.getString("exterior_color_name"));
            exterior.setExteriorPrice(rowSet.getDouble("exterior_price"));
            return exterior;
    }
}
