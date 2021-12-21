/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.cardealership.dao;

import com.mthree.cardealership.TestApplicationConfiguration;
import com.mthree.cardealership.entity.User;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Gordak
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)
public class UserDaoDBTest {
    
    @Autowired
    private UserDao testUserDao;
     
    public UserDaoDBTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAllUsers method, of class UserDaoDB.
     */
    @Test
    public void testGetAllUsers() {
        List<User> users = testUserDao.getAllUsers();
        assertEquals(users.size(), 4);
    }

    /**
     * Test of getUserByUserId method, of class UserDaoDB.
     */
    @Test
    public void testGetUserByUserId() {
      
        User currUser = testUserDao.getUserByUserId(3);
        assertEquals(currUser.getFirstName(), "David");
    }
    
}
