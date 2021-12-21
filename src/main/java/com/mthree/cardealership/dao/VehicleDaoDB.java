/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.cardealership.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mthree.cardealership.entity.Vehicle;

/**
 *
 * @author yond1
 */
@Repository
public class VehicleDaoDB implements VehicleDao{
    
    @Autowired
    JdbcTemplate jdbc;
    ///////////////////////////////////////////////////////////////////////
    public static final class VehicleMapper implements RowMapper<Vehicle>{

        @Override
        public Vehicle mapRow(ResultSet rs, int i) throws SQLException {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            Vehicle vehicle = new Vehicle();
            vehicle.setVIN(rs.getString("VIN"));
            vehicle.setMake(rs.getString("Make"));
            vehicle.setModel(rs.getString("Model"));
            vehicle.setYear(rs.getString("Year"));
            vehicle.setTransmission(rs.getBoolean("Transmission"));
            vehicle.setColor(rs.getInt("Color"));
            vehicle.setInteriorColor(rs.getInt("InteriorColor"));
            vehicle.setType(rs.getInt("Type"));
            vehicle.setMSRP(rs.getBigDecimal("MSRP"));
            vehicle.setImageURL(rs.getString("ImageURL"));
            vehicle.setFeatured(rs.getBoolean("Featured"));
            return vehicle;
        }
    
    }
    ///////////////////////////////////////////////////////////////////////
    @Override
    public List<Vehicle> getAllVehicles() {
        final String SELECT_ALL_VEHICLES = "SELECT * FROM vehicle";
        return jdbc.query(SELECT_ALL_VEHICLES, new VehicleMapper());
    }

    @Override
    public List<Vehicle> getNewCars(){
        final String sql = "SELECT * "
                + "FROM vehicle "
                + "where ( (make LIKE '%%') or (model LIKE '%%') or"
                + " (`year` LIKE '%%') ) and type = 1 "
                + "LIMIT 20;";
                
        return jdbc.query(sql, new VehicleMapper());
    }
    
    @Override
    public List<Vehicle> getUsedCars(){
        final String sql = "SELECT * "
                + "FROM vehicle "
                + "where ( (make LIKE '%%') or (model LIKE '%%') or"
                + " (`year` LIKE '%%') ) and type = 2 "
                + "LIMIT 20;";
                
        return jdbc.query(sql, new VehicleMapper());
    }
    
    @Override
    public Vehicle getVehicleByVin(String VIN) {
    	try{
    		final String SELECT_BY_VIN = "SELECT * FROM vehicle where VIN = ?";
    		return jdbc.queryForObject(SELECT_BY_VIN, new VehicleMapper(),VIN);
    	}catch(DataAccessException ex){
    		return null;
    	}
    }
    
    /*
    @Override
    public Vehicle addVehicle(Vehicle vehicle) {
        final String INSERT_VEHICLE; //= "INSERT INTO vehicle(VIN) VALUES (?)";
        //jdbc.update(INSERT_VEHICLE, game.getAnswer());
        
        //int newGameId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        //game.setGameId(newGameId);
        return null;
    }

    @Override
    public void updateVehicle(Vehicle vehicle) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    */

}