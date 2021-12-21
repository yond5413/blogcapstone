package com.mthree.cardealership.dao;

import com.mthree.cardealership.entity.Vehicle;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yond1
 */
public interface VehicleDao {

    
    List<Vehicle> getAllVehicles();
    Vehicle getVehicleByVin(String VIN);
    public List<Vehicle> getNewCars();
    public List<Vehicle> getUsedCars();


    /*Vehicle addVehicle(Vehicle vehicle);
    void updateVehicle(Vehicle vehicle);*/
}
