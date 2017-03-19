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
public class Checkout {
    private int checkoutId;
    private Checkin checkin;

    public Checkout() {
    }

    public Checkout(int checkoutId, Checkin checkin) {
        this.checkoutId = checkoutId;
        this.checkin = checkin;
    }

    public int getCheckoutId() {
        return checkoutId;
    }

    public void setCheckoutId(int checkoutId) {
        this.checkoutId = checkoutId;
    }

    public Checkin getCheckin() {
        return checkin;
    }

    public void setCheckin(Checkin checkin) {
        this.checkin = checkin;
    }

    @Override
    public String toString() {
        return "Checkout{" + "checkoutId=" + checkoutId + ", checkin=" + checkin + '}';
    }
    
    
}
