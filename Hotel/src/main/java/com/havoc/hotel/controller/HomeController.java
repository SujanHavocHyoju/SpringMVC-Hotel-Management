/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.havoc.hotel.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author HYOJU
 */
@Controller
@RequestMapping(value = "/")
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "home/index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "logout")
    public String Logout(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession(false);
        String checking = (String) session.getAttribute("username");
        if (checking == null) {
            return "redirect:/?logout=false";
        } else {
            session.invalidate();
            return "redirect:/";
        }
    }
}
