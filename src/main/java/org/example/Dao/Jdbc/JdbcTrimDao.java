package org.example.Dao.Jdbc;

import org.example.Dao.TrimDao;
import org.example.models.Model;
import org.example.models.Trim;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.List;

public class JdbcTrimDao implements TrimDao {


    private final JdbcTemplate jdbcTemplate;
    public JdbcTrimDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Trim getTrim(int trimId) {
        Trim trim = null;
        String sql = "SELECT * " +
                "FROM trim_level " +
                "WHERE trim_level_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, trimId);
        if (results.next()) {
            trim = mapRowToTrim(results);
        }
        return trim;
    }

    @Override
    public Trim getTrimName(String trimName){
        Trim trim = null;
        String sql = "SELECT * " +
                     "FROM trim_level " +
                     "WHERE trim_level_name = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, trimName);
        if(results.next()){
            trim = mapRowToTrim(results);
        }
        return trim;
    }

    @Override
    public Trim createTrim(Trim newTrim) {
        return null;
    }

    private Trim mapRowToTrim(SqlRowSet rowSet){
        Trim trim = new Trim();
        trim.setTrimId(rowSet.getInt("trim_level_id"));
        trim.setTrimName(rowSet.getString("trim_level_name"));
        trim.setTrimPrice(rowSet.getDouble("trim_price"));
        return trim;
    }
}
