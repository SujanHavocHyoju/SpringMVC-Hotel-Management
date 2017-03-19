/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.havoc.hotel.admin.dao;

import com.havoc.hotel.admin.entity.User;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author HYOJU
 */
public interface UserDAO {
    List<User> getALL() throws SQLException;
    int insert (User u) throws SQLException;
    User getById (int userId) throws SQLException;
    int update (User u) throws SQLException;
    int delete (int userId) throws SQLException;
    public User authenticate(String username,String password);
}
