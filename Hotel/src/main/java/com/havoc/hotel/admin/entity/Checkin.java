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
public class Checkin {
    private int checkinId;
    private Booking booking;

    public Checkin() {
    }

    public Checkin(int checkinId, Booking booking) {
        this.checkinId = checkinId;
        this.booking = booking;
    }

    public int getCheckinId() {
        return checkinId;
    }

    public void setCheckinId(int checkinId) {
        this.checkinId = checkinId;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    @Override
    public String toString() {
        return "Checkin{" + "checkinId=" + checkinId + ", booking=" + booking + '}';
    }
    
    
}
