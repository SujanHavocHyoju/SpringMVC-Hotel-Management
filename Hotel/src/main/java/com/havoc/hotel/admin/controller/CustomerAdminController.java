/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.havoc.hotel.admin.controller;

import com.havoc.hotel.admin.dao.CustomerDAO;
import com.havoc.hotel.admin.entity.Customer;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author HYOJU
 */
@Controller
@RequestMapping(value = "/admin/customer")
public class CustomerAdminController {

    @Autowired
    private CustomerDAO customerDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap map) throws SQLException {
        map.addAttribute("Customer", customerDAO.getALL());
        return "admin/customer/index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView add() throws SQLException {
        ModelAndView mv = new ModelAndView("/admin/customer/add");
        mv.addObject("Customer", new Customer());
        return mv;
    }

    @RequestMapping(value = "/edit/{customerId}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("customerId") int customerId) throws SQLException {
        ModelAndView mv = new ModelAndView("admin/customer/edit");
        mv.addObject("Customer", customerDAO.getById(customerId));
        return mv;
    }

    @RequestMapping(value = "/delete/{customerId}", method = RequestMethod.GET)
    public String delete(@PathVariable("customerId") int customerId) throws SQLException {
        customerDAO.delete(customerId);
        return "redirect:/admin/customer";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView newbooking() throws SQLException {
        ModelAndView mv = new ModelAndView("admin/customer/newcustomer");
        mv.addObject("Customer", customerDAO.getLast());
        return mv;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("Customer") Customer customer) throws SQLException {
        try {
            if (customer.getCustomerId() == 0) {
                customerDAO.insert(customer);
            } else {
                customerDAO.update(customer);
            }
        } catch (SQLException ex) {

        }
        return "redirect:/admin/customer";
    }
}
