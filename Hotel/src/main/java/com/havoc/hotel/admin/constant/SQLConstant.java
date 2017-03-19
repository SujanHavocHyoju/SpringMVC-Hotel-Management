/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.havoc.hotel.admin.constant;

/**
 *
 * @author HYOJU
 */
public class SQLConstant {
    //USER
    public final static String USER_GETALL = " SELECT * FROM " + TableConstant.TABLE_USER;
    public final static String USER_INSERT = " INSERT INTO " + TableConstant.TABLE_USER
            + "(first_name,last_name,email,username,password,role_id,status) VALUES (?,?,?,?,?,?,?) ";
    public final static String USER_DELETE = " DELETE FROM " + TableConstant.TABLE_USER + " WHERE user_id= ?";
    public final static String USER_GETById = " SELECT * from " + TableConstant.TABLE_USER + " WHERE user_id=? ";
    public final static String USER_UPDATE = " UPDATE " + TableConstant.TABLE_USER + " SET first_name=?,last_name=?,email=?,username=?,password=?,role_id=?,status=? WHERE user_id=? ";
    public final static String USER_AUTHENTICATE = " SELECT * FROM " + TableConstant.TABLE_USER + " WHERE username=? AND password=? ";

    //Room
    public final static String ROOM_GETALL = " SELECT * FROM " + TableConstant.TABLE_ROOM;
    public final static String ROOM_INSERT = " INSERT INTO " + TableConstant.TABLE_ROOM + " (room_id,room_type,room_description,room_number,room_price,room_image)  VALUES (?,?,?,?,?,?) ";
    public final static String ROOM_UPDATE = " UPDATE " + TableConstant.TABLE_ROOM + " SET room_type=?,room_description=?,room_number=?,room_price=? ,room_image=?  WHERE room_id = ? ";
    public final static String ROOM_DELETE = " DELETE FROM " + TableConstant.TABLE_ROOM + " WHERE room_id=?";
    public final static String ROOM_GETBYID = " SELECT * FROM " + TableConstant.TABLE_ROOM + " WHERE room_id=?";

