package com.mthree.cardealership.dao;

import java.util.List;

import com.mthree.cardealership.entity.Sale;

public interface SaleDAO {
	
	List<Sale> getAllSales();
	
	Sale addSale(Sale sale);
}
