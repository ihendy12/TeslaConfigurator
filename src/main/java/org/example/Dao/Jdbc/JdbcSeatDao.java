package org.example.Dao.Jdbc;

import org.example.Dao.SeatDao;
import org.example.models.Exterior;
import org.example.models.Seat;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;

public class JdbcSeatDao implements SeatDao {
    private JdbcTemplate jdbcTemplate;
    public JdbcSeatDao(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Seat getSeat(int seatId) {
        Seat seat = null;
        String sql = "SELECT * " +
                     "FROM seat_number " +
                     "WHERE seat_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, seatId);
        if(results.next()){
            seat = mapRowToSeat(results);
        }
        return seat;
    }

    @Override
    public Seat getSeatName(String seatName){
        Seat seat = null;
        String sql = "SELECT * " +
                "FROM seat_number " +
                "WHERE number_of_seats = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, seatName);
        if(results.next()){
            seat = mapRowToSeat(results);
        }
        return seat;
    }

    private Seat mapRowToSeat(SqlRowSet rowSet){
        Seat seat = new Seat();
        seat.setSeatId(rowSet.getInt("seat_id"));
        seat.setNumOfSeats(rowSet.getString("number_of_seats"));
        seat.setSeatPrice(rowSet.getDouble("seat_price"));
        return seat;
    }
}
