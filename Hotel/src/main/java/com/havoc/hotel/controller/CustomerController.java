/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.havoc.hotel.controller;

import com.havoc.hotel.admin.dao.CustomerDAO;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author HYOJU
 */
@Controller
@RequestMapping(value="/customer")
public class CustomerController {
    
    @Autowired
     private CustomerDAO customerDAO;
    
     @RequestMapping(value = "/customerdetail/{username}", method = RequestMethod.GET)
    public ModelAndView userdetail(@PathVariable("username") String username) throws SQLException {
        ModelAndView mv = new ModelAndView("customer/index");
        mv.addObject("customer", customerDAO.getByUsername(username));
        return mv;
    }
}
