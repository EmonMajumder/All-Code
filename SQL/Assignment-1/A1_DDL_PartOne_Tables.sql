#Emon Majumder (W0411567)- Assignment:1- Part:1

create database Products_DDL;   #create a database by the name "Products_DDL"
use Products_DDL;               #Initialize the database "Products_DDL" for further use.

create table Product            #create a table by the name "Product" inside database "Products_DDL"
(
  ProductID integer ,
  ProductCode char(8) ,         #All values should be of 8 character length.
  ProductName varchar(50) ,     #data can be of different character and different length. Up to 50 character accepted.
  Description varchar(100) ,
  RetailPrice double ,          #for currency "double" datatype to consider values with fraction.
  SalesPrice double ,           #for currency "double" datatype to consider values with fraction.
  ProductRating integer ,       #Considering only full numbers as rating. No point something acceptable.
  NumberInStock integer ,       #Stock number can not be fractional.
  IsActive bit ,                #kind of yes no (yes=1 or No=0) data
  IsDiscontinued bit            #kind of yes no (yes=1 or No=0) data
);

create table Supplier
(
  SupplierID integer ,
  SupplierName varchar(100) ,
  Address varchar(255) ,
  ContactName varchar(100) ,
  ContactPhone varchar(20) ,
  ContactEmail varchar(50) ,
  IsActive bit
);

create table ClothingCategory
(
  CategoryID integer ,
  CategoryName varchar(50) ,
  IsActive bit
);

create table ClothingSize
(
  SizeID integer ,
  SizeName varchar(50) ,
  SizeAbbreviation varchar(3) ,
  IsActive bit
);

create table Colour
(
  ColourID integer ,
  ColourName varchar(50) ,
  ColourCode char(3) ,
  IsActive bit
);