create database mechanicShop;

use mechanicShop;

create table CUSTOMER (
customerID	INT AUTO_INCREMENT,
fName	VARCHAR(20),
Initial	CHAR(1),
lName	VARCHAR(20),
dateCreated	DATETIME default CURRENT_TIMESTAMP,
dateUpdated	DATETIME default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
primary key (customerID)
);

insert into CUSTOMER (fName, Initial, lName)
values
('Eric', 'J', 'Paulsen'),
('Eve', 'B', 'Anderson'),
('Richard', 'M', 'Nixon'),
('Maria', 'G', 'West'),
('Henry', 'H', 'Harrison'),
('Hugh', 'F', 'Morris'),
('Henry', 'M', 'Feinstein'),
('Patrick', 'M', 'OMalley'),
('Kristina', 'K', 'Nguyen'),
('Aaron', 'C', 'Finkler');

create table ADDRESS (
addressCode	INT AUTO_INCREMENT,
customerID	INT,
addressType	VARCHAR(15),
stNo		INT,
stName		VARCHAR(30),
aptNo		INT,
buildingName	VARCHAR(30),
city		VARCHAR(20),
state		CHAR(2),
zip		INT,
dateCreated	DATETIME default CURRENT_TIMESTAMP,
dateUpdated	DATETIME default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
primary key (addressCode),
foreign key (customerID) references CUSTOMER(customerID)
);

insert into ADDRESS (customerID, addressType, stNo, stName, aptNo, buildingName, city, state, zip)
values
(1, 'home', 5456, '215th St W', NULL, NULL, 'Jordan', 'MN', 55352),
(2, 'home', '213', 'Main St', 404, NULL, 'Jordan', 'MN', 55352),
(3, 'business', 12543, 'Highway 7', NULL, NULL, 'Minnetonka', 'MN', 55345),
(3, 'home', 57689, 'West Palm Dr', NULL, NULL, 'Malibu', 'CA', 61242),
(4, 'home', 452, '31st st E', 502, 'Carlson', 'Minneapolis', 'MN', 55406),
(5, 'business', 554, 'West River Rd', NULL, 'Main Office', 'Minneapolis', 'MN', 55421),
(6, 'home', 1337, 'University Ave', 314, 'Albert Hall', 'Minneapolis', 'MN', 55404),
(7, 'home', 1214, 'Riverside Ave', 213, 'Lakewinds Apts', 'Hudson', 'WI', 54323),
(8, 'business', 801, 'France Ave', NULL, 'Service Center', 'Edina', 'MN', 55436),
(9, 'home', 2015, 'Texas Ave', NULL, NULL, 'St. Louis Park', 'MN', 55418),
(10, 'home', 3312, 'Utica Ave', NULL, NULL, 'Bloomington', 'MN', 55435);

create table PHONE (
areaCode	INT,
phoneNo		INT,
customerID	INT,
type		VARCHAR(15),
dateCreated	DATETIME default CURRENT_TIMESTAMP,
dateUpdated	DATETIME default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
primary key (areaCode, phoneNo),
foreign key (customerID) references CUSTOMER(customerID)
);

insert into PHONE (areaCode, phoneNo, customerID, type)
values
(763, 8026344, 1, 'home'),
(763, 7661232, 2, 'cell'),
(952, 7679323, 3, 'business'),
(311, 1234887, 3, 'cell'),
(612, 3348787, 4, 'cell'),
(612, 6651200, 5, 'business'),
(651, 9894432, 6, 'cell'),
(608, 6341557, 7, 'cell'),
(952, 7836708, 8, 'business'),
(612, 6134430, 9, 'home'),
(952, 8763488, 10, 'home'),
(651, 8521616, 10, 'cell');

create table MODEL (
modelNo		INT AUTO_INCREMENT, 
make		VARCHAR(30),
model		VARCHAR(20),
year		INT,
type		VARCHAR(15),
dateCreated	DATETIME default CURRENT_TIMESTAMP,
dateUpdated	DATETIME default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
primary key (modelNo)
);

insert into MODEL (make, model, year, type)
values
('Ford', 'F150', 2001, 'Truck'),
('Ford', 'F150', 2005, 'Truck'),
('Ford', 'F250', 2008, 'Truck'),
('Ford', 'Transit 350', 2016, 'Van'),
('Dodge', 'Ram', 2010, 'Truck'),
('Toyota', 'Tacoma', 2013, 'Truck'),
('Toyota', 'Highlander', 2009, 'SUV'),
('Toyota', 'Camry', 2014, 'Sedan'),
('Toyota', 'Corolla', 2009, 'Economy'),
('Toyota', 'Corolla', 2010, 'Economy'),
('Honda', 'CRV', 2011, 'SUV'),
('Honda', 'Accord', 2002, 'Economy');

create table VEHICLE (
VIN		VARCHAR(20),
customerID	INT,
modelNo		INT,
mileage		INT,
plateNo		VARCHAR(7),
plateState	CHAR(2),
dateCreated	DATETIME default CURRENT_TIMESTAMP,
dateUpdated	DATETIME default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
primary key (VIN),
foreign key (customerID) references CUSTOMER(customerID),
foreign key (modelNo) references MODEL(modelNo)
);

