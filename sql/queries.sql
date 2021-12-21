use cardealership;

-- home/index
select * 
from vehicle
where featured = true;

-- inventory/new
-- REPLACE: '_' with ?
select *
from vehicle
where ( (make LIKE '%%') or (model LIKE '%%') or (`year` LIKE '%%') ) and type = 1
limit 20;

-- Helper in case of no filte - return vehicles with highest MSRP
select *
from vehicle
order by MSRP DESC
limit 20;

-- invetory/used
select *
from vehicle
where ( (make LIKE '%_%') or (model LIKE '%_%') or (`year` LIKE '%_%') ) and type = 2
limit 20;

-- inventory/details/id
-- REPLACE: vin string with ?
select *
from vehicle
where vin = '1GNSKKE77DR377809';

-- NOT USED
-- Home/contact
-- REPLACE: all fields with ?
-- Validation: email address should be proper email format
-- Validation: email and address shouldnt be both null, needs to be validated in code
-- insert into contact (firstname, lastname, emailaddress, address, zipcode, message)
-- values ('Giovanna', 'Ribeiro', null, '123 Random Street', '15242');

-- Sales/index
select *
from vehicle
where ( (make LIKE '%_%') or (model LIKE '%_%') or (`year` LIKE '%_%') ) and available = true
limit 20;

-- sales/purchase/id
-- contact to be created before ex. contactid = 1
-- REPLACE: all values()
-- VALIDATE: purchasePrice < MSRP (in vehicle table)
-- SIDE EFFECTS: Makes vehicle sold unavailable 
-- Clarification: ContactID is the buyer, userID is the seller

insert into sale (vehicleid, emailaddress, address, zipcode, saleprice, purchasetype, userID)
values ('KMHEC4A48DA099278', null, '123 Random Street', '15242', 387860.00, 1, 1);

-- Update vehicle to be unavailable (when sale inserted)
update vehicle
set available = false
where vin = '1GNSKKE77DR377809';

-- Admin/AddVehicle
-- VALIDATION: Year must be a 4 digit year between 2000 and the current year + 1 	
-- VAlIDATION: If the type is new, mileage should be between 0 and 1000. Used vehicles must be 1000+.
Insert into vehicle (vin, make, model, `year`, transmission, color, interiorColor, `type`, mileage, bodystyle, msrp, imageurl, featured, available, `description`)
values ('1GNSKKE77DR377809', 'CHRYSLER', 'SEBRING', '2010', 2, 2, 3, 1, 152, 2, 21000.00, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.kbb.com%2Fchrysler%2Fsebring%2F&psig=AOvVaw1SJXa26Pawuy3P8kPgkBAL&ust=1638981692405000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCPCjwd6Q0vQCFQAAAAAdAAAAABAD', 0, 1, "nice car");

-- Admin/editvehicle
Update vehicle set 
make = ?, model = ?, `year` = ?, transmission = ?,
color = ?, interiorcolor = ?, `type` = ?, mileage = ?,
bodystyle = ?, msrp = ?, imageurl = ?, featured = ?,
available = ?, `description` = ?
where vin = ?;

-- Admin/users
select *
from user;

-- admin/adduser
Insert into `user` (firstname, lastname, `role`)
values ('Anna', 'Khan', 1);

-- admin/EditUser
update `user` set
firstname = ?,
lastname = ?,
`role` = ?
where userId = ?;

-- reports/index
select *
from sale;

-- report/sales
select SUM(salePrice) as totalSalesPrice, COUNT(vehicleID) as VehiclesSold
from sale;

-- reports/inventory
select make, `year`, model, SUM(MSRP) as stockValue
from vehicle
group by make, `year`, model