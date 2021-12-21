package com.mthree.cardealership.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mthree.cardealership.entity.Sale;

@Repository
public class SaleDaoDB implements SaleDAO {

	@Autowired
	private JdbcTemplate jdbc;

	@Override
	public List<Sale> getAllSales() {
		final String s = "SELECT * FROM sale";
		return jdbc.query(s, new SaleMapper());
	}

	@Override
	@Transactional
	public Sale addSale(Sale sale) {
		final String s = "INSERT INTO sale(vehicleID, EmailAddress, Address, ZipCode, salePrice, purchaseType, userID)"
                        +" VALUES(?,?,?,?,?,?,?)";
		jdbc.update(s, sale.getVehicleId(), sale.getEmailAddress(), sale.getAddress(), sale.getZipCode(),
				sale.getSalePrice(), sale.getPurchaseType(), sale.getUserId());
		int newSaleId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
		sale.setSaleId(newSaleId);
		return sale;
	}

	public static final class SaleMapper implements RowMapper<Sale> {
		@Override
		public Sale mapRow(ResultSet rs, int rowNum) throws SQLException {
			Sale sale = new Sale();
			sale.setSaleId(rs.getInt("saleID"));
			sale.setVehicleId(rs.getString("vehicleID"));
			sale.setEmailAddress(rs.getString("EmailAddress"));
			sale.setAddress(rs.getString("Address"));
			sale.setZipCode(rs.getString("ZipCode"));
			sale.setSalePrice(rs.getBigDecimal("salePrice"));
			sale.setPurchaseType(rs.getInt("purchaseType"));
			String dateString = rs.getString("date");
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime dateTime = LocalDateTime.parse(dateString, formatter);
			sale.setDate(dateTime);
			sale.setUserId(rs.getInt("userID"));
			return sale;
		}
	}

}