insert into VEHICLE (VIN, customerID, ModelNo, mileage, plateNo, plateState)
values
('tc09e1', 1, 9, 212233, '245ZDH', 'MN'),
('hc11s1', 1, 11, '34876', 'HJS678', 'MN'),
('tc14s1', 2, 8, 54554, 'RTX214', 'MN'),
('ff01t1', 5, 1, 225462, '632BBU', 'MN'),
('ff05t1', 5, 2, 156234, '234WET', 'MN'),
('ff05t2', 5, 2, 170870, 'AKX223', 'MN'),
('ff08t1', 5, 3, 130987, 'VVU447', 'MN'),
('ha02e1', 4, 12, 178034, '787RWA', 'MN'),
('ft16v1', 3, 4, 90234, '345QWA', 'MN'),
('ft16v2', 3, 4, 45923, 'RVA556', 'MN'),
('dr10t1', 6, 5, 23340, 'TRUKGUY', 'MN'),
('hc11s2', 7, 11, 215578, 'ASD809', 'WI'),
('ft16v3', 8, 4, 10234, '334EZD', 'MN'),
('ft16v4', 8, 4, 9807, '998BGB', 'MN'),
('tt13t1', 9, 6, 145098, 'SDE545', 'MN'),
('th09s1', 9, 7, 198234, '626STH', 'MN'),
('tc10e1', 10, 10, 279123, '2FAST4U', 'MN');

create table PART (
partNo		INT AUTO_INCREMENT,
partType	VARCHAR(40),	
partDesc	VARCHAR(50),
manufacturer	VARCHAR(30),
price		NUMERIC(8,2),
noInStock	INT,
dateCreated	DATETIME default CURRENT_TIMESTAMP,
dateUpdated	DATETIME default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
primary key (partNo)
);

insert into PART(partDesc, partType, manufacturer, price, noInStock)
values
('OReilly Oil 10W-30', 'Oil', 'OReilly', 4.29, 25),
('GTX 10-30', 'Oil', 'Castrol', 6.29, 17),
('10W-30', 'Pennzoil', 'Oil', 6.29, 12),
('Advanced Durability 10W-30', 'Oil', 'Quaker State', 5.49, 5),
('Automatic Transmisson Fluid', 'Transmission Fluid', 'Valvoline', 6.29, 10),
('Manual Transmission Fluid', 'Transmission Fluid', 'Valvoline', 9.49, 7),
('Manual Transmission Fluid', 'Transmission Fluid', 'Pennzoil', 8.29, 8),
('Synthetic DOT 3 Brake Fluid', 'Brake Fluid', 'OReilly Chemicals', 19.99, 4), 
('Synthetic DOT 3 Brake Fluid', 'Brake Fluid', 'Prestone', 22.99, 4),
('Radiator Flush and Cleaner', 'Radiator Flush', 'Prestone', 5.49, 10),
('Radiator Flush', 'Radiator Flush', 'Blue Devil', 7.49, 2),
('All Terrain', 'Tire', 'Goodyear', 100.99, 12),
('Snow Tire', 'Tire', 'Goodyear', 120.59, 16),
('Sport Package', 'Suspension', 'Ford', 1120.99, 2),
('Commercial Package', 'Suspension', 'Ford', 950.44, 4),
('Select', 'Brake Pads', 'BrakeBest', 33.99, 24),
('Thermoquiet', 'BrakePads', 'Wagner', 55.99, 12),
('Holeshot', 'Wheel', 'KMC', 160.00, 4),
('Endurno', 'Wheel', 'KMC', 180.00, 8),
('Plain - Steel', 'Wheel', 'Ford', 120.00, 12);

insert into PART(partDesc, partType, manufacturer, price, noInStock)
values
('Ceramic Select', 'Brake Pads', 'BrakeBest', 35.99, 15),
('Organic', 'Brake Pads', 'BrakeBest', 24.99, 12),
('All Season', 'Tire', 'BFGoodrich', 88.48, 20),
('Ecopia', 'Tire', 'BridgeStone', 84.25, 8),
('Maverick', 'Wheel', 'American Racing', 166.00, 4),
('ST1', 'Wheel', 'Sport Tuning', 104.00, 16),
('Standard', 'Suspension', 'Toyota', 800.65, 4),
('Sport', 'Suspension', 'Toyota', 995.00, 4);

insert into PART(partDesc, partType, manufacturer, price, noInStock)
values
('Select', 'Brake Pads', 'BrakeBest', 46.99, 2),
('Standard', 'Suspension', 'Honda', 750.00, 5);

insert into PART(partDesc, partType, manufacturer, price, noInStock)
values
('Long Trail T/A Tour', 'Tire', 'BFGoodrich', 129.45, 16),
('Maverick', 'Wheel', 'American Racing', 190.00, 12),
('Heavy Duty', 'Suspension', 'Toyota', 1199.49, 5),
('Off Road', 'Suspension', 'Honda', 1050.58, 8);

insert into PART(partDesc, partType, manufacturer, price, noInStock)
values
('None', NULL, NULL, NULL, NULL);

