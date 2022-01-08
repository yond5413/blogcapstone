package com.mthree.cardealership.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mthree.cardealership.dao.SaleDAO;
import com.mthree.cardealership.dao.UserDao;
import com.mthree.cardealership.dao.VehicleDao;
import com.mthree.cardealership.entity.Sale;
import com.mthree.cardealership.entity.User;
import com.mthree.cardealership.entity.Vehicle;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarDealershipServiceLayer {
	
	@Autowired
	private SaleDAO saleDao;
	@Autowired
	private VehicleDao vehicleDao;
	@Autowired
	private UserDao userDao;
        
        public Vehicle getCarDetails(String vin){
            return vehicleDao.getVehicleByVin(vin);
        }
        
        public List<Sale> getSalesIndex(){
            return saleDao.getAllSales();
        }
         
        public List<Vehicle> getNewCars(){
        return vehicleDao.getNewCars();
    }
    
     public List<Vehicle> getUsedCars(){
        return vehicleDao.getUsedCars();
    }
	
	public List<Vehicle> getFeaturedVehicles() {
		List<Vehicle> featured = new ArrayList<>();
		List<Vehicle> vehiclesFromDao = vehicleDao.getAllVehicles();
		for(Vehicle v : vehiclesFromDao) {
			if (v.isFeatured()) {
				featured.add(v);
			}
		}
		return featured;
	}
	
	public Sale completeSale(String vehichleId) {
		Sale sale = new Sale();
		Vehicle v = vehicleDao.getVehicleByVin(vehichleId);
		User u = userDao.getUserByUserId(2);
		sale.setVehicleId(v.getVIN());
		sale.setEmailAddress("example@email.com");
		sale.setAddress(null);
		sale.setZipCode("85365");
		sale.setSalePrice(v.getMSRP());
		sale.setPurchaseType(1);
		sale.setUserId(u.getUserId());
		v.setAvailable(false);
		return saleDao.addSale(sale);
	}
      
}
