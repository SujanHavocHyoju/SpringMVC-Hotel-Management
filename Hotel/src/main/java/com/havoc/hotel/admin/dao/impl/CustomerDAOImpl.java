/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.havoc.hotel.admin.dao.impl;

import com.havoc.hotel.admin.constant.SQLConstant;
import com.havoc.hotel.admin.dao.CustomerDAO;
import com.havoc.hotel.admin.entity.Customer;
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
@Repository(value = "CustomerDAO")
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private Customer mapData(ResultSet rs) throws SQLException {
        Customer c = new Customer();
        c.setCustomerId(rs.getInt("customer_id"));
        c.setFirstName(rs.getString("first_name"));
        c.setLastName(rs.getString("last_name"));
        c.setEmail(rs.getString("email"));
        c.setContactNo(rs.getString("contact_no"));
        c.setUsername(rs.getString("username"));
        c.setPassword(rs.getString("password"));
        c.setAddedDate(rs.getDate("added_date"));
        c.setStatus(rs.getBoolean("status"));
        return c;

    }

    @Override
    public List<Customer> getALL() throws SQLException {
        return jdbcTemplate.query(SQLConstant.CUSTOMER_GETALL, new RowMapper<Customer>() {
            @Override
            public Customer mapRow(ResultSet rs, int i) throws SQLException {
                return mapData(rs);
            }
        });
    }

    @Override
    public int insert(Customer c) throws SQLException {
        return jdbcTemplate.update(SQLConstant.CUSTOMER_INSERT, new Object[]{
            c.getCustomerId(),
            c.getFirstName(),
            c.getLastName(),
            c.getEmail(),
            c.getContactNo(),
            c.getUsername(),
            c.getPassword(),
            c.isStatus()
        });
    }

    @Override
    public Customer getById(int customerId) throws SQLException {
        return (Customer) jdbcTemplate.query(SQLConstant.CUSTOMER_GETBYID, new Object[]{customerId}, new ResultSetExtractor<Customer>() {

            @Override
            public Customer extractData(ResultSet rs) throws SQLException, DataAccessException {
                Customer c = null;
                if (rs.next()) {
                    c = new Customer();
                    c.setCustomerId(rs.getInt("customer_id"));
                    c.setFirstName(rs.getString("first_name"));
                    c.setLastName(rs.getString("last_name"));
                    c.setEmail(rs.getString("email"));
                    c.setContactNo(rs.getString("contact_no"));
                    c.setUsername(rs.getString("username"));
                    c.setPassword(rs.getString("password"));
                    c.setAddedDate(rs.getDate("added_date"));
                    c.setStatus(rs.getBoolean("status"));
                }
                return c;
            }
        });
    }

    @Override
    public int update(Customer c) throws SQLException {
        return jdbcTemplate.update(SQLConstant.CUSTOMER_UPDATE, new Object[]{
            c.getFirstName(),
            c.getLastName(),
            c.getEmail(),
            c.getContactNo(),
            c.getUsername(),
            c.getPassword(),
            c.isStatus(),
            c.getCustomerId()
        });
    }

    @Override
    public int delete(int customerId) throws SQLException {
        return jdbcTemplate.update(SQLConstant.CUSTOMER_DELETE, new Object[]{customerId});
    }

    @Override
    public Customer getByUsername(String username) throws SQLException {
        return jdbcTemplate.query(SQLConstant.CUSTOMER_GETBYUSER, new Object[]{username},new ResultSetExtractor<Customer>() {

            @Override
            public Customer extractData(ResultSet rs) throws SQLException, DataAccessException {
                Customer c= null;
             if(rs.next()){
             c = new Customer();
             c.setCustomerId(rs.getInt("customer_id"));
             c.setFirstName(rs.getString("first_name"));
             c.setLastName(rs.getString("last_name"));
             c.setEmail(rs.getString("email"));
             c.setContactNo(rs.getString("contact_no"));
             c.setUsername(rs.getString("username"));
             c.setPassword(rs.getString("password"));
             c.setAddedDate(rs.getDate("added_date"));
             c.setStatus(rs.getBoolean("status"));
             
             }
             return c;
               
            }
        });
    }

    @Override
    public Customer authenticate(String username, String password) {
        return (Customer) jdbcTemplate.query(SQLConstant.CUSTOMER_AUTHENTICATE, new Object[]{username,password},new ResultSetExtractor<Customer>() {

            @Override
            public Customer extractData(ResultSet rs) throws SQLException, DataAccessException {
                Customer c= null;
             if(rs.next()){
             c = new Customer();
             c.setCustomerId(rs.getInt("customer_id"));
             c.setFirstName(rs.getString("first_name"));
             c.setLastName(rs.getString("last_name"));
             c.setEmail(rs.getString("email"));
             c.setContactNo(rs.getString("contact_no"));
             c.setUsername(rs.getString("username"));
             c.setPassword(rs.getString("password"));
             c.setAddedDate(rs.getDate("added_date"));
             c.setStatus(rs.getBoolean("status"));
             
             }
             return c;
            }
        });
    }

    @Override
    public List<Customer> getLast() throws SQLException {
        return jdbcTemplate.query(SQLConstant.CUSTOMER_GETLAST, new RowMapper<Customer>() {

            @Override
            public Customer mapRow(ResultSet rs, int i) throws SQLException {
                return mapData(rs);
            }
        });
    }

}