create table SERVICE (
serviceCode	INT AUTO_INCREMENT,
servDesc	VARCHAR(50),
hoursEstimated	DOUBLE,
serviceFee	NUMERIC(6,2),
dateCreated	DATETIME default CURRENT_TIMESTAMP,
dateUpdated	DATETIME default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
primary key (serviceCode)
);

insert into SERVICE (servDesc, hoursEstimated, serviceFee)
values
('oil change', .5, 5.99),
('routine checkup', .5, 10),
('change transmission fluid', .5, 15.99),
('flush brake lines', 1, 5.39),
('radiator flush', .5, 20.49),
('change brake pads', 1.5, 0),
('rotate tires', 1, 10.48),
('change tire', 1, 0),
('change wheel', 1, 0),
('replace suspension', 4, 0);

create table COMPATIBLE (
serviceCode	INT,
modelNo		INT,
partNo		INT,
primary key (serviceCode, modelNo, partNo),
foreign key (serviceCode) references SERVICE(serviceCode),
foreign key (modelNo) references MODEL(modelNo),
foreign key (partNo) references PART(partNo)
);

insert into COMPATIBLE (serviceCode, modelNo, partNo)
values
(6, 1, 16), (6, 1, 17), (8, 1, 12), (8, 1, 13), (10, 1, 15), (9, 1,  18),
(6, 2, 16), (6, 2, 17), (8, 2, 12), (8, 2, 13), (10, 2, 14), (10, 2, 15), (9, 2, 18), (9, 2, 19), (9, 2, 20),
(6, 3, 16), (6, 3, 17), (8, 3, 12), (8, 3, 13), (10, 3, 14), (10, 3, 15), (9, 3, 18), (9, 3, 19), (9, 3, 20),
(6, 4, 16), (6, 4, 17), (8, 4, 12), (8, 4, 13), (10, 4, 15), (9, 4, 19), (9, 4, 20);

insert into COMPATIBLE (serviceCode, modelNo, partNo)
values
(6, 8, 21), (6, 8, 22), (8, 8, 23), (8, 8, 24), (9, 8, 25), (9, 8, 26), (10, 8, 28),
(6, 9, 21), (8, 9, 24), (9, 9, 25), (10, 9, 27), (10 , 9, 28),
(6, 10, 21), (8, 10, 24), (9, 10, 25), (10, 10, 27);

insert into COMPATIBLE (serviceCode, modelNo, partNo)
values
(6, 12, 29), (8, 12, 22), (8, 12, 23), (9, 12, 25), (9, 12, 26), (10, 12, 30);

insert into COMPATIBLE (serviceCode, modelNo, partNo)
values
(6, 6, 16), (6, 6, 17), (8, 6, 31), (9, 6, 32), (10, 6, 33), 
(6, 7, 16), (6, 7, 17), (8, 7, 31), (9, 7, 32), (10, 7, 33),
(6, 11, 16), (6, 11, 17), (8, 11, 31), (9, 11, 32), (10, 11, 34);

create table APPOINTMENT (
apptNo		INT AUTO_INCREMENT,
customerID	INT,
VIN		VARCHAR(20),
date		DATE,
time		TIME,
shopNo		INT,
hoursBilled	INT,
dateCreated	DATETIME default CURRENT_TIMESTAMP,
dateUpdated	DATETIME default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
primary key (apptNo),
foreign key (customerID) references CUSTOMER(customerID),
foreign key (VIN) references VEHICLE(VIN)
);

insert into APPOINTMENT (customerID, VIN, date, time, shopNo, hoursbilled)
values
(1, 'tc09e1', '2017/03/30', '12:30', 1, 0),
(2, 'tc14s1', '2017/03/30', '12:30', 2, 0),
(3, 'ft16v2', '2017/03/14', '09:15', 2, 1),
(3, 'ft16v1', '2017/04/01', '10:00', 1, 0),
(4, 'ha02e1', '2017/04/10', '03:00', 2, 0),
(5, 'ff05t2', '2017/04/10', '09:30', 1, 0),
(6, 'ff05t2', '2017/03/25', '01:30', 1, 2),
(7, 'hc11s2', '2017/04/10', '11:30', 2, 0),
(8, 'ft16v3', '2017/03/26', '12:00', 2, 5),
(9, 'tt13t1', '2017/04/01', '10:30', 2, 0);

create table TASKS (
apptNo		INT AUTO_INCREMENT,
serviceCode	INT,
partNo		INT,
partQnt		INT,
primary key (apptNo, serviceCode, partNo),
foreign key (apptNo) references APPOINTMENT(apptNo),
foreign key (serviceCode) references SERVICE(serviceCode),
foreign key (partNo) references PART(partNo)
);

insert into TASKS (apptNo, serviceCode, partNo, partQnt)
values
(1, 1, 2, 1),
(1, 2, 35, 0),
(2, 6, 22, 4),
(3, 10, 15, 4),
(4, 9, 20, 4),
(4, 1, 2, 1),
(5, 5, 10, 1),
(6, 3, 6, 1),
(7, 4, 9, 4),
(8, 7, 35, 0),
(9, 8, 12, 2);
