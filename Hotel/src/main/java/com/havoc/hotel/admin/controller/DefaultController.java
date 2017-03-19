/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.havoc.hotel.admin.controller;

import com.havoc.hotel.admin.dao.BookingDAO;
import com.havoc.hotel.admin.dao.UserDAO;
import com.havoc.hotel.admin.entity.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author HYOJU
 */
@Controller
public class DefaultController {

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private BookingDAO bookingDAO;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String login(ModelMap map) {
        System.out.println("Welcome");
        return "admin/login";
    }

    @RequestMapping(method = RequestMethod.POST, value = "checking")
    public String filter(HttpServletRequest req, HttpServletResponse res) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = userDAO.authenticate(username, password);
        if (user == null) {
            return "admin/login";
        } else {
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
            if (user.getRoleId()== 1) {
                return "admin/dashboard/dashboard";

            } else {

                return "admin/dashboard/dashboarduser";
            }

        }

    }

}
