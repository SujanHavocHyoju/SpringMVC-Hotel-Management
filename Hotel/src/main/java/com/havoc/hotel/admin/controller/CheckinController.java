/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.havoc.hotel.admin.controller;

import com.havoc.hotel.admin.dao.CheckinDAO;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author HYOJU
 */
@Controller
@RequestMapping(value="/admin/checkin")
public class CheckinController {
    
    @Autowired
    private CheckinDAO checkinDAO;
    
    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap map) throws SQLException {
        map.addAttribute("Checkin", checkinDAO.getALL());
        return "admin/checkin/index";
    }
     @RequestMapping(value = "/checkout/{checkinId}", method = RequestMethod.GET)
    public ModelAndView checkout(@PathVariable("checkinId") int checkinId) throws SQLException {
        ModelAndView mv = new ModelAndView("admin/checkout/index");
        mv.addObject("Checkin", checkinDAO.checkout(checkinId));
        return mv;
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/logout")
    public String Logout(HttpServletRequest req, HttpServletResponse resp){
        HttpSession session = req.getSession(false);
        String checking =(String) session.getAttribute("username");
        if(checking == null){
            return "redirect:/?logout=false";
        }else{
            session.invalidate();
            return "redirect:/admin";
        }
        }
    
}
