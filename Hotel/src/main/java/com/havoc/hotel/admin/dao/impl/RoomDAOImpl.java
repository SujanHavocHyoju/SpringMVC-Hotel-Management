/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.havoc.hotel.admin.dao.impl;

import com.havoc.hotel.admin.constant.SQLConstant;
import com.havoc.hotel.admin.dao.RoomDAO;
import com.havoc.hotel.admin.entity.Room;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.mail.Multipart;
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
@Repository(value = "RoomDAO")
public class RoomDAOImpl implements RoomDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    private Room mapData(ResultSet rs) throws SQLException{
      List<Multipart> image = new ArrayList<>();
      Room r= new Room();
      r.setRoomId(rs.getInt("room_id"));
      r.setRoomType(rs.getString("room_type"));
      r.setRoomDescription(rs.getString("room_description"));
      r.setRoomNumber(rs.getInt("room_number"));
      r.setRoomPrice(rs.getInt("room_price"));
      r.setRoomImage(rs.getString("room_image"));
      return r;
    
    }

    @Override
    public List<Room> getALL() throws SQLException {
        return jdbcTemplate.query(SQLConstant.ROOM_GETALL, new RowMapper<Room>() {
            @Override
            public Room mapRow(ResultSet rs, int i) throws SQLException {
               return mapData(rs);
            }
        });
    }

    @Override
    public int insert(Room r) throws SQLException {
        return jdbcTemplate.update(SQLConstant.ROOM_INSERT, new Object[]{
            r.getRoomId(),
            r.getRoomType(),
            r.getRoomDescription(),
            r.getRoomNumber(),
            r.getRoomPrice(),
            r.getRoomImage()});
    }

    @Override
    public Room getById(int roomId) throws SQLException {
        return jdbcTemplate.query(SQLConstant.ROOM_GETBYID, new Object[]{roomId} ,new ResultSetExtractor<Room>() {

           @Override
           public Room extractData(ResultSet rs) throws SQLException, DataAccessException {
              Room r= null;
              if(rs.next()){
              r= new Room();
              r.setRoomId(rs.getInt("room_id"));
              r.setRoomType(rs.getString("room_type"));
              r.setRoomDescription(rs.getString("room_description"));
              r.setRoomNumber(rs.getInt("room_number"));
              r.setRoomPrice(rs.getInt("room_price"));
              r.setRoomImage(rs.getString("room_image"));
              }
              return r;
           }
       });
    }

    @Override
    public int update(Room r) throws SQLException {
        return jdbcTemplate.update(SQLConstant.ROOM_UPDATE, new Object[]{
            r.getRoomType(),
            r.getRoomDescription(),
            r.getRoomNumber(),
            r.getRoomPrice(),
            r.getRoomImage(),
            r.getRoomId()
        });
    }

    @Override
    public int delete(int roomId) throws SQLException {
        return jdbcTemplate.update(SQLConstant.ROOM_DELETE, new Object[]{roomId});
    }
    
}
