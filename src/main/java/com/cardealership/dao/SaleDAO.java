package com.cardealership.dao;

import java.util.List;

import com.cardealership.entity.Sale;

public interface SaleDAO {
	
	List<Sale> getAllSales();
	
	Sale addSale(Sale sale);
}
