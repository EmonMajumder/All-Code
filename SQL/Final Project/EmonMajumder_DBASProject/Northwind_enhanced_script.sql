#Create database named northwind_Enhanced
create database northwind_Enhanced;

#Use database northwind_Enhanced
use northwind_Enhanced;

#create a table named "Country"
create table Country
(
  CountryID integer(10) primary key auto_increment, #Make country_ID primary key and set it to auto numbering.
  Country   varchar(50) not null unique             #Coulmn "country" can not be empty (null) And each value is uniqe.
);

create table Employee_Title_and_Fullname
(
  EmployeeID         integer(10) primary key auto_increment,  #The datatype for the data in this column is integer.
  Title_and_Fullname varchar(50) not null
);

create table Employees
(
  EmployeeID      integer(10),
  Reports_to      integer(10),
  CountryID       integer(10),
  LastName        varchar(20) not null,              #The datatype for the data in this column is varible characters.
  FirstName       varchar(20) not null,
  Title           varchar(30) not null,
  TitleofCourtesy varchar(25) not null,
  BirthDate       date        not null,                         #The datatype for the data in this column is in the format of date.
  HireDate        date        not null,
  Address         varchar(60) not null,
  City            varchar(15) not null,
  Region          varchar(15),
  PostalCode      varchar(10) not null,
  HomePhone       varchar(24) not null,
  Extension       varchar(4)  not null,
  Photo           varchar(40) not null,
  Notes           varchar(500)  not null,
  Country         varchar(50)
);


create table Shippers
(
  ShipperID   integer(10) primary key auto_increment,
  CompanyName varchar(40) not null unique ,
  Phone       varchar(24) not null unique
);

create table Orders
(
  OrderID        integer(10) primary key auto_increment ,
  CustomerID     varchar(40) not null,
  EmployeeID     integer(10) not null,
  OrderDate      datetime    not null ,
  RequiredDate   datetime    not null,
  ShippedDate    datetime ,
  ShipVia        integer(10) not null,
  Freight        double      default 0 not null,   #If no value is put in this column, 0 i the value by default
  ShipName       varchar(50)  not null,
  ShipAddress    varchar(60)  not null,
  ShipCity       varchar(15)  not null,
  ShipRegion     varchar(15),
  ShipPostalCode varchar(10) default '' not null,
  ShipCountryID  integer(10),
  Country         varchar(50)
);

create table Order_Details
(
  Order_DetailsID integer(10)         primary key auto_increment,
  OrderID         int(10)             not null,
  ProductID       int(10)             not null,
  UnitPrice       float(10) default 0 not null,
  Quantity        float(10) default 1 not null,
  Discount        float(10) default 0 not null
);

create table Products
(
  ProductID       integer(10)           primary key auto_increment,
  ProductName     varchar(40)           not null,
  SupplierID      int(10)               not null,
  CategoryID      int(10)               not null,
  QuantityPerUnit varchar(40)           not null,
  UnitPrice       float(10) default 0   not null,
  Discontinued    enum ('y', 'n') default 'n'             #The data in this column can only be y or n
);

create table Categories
(
  CategoryID   int(10) primary key auto_increment,
  CategoryName varchar(30) default '' not null unique,
  Description  varchar(255)           not null,
  Picture      varchar(50)            not null
);

create table Customers
(
  CustomerID   varchar(40) ,
  CompanyName  varchar(40) not null unique,
  ContactName  varchar(30) default 'Unknown' not null,            #If no value is inserted in this column, Unknown is put by default.
  ContactTitle varchar(30) default '' not null,
  Address      varchar(60) default '' not null,
  City         varchar(15) default '' not null,
  Region       varchar(15) default '' ,
  PostalCode   varchar(10) default '' ,
  CountryID    integer(10) ,
  Phone        varchar(24) not null unique ,
  Fax          varchar(24) ,
  Country      varchar(50)
);

create table WareHouse
(
  WareHouseID   integer(10) primary key auto_increment,
  WareHouseName varchar(50)            not null unique,
  Address       varchar(50) default '' not null
);

create table Stock
(
  StockID      integer(10) primary key auto_increment,
  ProductID    integer(10)           not null,
  WareHouseID  integer(10) ,
  UnitsInStock integer(10) default 0 not null,
  UnitsOnOrder  integer(10) default 0 not null,
  ReorderLevel integer(10) default 0 not null
);

