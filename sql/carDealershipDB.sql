drop database if exists cardealership;

create database cardealership;
use cardealership;

create table Color(
	ColorID int primary key,
    ColorName varChar(15)
);

create table vehicleType(
	vehicleTypeID int primary key,
    `type` varChar(30)
);

create table `user`(
	userID int primary key auto_increment,
	FirstName varchar(50),
    LastName varchar(50),
    `Role` int
);

create table bodyStyle(
	bodyStyleID int primary key,
    bodyStyle varChar(30)
);

create table transmission(
	transmissionid int primary key,
    transmission varChar(30)
    );

create table Vehicle (
	VIN varchar(17) primary key,
    Make varchar(50),
    Model varChar(100),
    `Year` char(4),
    Transmission boolean,
    Color int,
    InteriorColor int,
    `type` int,
    mileage int,
    bodyStyle int,
    MSRP decimal(10,2),
    ImageURL varchar(1024),
    Featured boolean,
    available boolean,
    `description` varchar(1024),
    foreign key fk_vehicle_color (color)
		references color (colorID),
	foreign key fk_vehicle_InteriorColor (interiorcolor)
		references color (colorID),
	foreign key fk_vehicle_type (`type`)
		references vehicleType (vehicleTypeID),
	foreign key fk_vehicle_bodystyle (bodyStyle)
		references bodyStyle (bodyStyleID)
);


create table userRole(
	userRoleID int primary key,
    userRole varchar(10)
);

create table purchaseType(
	purchaseTypeID int primary key,
    `type` varChar(30)
);

-- create table contact(
-- 	contactID int primary key auto_increment,
--     FirstName varchar(50),
--     LastName varchar(50),
-- 	EmailAddress varchar(256),
--     Address varchar(256),
--     ZipCode varchar(5),
--     message varchar(1000)
-- );


create table sale(
	saleID int primary key auto_increment,
    vehicleID varChar(17),
    EmailAddress varchar(256),
    Address varchar(256),
    ZipCode varchar(5),
	-- contactID int,
		
    salePrice decimal(10,2),
    purchaseType int,
    
    `date` DateTime DEFAULT CURRENT_TIMESTAMP,
    userID int,
--     foreign key fk_sale_contactID (contactID)
-- 		references contact (contactID),
    foreign key fk_sale_VehicleID (vehicleID)
		references Vehicle (VIN),
	foreign key fk_sale_userID (userID)
		references `user` (userID),
	foreign key fk_sale_purchaseType (purchaseType)
		references purchaseType (purchaseTypeID)
);

insert into transmission(transmissionid, transmission)
values (1, 'Automatic');

insert into transmission(transmissionid, transmission)
values (2, 'Manual');

insert into vehicletype(vehicletypeID, `type`)
values (1, 'New');

insert into vehicletype(vehicletypeID, `type`)
values (2, 'Used');

insert into color (colorID, ColorName)
values (1, "White");

insert into color (colorID, ColorName)
values (2, "Black");

insert into color (colorID, ColorName)
values (3, "Red");

insert into color (colorID, ColorName)
values (4, "Grey");

insert into color (colorID, ColorName)
values (5, "Blue");

insert into userRole (userRoleId, userRole)
values (1, "Disabled");

insert into userRole (userRoleId, userRole)
values (2, "Sales");

insert into userRole (userRoleId, userRole)
values (3, "Admin");

insert into purchaseType (purchaseTypeId, `type`)
values (1, "Bank Financing");

insert into purchaseType (purchaseTypeId, `type`)
values (2, "Cash");

insert into purchaseType (purchaseTypeId, `type`)
values (3, "Dealer Financing");

insert into bodystyle(bodystyleid, bodystyle)
values (1, 'Car');

insert into bodystyle(bodystyleid, bodystyle)
values (2, 'SUV');

insert into bodystyle(bodystyleid, bodystyle)
values (3, 'Truck');

insert into bodystyle(bodystyleid, bodystyle)
values (4, 'Van');
