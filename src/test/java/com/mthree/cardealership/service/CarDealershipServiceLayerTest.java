/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.cardealership.service;

import com.mthree.cardealership.TestApplicationConfiguration;
import com.mthree.cardealership.entity.Sale;
import com.mthree.cardealership.entity.Vehicle;
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
 * @author 
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)
public class CarDealershipServiceLayerTest {
    
    @Autowired
    private CarDealershipServiceLayer testSvc;
    
    public CarDealershipServiceLayerTest() {
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
     * Test of getFeaturedVehicles method, of class CarDealershipServiceLayer.
     */
    @Test
    public void testGetFeaturedVehicles() {
        List<Vehicle> featuredV = testSvc.getFeaturedVehicles();
        assertEquals(featuredV.size(), 4);
    }

    /**
     * Test of completeSale method, of class CarDealershipServiceLayer.
     */
    @Test
    public void testCompleteSale() {
        Sale currSale = testSvc.completeSale("1FAFP34P91W264854");
        assertEquals(currSale.getUserId(), 2); 
    }
    
}
