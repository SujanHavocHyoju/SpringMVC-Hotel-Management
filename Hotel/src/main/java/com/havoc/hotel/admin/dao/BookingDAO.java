/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.havoc.hotel.admin.dao;

import com.havoc.hotel.admin.entity.Booking;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author HYOJU
 */
public interface BookingDAO {
    List<Booking> getALL() throws SQLException;
    int insert (Booking b) throws SQLException;
    Booking getById (int bookingId) throws SQLException; 
    int insertClient (Booking b) throws SQLException;
    int update (Booking b) throws SQLException;
    int delete (int bookingId) throws SQLException;
    int checkin(int bookingId) throws SQLException;
    List <Booking> getLast() throws SQLException;
    List<Booking> getByUser(String username)throws SQLException;
}