create table Suppliers
(
  SupplierID   int(10) primary key auto_increment ,
  CompanyName  varchar(40) not null,
  ContactName  varchar(30) not null,
  ContactTitle varchar(30) not null,
  Address      varchar(60) not null,
  City         varchar(15) not null,
  Region       varchar(15) ,
  PostalCode   varchar(10) not null,
  CountryID    integer(10) ,
  Phone        varchar(24) not null unique ,
  Fax          varchar(24) ,
  HomePage     varchar(200) ,
  Country      varchar(50)
);



#Insert data inside Table Categories
insert into northwind_Enhanced.Categories (categoryname, description, picture)
select categoryname, description, picture from northwind_orig.categories;

#Create a temp table for putting sorted data in table Country later.
create table temCountry
(
  CountryID integer(10) primary key auto_increment,
  Country   varchar(50) not null unique
);
alter table Country auto_increment = 1;
insert ignore into northwind_Enhanced.temCountry (Country)
select distinct Country from northwind_orig.customers order by Country asc ;
alter table Country auto_increment = 1;
insert ignore into northwind_Enhanced.temCountry (Country)
select distinct Country from northwind_orig.employees order by Country asc ;
alter table Country auto_increment = 1;
insert ignore into northwind_Enhanced.temCountry (Country)
select distinct ShipCountry from northwind_orig.orders order by ShipCountry asc ;
alter table Country auto_increment = 1;
insert ignore into northwind_Enhanced.temCountry (Country)
select distinct Country from northwind_orig.suppliers order by Country asc ;

#Insert data inside Table Country
alter table Country auto_increment = 1;
insert ignore into northwind_Enhanced.Country (Country)
select distinct Country from temCountry order by Country asc ;
#Delete the temorary table.
drop table temCountry;

#Insert data inside Table Shippers
insert into northwind_Enhanced.Shippers (ShipperID, CompanyName,Phone)
select ShipperID,CompanyName,Phone from northwind_orig.shippers ;

#Insert data inside Table WareHouse
insert into northwind_Enhanced.WareHouse (WareHouseName, Address)
value ('The Airport warehouse ', '257 Airport Rd');
insert into northwind_Enhanced.WareHouse (WareHouseName, Address)
value ('The Central warehouse', '601 Central park');
insert into northwind_Enhanced.WareHouse (WareHouseName, Address)
value ('The Dockside warehouse', '5798 Dockside Ave');

#Insert data inside Table Suppliers.
insert into northwind_Enhanced.Suppliers (SupplierID, CompanyName, ContactName, ContactTitle, Address, City, Region, PostalCode, Phone, Fax, HomePage,Country)
select SupplierID, CompanyName,ContactName,ContactTitle,Address,City,Region,PostalCode,Phone,Fax,HomePage,Country from northwind_orig.suppliers ;

#Insert data inside Table Products.
insert into northwind_Enhanced.Products (ProductID, ProductName, SupplierID, CategoryID, QuantityPerUnit, UnitPrice, Discontinued)
select ProductID, ProductName, SupplierID,CategoryID, QuantityPerUnit, UnitPrice, Discontinued from northwind_orig.Products order by ProductName asc ;

#Insert data inside Table Order_Details.
insert into northwind_Enhanced.Order_Details (OrderID, ProductID, UnitPrice, Quantity, Discount)
select OrderID, ProductID, UnitPrice, Quantity, Discount from northwind_orig.order_details order by OrderID asc ;

#Insert data inside Table Customers.
insert  into northwind_Enhanced.Customers (CustomerID, CompanyName, ContactName, ContactTitle, Address, City, Region, PostalCode, Country, Phone, Fax)
select CustomerID, CompanyName, ContactName, ContactTitle, Address, City, Region, PostalCode, Country, Phone, Fax from northwind_orig.customers order by CompanyName asc ;

#Insert data inside Table Employees.
insert into northwind_Enhanced.Employees (EmployeeID, LastName, FirstName, Title, TitleofCourtesy, BirthDate, HireDate, Address, City, Region, PostalCode, Country, HomePhone, Extension, photo, Notes, Reports_to)
select EmployeeID, LastName, FirstName, Title, TitleofCourtesy, BirthDate, HireDate, Address, City, Region, PostalCode, Country, HomePhone, Extension, photo, Notes, ReportsTo from northwind_orig.employees order by FirstName;

#Insert data inside Table Employee_Title_and_Fullname.
insert into Employee_Title_and_Fullname (EmployeeID,Title_and_Fullname)
select EmployeeID, concat(TitleofCourtesy,' ',FirstName,' ',LastName) from Employees order by FirstName;

