/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.havoc.hotel.admin.dao;

import com.havoc.hotel.admin.entity.Customer;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author HYOJU
 */
public interface CustomerDAO {
    List<Customer> getALL() throws SQLException;
    int insert (Customer c) throws SQLException;
    Customer getById (int c_id) throws SQLException; 
    int update (Customer c) throws SQLException;
    int delete (int c_id) throws SQLException;
    Customer getByUsername(String username)throws SQLException;
    public Customer authenticate(String username,String password);
    List <Customer> getLast() throws SQLException;
}
