/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.cardealership.entity;

import java.math.BigDecimal;

/**
 *
 * @author yond1
 */
public class Vehicle {
    /*
    create table Vehicle (
	VIN varchar(17) primary key,
    Make int,
    Model varChar(30),
    `Year` char(4),
    Transmission boolean,
    Color int,
    InteriorColor int,
    `type` int,
    MSRP decimal,
    ImageURL varchar(1024),
    Featured boolean,
    foreign key fk_vehicle_color (color)
		references color (colorID),
	foreign key fk_vehicle_InteriorColor (interiorcolor)
		references color (colorID),
	foreign key fk_vehicle_type (`type`)
		references vehicleType (vehicleTypeID)
    );
    */
    private String VIN;
    private String make;
    private String model;
    private String year;
    private boolean transmission;
    private int color;
    private int interiorColor;
    private int type;
    private BigDecimal MSRP;
    private String imageURL;
    private boolean featured;
    private boolean available;

    public Vehicle() {
    }

    public Vehicle(String vIN, String make, String model, String year, boolean transmission, int color, int interiorColor,
			int type, BigDecimal mSRP, String imageURL, boolean featured, boolean available) {
		super();
		VIN = vIN;
		this.make = make;
		this.model = model;
		this.year = year;
		this.transmission = transmission;
		this.color = color;
		this.interiorColor = interiorColor;
		this.type = type;
		MSRP = mSRP;
		this.imageURL = imageURL;
		this.featured = featured;
		this.available = available;
	}

	public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public boolean isTransmission() {
        return transmission;
    }

    public void setTransmission(boolean transmission) {
        this.transmission = transmission;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getInteriorColor() {
        return interiorColor;
    }

    public void setInteriorColor(int interiorColor) {
        this.interiorColor = interiorColor;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public BigDecimal getMSRP() {
        return MSRP;
    }

    public void setMSRP(BigDecimal MSRP) {
        this.MSRP = MSRP;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
           
}