#Insert data inside Table orders.
insert  into northwind_Enhanced.Orders(OrderID, customerid, employeeid, orderdate, requireddate, shippeddate, shipvia, freight, shipname, shipaddress, shipcity, shipregion, shippostalcode, country)
select OrderID, customerid, employeeid, orderdate, requireddate, shippeddate, shipvia, freight, shipname, shipaddress, shipcity, shipregion, shippostalcode, shipcountry from northwind_orig.orders order by OrderID;

#Insert data inside Stock
insert into northwind_Enhanced.Stock (ProductID, UnitsInStock, UnitsOnOrder, ReorderLevel)
select ProductID,UnitsInStock, UnitsOnOrder, ReorderLevel from northwind_orig.products ;
#New table to correct CustomerID data
create table CustomerID_Data
(
  NewCustomerID integer(10) primary key auto_increment ,
  OldCustomerID varchar(10)
);

insert into CustomerID_Data (oldcustomerid)
select CustomerID from customers order by CompanyName asc;

update Customers, CustomerID_Data
set Customers.CustomerID = CustomerID_Data.NewCustomerID
where CustomerID_Data.OldCustomerID = Customers.CustomerID ;

update Customers, Country
set Customers.CountryID = Country.CountryID
where Country.Country=Customers.Country ;
alter table Customers modify CustomerID integer(10) primary key auto_increment;
alter table Customers drop Country ;

update Orders,CustomerID_Data
set Orders.CustomerID=CustomerID_Data.NewCustomerID
where Orders.CustomerID=CustomerID_Data.OldCustomerID;

update Orders,Country
set Orders.ShipCountryID=Country.CountryID
where Orders.Country=Country.Country;
alter table Orders drop Country;

update Suppliers,Country
set Suppliers.CountryID=Country.CountryID
where Suppliers.Country=Country.Country;
alter table Suppliers drop Country;

update Employees, Country
set Employees.CountryID = Country.CountryID
where Employees.Country=Country.Country ;
alter table Employees drop Country;

alter table Orders modify CustomerID integer(10) not null;
alter table Orders modify ShipCountryID integer(10) not null;

update Stock
set WareHouseID=3 where UnitsInStock<1;
update Stock
set WareHouseID=1 where UnitsInStock between 1 and 20;
update Stock
set WareHouseID=2 where UnitsInStock between 20 and 40;
update Stock
set WareHouseID=3 where UnitsInStock between 40 and 60;
update Stock
set WareHouseID=1 where UnitsInStock between 60 and 70;
update Stock
set WareHouseID=3 where UnitsInStock between 70 and 80;
update Stock
set WareHouseID=3 where UnitsInStock between 80 and 100;
update Stock
set WareHouseID=1 where UnitsInStock between 100 and 120;
update Stock
set WareHouseID=2 where UnitsInStock >120 ;

alter table Stock modify WareHouseID integer(10) not null ;
alter table Suppliers modify CountryID integer(10) not null;

drop table CustomerID_Data;

alter table Customers modify CountryID integer(10) not null ;
alter table Employees modify EmployeeID integer(10) primary key auto_increment ;
alter table Employee_Title_and_Fullname add constraint foreign key (EmployeeID) references Employees(EmployeeID);
alter table Employees add constraint foreign key (CountryID) references Country(CountryID);
alter table Employees add constraint foreign key (Reports_to) references Employees(EmployeeID);
alter table orders add constraint foreign key (CustomerID) references Customers(CustomerID);
alter table orders add constraint foreign key (EmployeeID) references employees (EmployeeID);
alter table orders add constraint foreign key (ShipVia) references shippers (ShipperID);
alter table orders add constraint foreign key (ShipCountryID) references Country(CountryID);
alter table Order_Details add constraint foreign key (ProductID) references Products(ProductID);
alter table Order_Details add constraint foreign key (OrderID) references Orders(OrderID);
alter table Products add constraint foreign key (CategoryID) references Categories(CategoryID);
alter table Products add constraint foreign key (SupplierID) references Suppliers(SupplierID);
alter table Customers add constraint foreign key (CountryID) references Country(CountryID);
alter table Stock add constraint foreign key (ProductID) references Products(ProductID);
alter table Stock add constraint foreign key (WareHouseID) references WareHouse(WareHouseID);
alter table Suppliers add constraint foreign key (CountryID) references Country(CountryID);

