/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.cardealership.dao;

import com.mthree.cardealership.TestApplicationConfiguration;
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

public class VehicleDaoDBTest {
    
    @Autowired
    private VehicleDao testVehicleDao;

    public VehicleDaoDBTest() {
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
     * Test of getAllVehicles method, of class VehicleDaoDB.
     */
    @Test
    public void testGetAllVehicles() {
       List<Vehicle> vehicles = testVehicleDao.getAllVehicles();
       assertEquals(vehicles.size(), 8);
    }

    /**
     * Test of getNewCars method, of class VehicleDaoDB.
     */
    @Test
    public void testGetNewCars() {
       List<Vehicle> newVehicles = testVehicleDao.getNewCars();
       assertEquals(newVehicles.size(), 4);
    }

    /**
     * Test of getUsedCars method, of class VehicleDaoDB.
     */
    @Test
    public void testGetUsedCars() {
       List<Vehicle> usedVehicles = testVehicleDao.getUsedCars();
       assertEquals(usedVehicles.size(), 4);
    }

    /**
     * Test of getVehicleByVin method, of class VehicleDaoDB.
     */
    @Test
    public void testGetVehicleByVin() {
      Vehicle vehicle = testVehicleDao.getVehicleByVin("JHMGD38498S018233");
        assertEquals(vehicle.getMake(), "MERCEDES BENZ");
    }
    
}
