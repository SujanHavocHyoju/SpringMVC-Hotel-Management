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
public class Room {
    private int roomId;
    private String roomType;
    private String roomDescription;
    private int roomNumber;
    private int roomPrice;
    private String roomImage;

    public Room() {
    }

    public Room(int roomId, String roomType, String roomDescription, int roomNumber, int roomPrice, String roomImage) {
        this.roomId = roomId;
        this.roomType = roomType;
        this.roomDescription = roomDescription;
        this.roomNumber = roomNumber;
        this.roomPrice = roomPrice;
        this.roomImage = roomImage;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(int roomPrice) {
        this.roomPrice = roomPrice;
    }

    public String getRoomImage() {
        return roomImage;
    }

    public void setRoomImage(String roomImage) {
        this.roomImage = roomImage;
    }

    @Override
    public String toString() {
        return "Room{" + "roomId=" + roomId + ", roomType=" + roomType + ", roomDescription=" + roomDescription + ", roomNumber=" + roomNumber + ", roomPrice=" + roomPrice + ", roomImage=" + roomImage + '}';
    }
    
    
}
