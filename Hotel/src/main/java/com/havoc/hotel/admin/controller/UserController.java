/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.havoc.hotel.admin.controller;

import com.havoc.hotel.admin.dao.UserDAO;
import com.havoc.hotel.admin.entity.User;
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
@RequestMapping(value = "/admin/users")
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap map) throws SQLException {
        map.addAttribute("User", userDAO.getALL());
        return "admin/users/index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView adduser() throws SQLException {
        ModelAndView mv = new ModelAndView("/admin/users/add");
        mv.addObject("User", new User());
        return mv;
    }

    @RequestMapping(value = "/edit/{user_id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("user_id") int userId) throws SQLException {
        ModelAndView mv = new ModelAndView("admin/users/edit");
        mv.addObject("User", userDAO.getById(userId));
        return mv;
    }

    @RequestMapping(value = "/delete/{user_id}", method = RequestMethod.GET)
    public String delete(@PathVariable("user_id") int userId) throws SQLException {
        userDAO.delete(userId);
        return "redirect:/admin/users";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("User") User user) throws SQLException {
        try {
            if (user.getUserId() == 0) {
                userDAO.insert(user);
            } else {
                userDAO.update(user);
            }
        } catch (SQLException ex) {

        }
        return "redirect:/admin/users";
    }

}
