package org.example.Dao;
import org.example.models.Model;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.List;

public class JdbcModelDao implements ModelDao {

    private final JdbcTemplate jdbcTemplate;
    public JdbcModelDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public Model getModel(int modelId) {
        Model model = null;
        String sql = "SELECT * " +
                     "FROM model " +
                     "WHERE model_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, modelId);
        if (results.next()) {
            model = mapRowToModels(results);
        }
        return model;
    }

    @Override
    public List<Model> getModels() {
        return null;
    }

    @Override
    public Model createModel(Model newModel) {
        return null;
    }

    @Override
    public void updateModel(Model updatedModel) {

    }

    private Model mapRowToModels(SqlRowSet rowSet) {
        Model model = new Model();
        model.setModelId(rowSet.getInt("model_id"));
        model.setName(rowSet.getString("model_name"));
        model.setPrice(rowSet.getDouble("model_price"));
        return model;
    }
}
