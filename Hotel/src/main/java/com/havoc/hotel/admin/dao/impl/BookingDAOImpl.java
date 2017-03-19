/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.havoc.hotel.admin.dao.impl;

import com.havoc.hotel.admin.constant.SQLConstant;
import com.havoc.hotel.admin.dao.BookingDAO;
import com.havoc.hotel.admin.entity.Booking;
import com.havoc.hotel.admin.entity.Customer;
import com.havoc.hotel.admin.entity.Room;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
/**
 *
 * @author HYOJU
 */
@Repository(value = "BookingDAo")
public class BookingDAOImpl implements BookingDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    private Booking mapData(ResultSet rs) throws SQLException {
        Booking b = new Booking();
        b.setBookingId(rs.getInt("booking_id"));
        b.setFirstName(rs.getString("first_name"));
        b.setLastName(rs.getString("last_name"));
        Room r = new Room();
        r.setRoomId(rs.getInt("room_id"));
        r.setRoomPrice(rs.getInt("room_price"));
        r.setRoomNumber(rs.getInt("room_number"));
        b.setRoom(r);
        b.setCheckinDate(rs.getDate("checkin_date"));
        b.setTotalDays(rs.getInt("total_days"));
        b.setTotalNights(rs.getInt("total_nights"));
        b.setCheckoutDate(rs.getDate("checkout_date"));
        Customer c = new Customer();
        c.setCustomerId(rs.getInt("customer_id"));
        b.setCustomer(c);
        b.setTotalPrice(rs.getInt("total_price"));
        b.setPdf(rs.getString("pdf"));
        b.setStatus(rs.getBoolean("status"));

        return b;

    }

    @Override
    public List<Booking> getALL() throws SQLException {
        return jdbcTemplate.query(SQLConstant.BOOKING_GETALL, new RowMapper<Booking>() {
            @Override
            public Booking mapRow(ResultSet rs, int i) throws SQLException { 
                return mapData(rs);
            }
        });
    }

    @Override
    public int insert(Booking b) throws SQLException {
        return jdbcTemplate.update(SQLConstant.BOOKING_INSERT, new Object[]{ 
            b.getFirstName(),
            b.getLastName(),
            b.getRoom().getRoomId(),
            b.getRoom().getRoomPrice(),
            b.getRoom().getRoomNumber(),
            b.getRoom().getRoomType(),
            b.getCheckinDate(),
            b.getTotalDays(),
            b.getTotalNights(),
            b.getCheckoutDate(), 
            b.getTotalPrice(),
            b.getCustomer().getCustomerId(),
            b.getPdf(), 
            b.isStatus()
        });
      
     }
   

    @Override
    public int update(Booking b) throws SQLException {
        return jdbcTemplate.update(SQLConstant.BOOKING_UPDATE, new Object[]{
            b.getFirstName(), 
            b.getLastName(),
            b.getRoom().getRoomId(),
            b.getCheckinDate(), 
            b.getTotalDays(), 
            b.getTotalNights(), 
            b.getCheckoutDate(), 
            b.getTotalPrice(),
            b.getCustomer().getCustomerId(),
            b.isStatus(),
            b.getPdf(),
            b.getBookingId()
        });
    }

    @Override
    public int delete(int bookingId) throws SQLException {
        return jdbcTemplate.update(SQLConstant.BOOKING_DELETE, new Object[]{bookingId});
    }

    @Override
    public Booking getById(int bookingId) throws SQLException {
        
        return (Booking) jdbcTemplate.query(SQLConstant.BOOKING_GETBYID, new Object[]{bookingId} , new ResultSetExtractor<Booking>() {

            @Override
            public Booking extractData(ResultSet rs) throws SQLException, DataAccessException {
                Booking b = null;
                if (rs.next()) {
                    b= new Booking();
                    b.setBookingId(rs.getInt("booking_id"));
                    b.setFirstName(rs.getString("first_name"));
                    b.setLastName(rs.getString("last_name"));
                    Room r = new Room();
                    r.setRoomId(rs.getInt("room_id"));
                    r.setRoomPrice(rs.getInt("room_price"));
                    r.setRoomNumber(rs.getInt("room_number"));
                    b.setRoom(r);
                    b.setCheckinDate(rs.getDate("checkin_date"));
                    b.setTotalDays(rs.getInt("total_days"));
                    b.setTotalNights(rs.getInt("total_nights"));
                    b.setCheckoutDate(rs.getDate("checkout_date"));
                    Customer c = new Customer();
                    c.setCustomerId(rs.getInt("customer_id"));
                    c.setFirstName(rs.getString("first_name"));
                    c.setLastName(rs.getString("last_name"));
                    c.setUsername(rs.getString("username"));
                    b.setCustomer(c);
                    b.setTotalPrice(rs.getInt("total_price"));
                    b.setPdf(rs.getString("pdf"));
                    b.setStatus(rs.getBoolean("status"));
                }
                return b;
            }

        });
    }

    @Override
    public int checkin(int bookingId) throws SQLException {
       return jdbcTemplate.update(SQLConstant.BOOKING_CHECKIN, new Object[]{bookingId});
    }

   

    @Override
    public int insertClient(Booking b) throws SQLException {
        System.out.println(b);
          return jdbcTemplate.update(SQLConstant.BOOKING_INSERTCLIENT, new Object[]{ 
              b.getFirstName(),
              b.getLastName(),
              b.getRoom().getRoomId(),
              b.getRoom().getRoomNumber(),
              b.getRoom().getRoomPrice(),
              b.getRoom().getRoomType(),
              b.getCheckinDate(),
              b.getTotalDays(),
              b.getTotalNights(),
              b.getCheckoutDate(),
              b.getTotalPrice(),
              b.getCustomer().getCustomerId(),
              b.getCustomer().getUsername(),
              b.getPdf(),
              b.isStatus()});
    }

    @Override
    public List<Booking> getByUser(String username) throws SQLException {
        return jdbcTemplate.query(SQLConstant.BOOKING_GETBYUSER, new Object[]{username},new RowMapper<Booking>() {

            @Override
            public Booking mapRow(ResultSet rs, int i) throws SQLException {
                  return mapData(rs);
            }
        });
    }

    @Override
    public List<Booking> getLast() throws SQLException {
       return jdbcTemplate.query(SQLConstant.BOOKING_GETLAST,new RowMapper<Booking>() {

           @Override
           public Booking mapRow(ResultSet rs, int i) throws SQLException {
               return mapData(rs);
           }
       });
    }
  
    }


    



