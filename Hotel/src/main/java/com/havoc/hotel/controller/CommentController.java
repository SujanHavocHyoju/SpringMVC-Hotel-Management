/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.havoc.hotel.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author HYOJU
 */
@Controller
@RequestMapping(value="/about")
public class CommentController {
     
     /*@Autowired
     private CommentsDAO commentsDAO;
     @Autowired
     private  CustomerDAO customerDAO;*/
    
     @RequestMapping(method=RequestMethod.GET)
        public String index(){
        return "about/index";
        }
    /*
     @RequestMapping(value="/add",method=RequestMethod.GET)
      public ModelAndView add(HttpServletRequest request) throws SQLException{
      ModelAndView mv= new ModelAndView("/views/about/add");
      String  customerId=null;
        if(request.getParameter("customerId")!=null && !request.getParameter("customerId").equals("") )
        {
            customerId= request.getParameter("customerId");
        } 
      mv.addObject("Comments", new Comments());
      mv.addObject("Customer", customerDAO.getALL());
       return mv;
      }
      @RequestMapping(value="/save",method=RequestMethod.POST)
    public String save(@ModelAttribute ("Comments") Comments comment, BindingResult result) throws SQLException{
        
          System.out.println();
        System.out.println("chcek"+comment.getCustomer());
        Customer customer=customerDAO.getByUsername(comment.getCustomer().getUsername());
        try  
          {  
            comment.setCustomer(customer);
           if(comment.getCommentsId()==0){
            commentsDAO.insert(comment);
            }
            else
           { 
            commentsDAO.update(comment);
           }
        } catch (Exception e) {
           
        }
    return "redirect:/about";
    }
  
    */
}

