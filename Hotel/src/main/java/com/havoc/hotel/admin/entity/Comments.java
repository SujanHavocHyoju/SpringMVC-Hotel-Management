/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.havoc.hotel.admin.entity;

/**
 *
 * @author HYOJU
 */
public class Comments {
    private int commentsId;
     private Customer customer;
    private String message;

    public Comments() {
    }

    public Comments(int commentsId, Customer customer, String message) {
        this.commentsId = commentsId;
        this.customer = customer;
        this.message = message;
    }

    public int getCommentsId() {
        return commentsId;
    }

    public void setCommentsId(int commentsId) {
        this.commentsId = commentsId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    
    @Override
    public String toString() {
        return "Comments{" + "commentsId=" + commentsId + ", customer=" + customer + ", message=" + message + '}';
    }
    
    
}

