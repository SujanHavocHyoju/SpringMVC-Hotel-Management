/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.havoc.hotel.admin.dao.impl;

import com.havoc.hotel.admin.constant.SQLConstant;
import com.havoc.hotel.admin.dao.UserDAO;
import com.havoc.hotel.admin.entity.User;
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
@Repository(value = "UserDAO")
public class UserDAOImpl implements UserDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    private User mapData(ResultSet rs) throws SQLException{
       User u= new User();
       u.setUserId(rs.getInt("user_id"));
       u.setFirstName(rs.getString("first_name"));
       u.setLastName(rs.getString("last_name"));
       u.setEmail(rs.getString("email"));
       u.setUsername(rs.getString("username"));
       u.setPassword(rs.getString("password"));
       u.setRoleId(rs.getInt("role_id"));
       u.setAddedDate(rs.getDate("added_date"));
       u.setStatus(rs.getBoolean("status"));
       return u;
    }
    
    @Override
    public List<User> getALL() throws SQLException {
        return   jdbcTemplate.query(SQLConstant.USER_GETALL, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int i) throws SQLException {
                return mapData(rs);
            }
        });
    }

    @Override
    public int insert(User u) throws SQLException {
        return jdbcTemplate.update(SQLConstant.USER_INSERT, new Object[]{
            u.getFirstName(),
            u.getLastName(),
            u.getEmail(),
            u.getUsername(),
            u.getPassword(),
            u.getRoleId(),
            u.isStatus()
        });
    }

    @Override
    public User getById(int userId) throws SQLException {
        return (User) jdbcTemplate.query(SQLConstant.USER_GETById, new Object[]{userId}, new ResultSetExtractor<User>() {

            @Override
            public User extractData(ResultSet rs) throws SQLException, DataAccessException {
                User u =null;
                if(rs.next()){
                u= new User();
                u.setUserId(rs.getInt("user_id"));
                u.setFirstName(rs.getString("first_name"));
                u.setLastName(rs.getString("last_name"));
                u.setEmail(rs.getString("email"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setRoleId(rs.getInt("role_id"));
                u.setAddedDate(rs.getDate("added_date"));
                u.setStatus(rs.getBoolean("status"));
                }
                return u;
            }
        });
    }

    @Override
    public int update(User u) throws SQLException {
        return jdbcTemplate.update(SQLConstant.USER_UPDATE, new Object[]{
            u.getFirstName(),
            u.getLastName(),
            u.getEmail(),
            u.getUsername(),
            u.getPassword(),
            u.getRoleId(),
            u.isStatus(),
            u.getUserId()
        });
    }

    @Override
    public int delete(int userId) throws SQLException {
        return jdbcTemplate.update(SQLConstant.USER_DELETE, new Object[]{userId});
    }

    @Override
    public User authenticate(String username, String password) {
        return (User) jdbcTemplate.query(SQLConstant.USER_AUTHENTICATE, new Object[]{username,password},new ResultSetExtractor<User>() {

            @Override
            public User extractData(ResultSet rs) throws SQLException, DataAccessException {
                User u =null;
                if(rs.next()){
                u= new User();
                u.setUserId(rs.getInt("user_id"));
                u.setFirstName(rs.getString("first_name"));
                u.setLastName(rs.getString("last_name"));
                u.setEmail(rs.getString("email"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setRoleId(rs.getInt("role_id"));
                u.setAddedDate(rs.getDate("added_date"));
                u.setStatus(rs.getBoolean("status"));
                }
                return u;
            }
        });
    }
    
}
