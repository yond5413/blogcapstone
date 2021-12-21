/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.cardealership.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *
 * @author yond1
 */
public class Sale {
    /*create table sale(
	saleID int primary key,
    EmailAddress varchar(256),
    Address varchar(256),
    ZipCode varchar(5),
    vehicleID varChar(17),
    salePrice decimal,
    purchaseType int,
    available boolean,
    `date` DateTime DEFAULT CURRENT_TIMESTAMP,
    userID int,
    foreign key fk_sale_VehicleID (vehicleID)
		references Vehicle (VIN),
	foreign key fk_sale_userID (userID)
		references `user` (userID),
	foreign key fk_sale_purchaseType (purchaseType)
		references purchaseType (purchaseTypeID)
);*/
    private int saleId;
    private String emailAddress;
    private String address;
    private String zipCode;
    private String vehicleId;
    private BigDecimal salePrice;
    private int purchaseType;
    private LocalDateTime date;
    private int userId;

    public Sale() {
    }

    public Sale(int saleId, String emailAddress, String address, String zipCode, String vehicleId, BigDecimal salePrice, int purchaseType, boolean available, LocalDateTime date, int userId) {
        this.saleId = saleId;
        this.emailAddress = emailAddress;
        this.address = address;
        this.zipCode = zipCode;
        this.vehicleId = vehicleId;
        this.salePrice = salePrice;
        this.purchaseType = purchaseType;
        this.date = date;
        this.userId = userId;
    }

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public int getPurchaseType() {
        return purchaseType;
    }

    public void setPurchaseType(int purchaseType) {
        this.purchaseType = purchaseType;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    
}
