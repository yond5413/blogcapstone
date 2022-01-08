/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cardealership.dao;

import com.cardealership.entity.User;
import java.util.List;

/**
 *
 * @author yond1
 */
public interface UserDao {
    List<User> getAllUsers();
    User getUserByUserId(int userId);
}
