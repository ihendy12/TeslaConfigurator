package org.example.Dao.Jdbc;

import org.example.Dao.TowDao;
import org.example.models.Charging;
import org.example.models.Tow;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;

public class JdbcTowDao implements TowDao {
   private JdbcTemplate jdbcTemplate;
   public JdbcTowDao(DataSource dataSource){
       this.jdbcTemplate = new JdbcTemplate(dataSource);
   }

    @Override
    public Tow getTow(int towId) {
        Tow tow = null;
        String sql = "SELECT * " +
                "FROM tow_hitch " +
                "WHERE tow_hitch_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, towId);
        if (results.next()) {
            tow = mapRowToTow(results);
        }
        return tow;
    }

    private Tow mapRowToTow(SqlRowSet rowSet){
        Tow tow = new Tow();
        tow.setTowId(rowSet.getInt("tow_hitch_id"));
        tow.setTowConfirmed(rowSet.getString("tow_confirmed"));
        tow.setTowPrice(rowSet.getDouble("tow_hitch_price"));
        return tow;
    }
}
