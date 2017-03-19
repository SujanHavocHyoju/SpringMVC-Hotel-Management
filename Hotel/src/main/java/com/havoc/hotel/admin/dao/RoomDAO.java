/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.havoc.hotel.admin.dao;

import com.havoc.hotel.admin.entity.Room;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author HYOJU
 */
public interface RoomDAO {
    List<Room> getALL() throws SQLException;
    int insert (Room r) throws SQLException;
    Room getById (int roomId) throws SQLException;
    int update (Room r) throws SQLException;
    int delete (int roomId) throws SQLException;  
}
