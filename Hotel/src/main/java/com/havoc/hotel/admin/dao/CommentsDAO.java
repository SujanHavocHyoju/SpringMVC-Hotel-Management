/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.havoc.hotel.admin.dao;

import com.havoc.hotel.admin.entity.Comments;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author HYOJU
 */
public interface CommentsDAO {
    List<Comments> getALL() throws SQLException;
    int insert (Comments comm) throws SQLException;
    Comments getById (int commentsId) throws SQLException;
    int update (Comments comm) throws SQLException;
    int delete (int commentsId) throws SQLException;
}
