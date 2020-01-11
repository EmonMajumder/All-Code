#Emon Majumder (W0411567)- Assignment:1- Part:2

create database Products_DDL;
use Products_DDL;

create table Product
(
  ProductID integer auto_increment primary key , #This is primary for the table. Database automatically assign integer values starting from 1.
  ProductCode char(8) not null unique ,          #2 input for this column ca not be similar. Input is mandatory for this column.
  ProductName varchar(50) not null ,             #Input is mandatory for this column.
  Description varchar(100) ,
  RetailPrice double not null check (RetailPrice>0), #Will check data entered if value is more than 0.
  SalesPrice double check (SalesPrice>0) ,        #Will check data entered if value is more than 0.
  ProductRating float not null check (ProductRating>=1 and ProductRating<=5), #Will check data entered if value is within 0 to 5 (0 and 5 included).
  NumberInStock integer not null default 0 ,      #default value is 0 which means if no value is entered 0 will be assigned automatically.
  IsActive bit not null default 1 ,               #if no input is done to the column it assign 1 automatically as default.(Yes=1 and No=0)
  IsDiscontinued bit not null default 1           #if no input is done to the column it assign 1 automatically as default.(Yes=1 and No=0)
);

create table Supplier
(
  SupplierID integer auto_increment primary key ,
  SupplierName varchar(100) not null ,
  Address varchar(255) not null ,
  ContactName varchar(100) ,
  ContactPhone varchar(20) ,
  ContactEmail varchar(50) ,
  IsActive bit not null default 1
);

create table ClothingCategory
(
  CategoryID integer auto_increment primary key ,
  CategoryName varchar(50) not null ,
  IsActive bit not null default 1
);

create table ClothingSize
(
  SizeID integer auto_increment primary key ,
  SizeName varchar(50) not null ,
  SizeAbbreviation enum('XS','S','M','L','XL','XXL') not null , #input should always be one of the 6 options availabe. options are 'XS','S','M','L','XL','XXL'.
  IsActive bit not null default 1
);

create table Colour
(
  ColourID integer auto_increment primary key ,
  ColourName varchar(50) not null ,
  ColourCode char(3) not null unique ,
  IsActive bit not null default 1
);