    //Customer
    public final static String CUSTOMER_GETALL = " SELECT * FROM " + TableConstant.TABLE_CUSTOMER;
    public final static String CUSTOMER_INSERT = " INSERT INTO " + TableConstant.TABLE_CUSTOMER
            + "(customer_id,first_name,last_name,email,contact_no,username,password,status)"
            + " VALUES (?,?,?,?,?,?,?,?) ";
    public final static String CUSTOMER_UPDATE = " UPDATE " + TableConstant.TABLE_CUSTOMER + " SET first_name=?,last_name=?,email=?,contact_no=?,username=?,password=?,status=? WHERE customer_id=? ";
    public final static String CUSTOMER_DELETE = " DELETE  FROM " + TableConstant.TABLE_CUSTOMER + " WHERE customer_id=?";
    public final static String CUSTOMER_GETBYID = " SELECT * FROM " + TableConstant.TABLE_CUSTOMER + " WHERE customer_id = ? ";
    public final static String CUSTOMER_AUTHENTICATE = " SELECT * FROM " + TableConstant.TABLE_CUSTOMER + " WHERE username=? AND password=? ";
    public final static String CUSTOMER_GETBYUSER = " SELECT * FROM " + TableConstant.TABLE_CUSTOMER + " WHERE username=?  ";
    public final static String CUSTOMER_GETLAST= " SELECT * FROM " + TableConstant.TABLE_CUSTOMER + " ORDER BY customer_id DESC LIMIT  5 ";

    
    //Booking
    public final static String BOOKING_GETALL = " SELECT * FROM " + TableConstant.TABLE_BOOKING + " b join " + TableConstant.TABLE_ROOM + " r on b.room_id = r.room_id join " + TableConstant.TABLE_CUSTOMER + " c on c.customer_id=b.customer_id ";
    public final static String BOOKING_INSERT = " INSERT INTO " + TableConstant.TABLE_BOOKING
            + "(first_name,last_name,room_id,room_number,room_price,room_type,checkin_date,total_days,total_nights,checkout_date,total_price,customer_id,pdf,status) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
    public final static String BOOKING_UPDATE = " UPDATE " + TableConstant.TABLE_BOOKING + "  SET first_name=?,last_name=?,"
            + "checkin_date=?,total_days=?,total_nights=?,total_price=?,checkout_date=?,status=? WHERE booking_id=? ";
    public final static String BOOKING_DELETE = " DELETE FROM " + TableConstant.TABLE_BOOKING + " WHERE booking_id=? ";
    public final static String BOOKING_GETBYID = " SELECT * FROM " + TableConstant.TABLE_BOOKING + " b join "
            + TableConstant.TABLE_ROOM + " r on b.room_id=r.room_id join " + TableConstant.TABLE_CUSTOMER + " c on c.customer_id = b.customer_id  WHERE booking_id=? ";
    public final static String BOOKING_CHECKIN = " INSERT INTO " + TableConstant.TABLE_CHECKIN + "(booking_id,first_name,last_name,room_price,room_number,checkin_date,checkout_date,total_price,total_days,total_nights) SELECT booking_id,first_name,last_name,room_price,room_number, checkin_date, checkout_date,total_price,total_days,total_nights From " + TableConstant.TABLE_BOOKING + " where booking_id=? ";
    public final static String BOOKING_INSERTCLIENT = " INSERT INTO " + TableConstant.TABLE_BOOKING
            + "(first_name,last_name,room_id,room_number,room_price,room_type,checkin_date,total_days,total_nights,checkout_date,total_price,customer_id,username,pdf,status) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
    public final static String BOOKING_GETBYUSER= " SELECT * FROM " + TableConstant.TABLE_BOOKING + " b join "
            + TableConstant.TABLE_ROOM + " r on b.room_id=r.room_id join " + TableConstant.TABLE_CUSTOMER + " c on c.customer_id = b.customer_id  WHERE username=? ";
    public final static String BOOKING_GETLAST= " SELECT * FROM " + TableConstant.TABLE_BOOKING + " ORDER BY booking_id DESC LIMIT  5 ";
    
    
    //comments
    public final static String COMMENTS_GETALL = " SELECT * FROM " + TableConstant.TABLE_COMMENTS + " c join " + TableConstant.TABLE_CUSTOMER + " cu on c.customer_id = cu.customer_id ";
    public final static String COMMENTS_INSERT = " INSERT INTO " + TableConstant.TABLE_COMMENTS + " (comment_id,customer_id,first_name,last_name,username,message) VALUES (?,?,?,?,?,?) ";
    public final static String COMMENTS_UPDATE = " UPDATE " + TableConstant.TABLE_COMMENTS + " SET message=? , customer=? WHERE comment_id=? ";
    public final static String COMMENTS_DELETE = " DELETE FROM " + TableConstant.TABLE_COMMENTS + " WHERE comment_id = ? ";
    public final static String COMMENTS_GETBYID = " SELECT * FROM " + TableConstant.TABLE_COMMENTS + " c join " + TableConstant.TABLE_CUSTOMER + " cu on c.customer_id = cu.customer_id WHERE comment_id=? ";
    
    //CheckIn
    public final static String CHECKIN_GETALL =  " SELECT * FROM  " + TableConstant.TABLE_CHECKIN;
    public final static String CHECKIN_CHECKOUT= " INSERT INTO  " + TableConstant.TABLE_CHECKOUT + "(checkin_id,first_name,last_name,room_price,room_number,checkin_date,checkout_date,total_price,total_days,total_nights) SELECT checkin_id,first_name,last_name,room_price,room_number, checkin_date, checkout_date,total_price,total_days,total_nights From " + TableConstant.TABLE_CHECKIN + " where checkin_id=? " ;
    
    //Checkout
    public final static String CHECKOUT_GETALL= "SELECT * FROM " + TableConstant.TABLE_CHECKOUT;

    
}
