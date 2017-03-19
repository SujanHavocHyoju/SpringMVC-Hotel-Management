/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.havoc.hotel.controller;

import com.havoc.hotel.admin.dao.CustomerDAO;
import com.havoc.hotel.admin.entity.Customer;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author HYOJU
 */
@Controller
@RequestMapping("/register")
public class RegisterController {
    
    @Autowired
    private CustomerDAO customerDAO;
    
    @RequestMapping(value="/add",method=RequestMethod.GET)
      public ModelAndView add() throws SQLException{
      ModelAndView mv= new ModelAndView("register/add");
      mv.addObject("Customer", new Customer());
       return mv;
      }
      
      @RequestMapping(value="/save",method=RequestMethod.POST)
     public String save(@ModelAttribute ("Customer")Customer customer) throws SQLException{
      try   
          {
            if(customer.getCustomerId()==0){
             customerDAO.insert(customer);
            }
            else
            { 
             customerDAO.update(customer);
             }
        } catch (SQLException ex) {
           
        }
    return "redirect:/room";
    }
}
