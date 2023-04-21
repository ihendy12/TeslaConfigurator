package org.example.Dao.Jdbc;

import org.example.Dao.CustomerDao;
import org.example.models.Autopilot;
import org.example.models.Customer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcCustomerDao implements CustomerDao {

    private JdbcTemplate jdbcTemplate;
    public JdbcCustomerDao (DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public Customer getCustomerById(int customerId) {
        Customer customer = null;
        String sql = "SELECT * " +
                     "FROM customer " +
                     "WHERE customer_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, customerId);
        if(results.next()) {
            customer = mapCustomerToRow(results);
        }
        return customer;
    }

    @Override
    public List<Customer> getAllCustomerOrders() {
        List <Customer> customers = new ArrayList<>();
        String sql = "SELECT * " +
                     "FROM customer ORDER BY customer_id;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()){
            customers.add(mapCustomerToRow(results));
        }
        return customers;
    }


    @Override
    public Customer createCustomer(Customer newCustomer) {
        String sql = "INSERT INTO customer " +
                "(model_id, trim_level_id, exterior_color_id, wheel_type_id, interior_color_id, autopilot_level_id, charging_id, " +
                "tow_hitch_id, seat_id, total_price) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING customer_id;";
        int newId = jdbcTemplate.queryForObject(sql, Integer.class, newCustomer.getModelId(), newCustomer.getTrimId()
                , newCustomer.getExteriorId(), newCustomer.getWheelId(), newCustomer.getInteriorId(), newCustomer.getAutopilotId(),
                newCustomer.getChargingId(), newCustomer.getTowId(), newCustomer.getSeatId(), newCustomer.getTotalPrice());
        newCustomer.setCustomerId(newId);

        return newCustomer;



    }

    private Customer mapCustomerToRow(SqlRowSet rowSet){
        Customer customer = new Customer();
        customer.setCustomerId(rowSet.getInt("customer_id"));
        customer.setModelId(rowSet.getInt("model_id"));
        customer.setTrimId(rowSet.getInt("trim_level_id"));
        customer.setExteriorId(rowSet.getInt("exterior_color_id"));
        customer.setWheelId(rowSet.getInt("wheel_type_id"));
        customer.setInteriorId(rowSet.getInt("interior_color_id"));
        customer.setAutopilotId(rowSet.getInt("autopilot_level_id"));
        customer.setChargingId(rowSet.getInt("charging_id"));
        customer.setTowId(rowSet.getInt("tow_hitch_id"));
        customer.setSeatId(rowSet.getInt("seat_id"));
        customer.setTotalPrice(rowSet.getInt("total_price"));
        return customer;
    }
}

