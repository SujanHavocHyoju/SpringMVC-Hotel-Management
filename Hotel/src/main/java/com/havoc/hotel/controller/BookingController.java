/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.havoc.hotel.controller;


import com.havoc.hotel.admin.dao.BookingDAO;
import com.havoc.hotel.admin.dao.CustomerDAO;
import com.havoc.hotel.admin.dao.RoomDAO;
import com.havoc.hotel.admin.entity.Booking;
import com.havoc.hotel.admin.entity.Customer;
import com.havoc.hotel.admin.entity.Room;
import com.havoc.hotel.util.BookingPdf;
import com.itextpdf.text.DocumentException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
@RequestMapping(value="/booking")
public class BookingController {
    
    @Autowired
    private BookingDAO bookingDAO;
    @Autowired
    private CustomerDAO customerDAO;
    @Autowired
    private RoomDAO roomDAO;
    
     

     @RequestMapping(value = "/userdetail/{username}", method = RequestMethod.GET)
    public ModelAndView userdetail(@PathVariable("username") String username) throws SQLException {
        ModelAndView mv = new ModelAndView("booking/index");
        mv.addObject("Booking", bookingDAO.getByUser(username));
        return mv;
    }
    
     @RequestMapping(value = "/delete/{bookingId}", method = RequestMethod.GET)
    public String delete(@PathVariable("bookingId") int bookingId) throws SQLException {
        bookingDAO.delete(bookingId);
        return "redirect:/dashboard/dashboard";
    }
  @RequestMapping(value = "/add/{roomId}", method = RequestMethod.GET)
    public ModelAndView add(HttpServletRequest request,@PathVariable ("roomId") int roomId) throws SQLException {
        ModelAndView mv;
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        System.out.println("username: "+username);
        if(username!=null)
        {
        mv = new ModelAndView("booking/add");
        String customer_id = null;
        String room_id = null;
        if (request.getParameter("customerId") != null && !request.getParameter("customerId").equals("")) 
        {
            customer_id = request.getParameter("customerId");
        }
        if (request.getParameter("roomId") != null && !request.getParameter("roomId").equals("")) 
        {
            room_id = request.getParameter("roomId");
        }
        mv.addObject("Booking", new Booking());
        mv.addObject("Customer", customerDAO.getALL());
        mv.addObject("Room", roomDAO.getALL());
        Room room= roomDAO.getById(roomId);
        mv.addObject("roomDetails", room);
        }
        else
        {
            mv = new ModelAndView("login/login");
        }
        return mv;
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("Booking") Booking booking, BindingResult result ,HttpServletRequest request) throws SQLException, ParseException, DocumentException, IOException {
        
        Customer customer=customerDAO.getByUsername(booking.getCustomer().getUsername());
        Room room = roomDAO.getById(booking.getRoom().getRoomId());
        long totalNights = (booking.getCheckoutDate().getTime() - booking.getCheckinDate().getTime()) / (24 * 60 * 60 * 1000);
        System.out.println(totalNights);
        booking.setTotalNights((int) totalNights);
        int totalPrice = (booking.getTotalNights() *  booking.getRoom().getRoomPrice());
        booking.setTotalPrice(totalPrice);
        System.out.println(totalPrice);
        System.out.println("check" + booking);
        
        System.out.println("check" + room);
        
        try 
        {
            booking.setCustomer(customer);
            booking.setRoom(room);
            if (booking.getBookingId()== 0) 
                
        { 
        booking.setPdf(BookingPdf.generateBookingPDF(booking));
        System.out.println("test");
        bookingDAO.insertClient(booking);
        } 
        else 
        {
        bookingDAO.update(booking);
        }
        } 
        catch (SQLException ex) {
        }
        return "dashboard/dashboard";
    }
   
       

    
}
