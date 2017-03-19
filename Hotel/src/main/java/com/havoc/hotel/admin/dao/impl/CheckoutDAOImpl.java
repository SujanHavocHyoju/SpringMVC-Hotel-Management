/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.havoc.hotel.admin.dao.impl;

import com.havoc.hotel.admin.constant.SQLConstant;
import com.havoc.hotel.admin.dao.CheckoutDAO;
import com.havoc.hotel.admin.entity.Booking;
import com.havoc.hotel.admin.entity.Checkin;
import com.havoc.hotel.admin.entity.Checkout;
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
@Repository(value = "CheckoutDAO")
public class CheckoutDAOImpl implements CheckoutDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private Checkout mapData(ResultSet rs) throws SQLException {
        Checkout checkout = new Checkout();
        checkout.setCheckoutId(rs.getInt("checkout_id"));
        Checkin c = new Checkin();
        c.setCheckinId(rs.getInt("checkin_id"));
        Booking b = new Booking();
        b.setFirstName(rs.getString("first_name"));
        b.setLastName(rs.getString("last_name"));
        b.setCheckinDate(rs.getDate("checkin_date"));
        b.setCheckoutDate(rs.getDate("checkout_date"));
        b.setTotalDays(rs.getInt("total_days"));
        b.setTotalNights(rs.getInt("total_nights"));
        b.setTotalPrice(rs.getInt("total_price"));
        Room r = new Room();
        r.setRoomNumber(rs.getInt("room_number"));
        r.setRoomPrice(rs.getInt("room_price"));
        c.setBooking(b);
        checkout.setCheckin(c);
        return checkout;
    }

    @Override
    public List<Checkout> getALL() throws SQLException {
        return jdbcTemplate.query(SQLConstant.CHECKOUT_GETALL, new RowMapper<Checkout>() {

            @Override
            public Checkout mapRow(ResultSet rs, int i) throws SQLException {
                return mapData(rs);
            }
        });
    }

}
