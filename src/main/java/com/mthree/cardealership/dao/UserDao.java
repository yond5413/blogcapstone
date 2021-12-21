/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.cardealership.dao;

import com.mthree.cardealership.entity.User;
import java.util.List;

/**
 *
 * @author yond1
 */
public interface UserDao {
    List<User> getAllUsers();
    User getUserByUserId(int userId);
}
