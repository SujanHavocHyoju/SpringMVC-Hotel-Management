/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.havoc.hotel.admin.dao.impl;

import com.havoc.hotel.admin.constant.SQLConstant;
import com.havoc.hotel.admin.dao.CheckinDAO;
import com.havoc.hotel.admin.entity.Booking;
import com.havoc.hotel.admin.entity.Checkin;
import com.havoc.hotel.admin.entity.Room;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HYOJU
 */
@Repository(value="CheckinDAO")
public class CheckinDAOImpl implements CheckinDAO {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    private Checkin mapData(ResultSet rs) throws SQLException {
        Checkin c = new Checkin();
        c.setCheckinId(rs.getInt("checkin_id"));
        Booking b = new Booking();
        b.setBookingId(rs.getInt("booking_id"));
        b.setFirstName(rs.getString("first_name"));
        b.setLastName(rs.getString("last_name"));
        Room r= new Room();
        r.setRoomPrice(rs.getInt("room_price"));
        r.setRoomNumber(rs.getInt("room_number"));
        b.setRoom(r);
        b.setCheckinDate(rs.getDate("checkin_date"));
        b.setTotalDays(rs.getInt("total_days"));
        b.setTotalNights(rs.getInt("total_nights"));
        b.setTotalPrice(rs.getInt("total_price"));
        b.setCheckoutDate(rs.getDate("checkout_date"));
        c.setBooking(b);
        return c;

    }
    
    @Override
    public List<Checkin> getALL() throws SQLException {
        return jdbcTemplate.query(SQLConstant.CHECKIN_GETALL, new RowMapper<Checkin>() {

            @Override
            public Checkin mapRow(ResultSet rs, int i) throws SQLException {
               return mapData(rs);
            }
        });
      }
    

    @Override
    public int checkout(int checkinId) throws SQLException {
       return jdbcTemplate.update(SQLConstant.CHECKIN_CHECKOUT,new Object[]{checkinId});
    }

    
}

