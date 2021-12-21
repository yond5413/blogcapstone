/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.cardealership.dao;

import com.mthree.cardealership.entity.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author yond1
 */
@Repository 
public class UserDaoDB implements UserDao{
    @Autowired
    JdbcTemplate jdbc;

 
    /////////////////////////////////////////////////////////////////////
    public static final class UserMapper implements RowMapper<User> {  
        @Override
        public User mapRow(ResultSet rs, int index) throws SQLException {
            User user = new User();
            user.setUserId(rs.getInt("userID"));
            user.setFirstName(rs.getString("FirstName"));
            user.setLastName(rs.getString("LastName"));
            user.setRole(rs.getInt("Role"));
            return user;
        }
    }
    /////////////////////////////////////////////////////////////////////
   
    @Override
    public List<User> getAllUsers() {
        final String SELECT_ALL_USERS ="SELECT * FROM user";
        return jdbc.query(SELECT_ALL_USERS, new UserMapper());
    }

    @Override
    public User getUserByUserId(int userId) {
        try {
            final String SELECT_USER_BY_ID = "SELECT * FROM user WHERE userID = ?";
            return jdbc.queryForObject(SELECT_USER_BY_ID, new UserMapper(), userId);
        } catch(DataAccessException ex) {
            return null;
        }
    }   
}
