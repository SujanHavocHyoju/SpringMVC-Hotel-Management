/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.havoc.hotel.admin.dao;

import com.havoc.hotel.admin.entity.Checkin;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author HYOJU
 */
public interface CheckinDAO {
    List<Checkin> getALL() throws SQLException;
    int checkout(int checkinId) throws SQLException;
}
