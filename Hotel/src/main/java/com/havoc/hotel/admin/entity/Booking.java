/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.havoc.hotel.admin.entity;

import java.sql.Date;

/**
 *
 * @author HYOJU
 */
public class Booking {
    
    private int bookingId;
    private String firstName;
    private String lastName;
    private Room room;
    private Date checkinDate;
    private int totalDays;
    private int totalNights;
    private Date checkoutDate;
    private int totalPrice;
    private Customer customer;
    private boolean status;
    private String pdf;

    public Booking() {
    }

    public Booking(int bookingId, String firstName, String lastName, Room room, Date checkinDate, int totalDays, int totalNights, Date checkoutDate, int totalPrice, Customer customer, boolean status, String pdf) {
        this.bookingId = bookingId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.room = room;
        this.checkinDate = checkinDate;
        this.totalDays = totalDays;
        this.totalNights = totalNights;
        this.checkoutDate = checkoutDate;
        this.totalPrice = totalPrice;
        this.customer = customer;
        this.status = status;
        this.pdf = pdf;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Date getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(Date checkinDate) {
        this.checkinDate = checkinDate;
    }

    public int getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(int totalDays) {
        this.totalDays = totalDays;
    }

    public int getTotalNights() {
        return totalNights;
    }

    public void setTotalNights(int totalNights) {
        this.totalNights = totalNights;
    }

    public Date getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }

    @Override
    public String toString() {
        return "Booking{" + "bookingId=" + bookingId + ", firstName=" + firstName + ", lastName=" + lastName + ", room=" + room + ", checkinDate=" + checkinDate + ", totalDays=" + totalDays + ", totalNights=" + totalNights + ", checkoutDate=" + checkoutDate + ", totalPrice=" + totalPrice + ", customer=" + customer + ", status=" + status + ", pdf=" + pdf + '}';
    }
    
    
    
}
