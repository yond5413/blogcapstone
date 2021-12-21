/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.cardealership.dao;

import com.mthree.cardealership.TestApplicationConfiguration;
import com.mthree.cardealership.entity.Sale;
import java.math.BigDecimal;
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
public class SaleDaoDBTest {
    
    @Autowired
    private SaleDAO testSaleDao;
     
    public SaleDaoDBTest() {
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
     * Test of getAllSales method, of class SaleDaoDB.
     */
    @Test
    public void testGetAllSales() {
        List<Sale> sales = testSaleDao.getAllSales();
        assertEquals(sales.size(), 4);
    }

    /**
     * Test of addSale method, of class SaleDaoDB.
     */
    @Test
    public void testAddSale() {
       Sale newSale = new Sale();
       newSale.setSaleId(4);
       newSale.setVehicleId("3LNHL2GCXBR784465");
       newSale.setEmailAddress("random@mail.com");
       newSale.setAddress("533 RandomSt");
       newSale.setZipCode("55555");
       newSale.setSalePrice(new BigDecimal("11111.00"));
       newSale.setPurchaseType(1);
       newSale.setUserId(1);

       testSaleDao.addSale(newSale);
       
       List<Sale> sales = testSaleDao.getAllSales();
       
       Sale lastSale = sales.get(sales.size() - 1 );
        assertEquals(newSale.getAddress(), lastSale.getAddress());
    }
    
}
