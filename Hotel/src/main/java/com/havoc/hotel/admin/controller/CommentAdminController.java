/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.havoc.hotel.admin.controller;

import com.havoc.hotel.admin.dao.CommentsDAO;
import com.havoc.hotel.admin.dao.CustomerDAO;
import com.havoc.hotel.admin.entity.Comments;
import com.havoc.hotel.admin.entity.Customer;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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
@RequestMapping(value = "/admin/comments")
public class CommentAdminController {

    @Autowired
    private CommentsDAO commentsDAO;
    @Autowired
    private CustomerDAO customerDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap map) throws SQLException {
        map.addAttribute("Comments", commentsDAO.getALL());
        return "admin/comments/index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView add(HttpServletRequest request) throws SQLException {
        ModelAndView mv = new ModelAndView("/admin/comments/add");
        String customerId = null;
        if (request.getParameter("customerId") != null && !request.getParameter("customerId").equals("")) {
            customerId = request.getParameter("customerId");
        }
        mv.addObject("Comments", new Comments());
        mv.addObject("Customer", customerDAO.getALL());
        return mv;
    }

    @RequestMapping(value = "/delete/{commentsId}", method = RequestMethod.GET)
    public String delete(@PathVariable("commentsId") int commentsId) throws SQLException {
        System.out.println(commentsId);
        commentsDAO.delete(commentsId);
        return "redirect:/admin/comments";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("Comments") Comments comment, BindingResult result) throws SQLException {
        System.out.println("chcek" + comment.getCustomer());
        Customer customer = customerDAO.getById(comment.getCustomer().getCustomerId());
        try {
            comment.setCustomer(customer);
            if (comment.getCommentsId() == 0) {
                commentsDAO.insert(comment);

            } else {
                commentsDAO.update(comment);
            }
        } catch (SQLException ex) {

        }
        return "redirect:/admin/comments";
    }

}
