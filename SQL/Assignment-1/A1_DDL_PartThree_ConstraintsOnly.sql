#Emon Majumder (W0411567)- Assignment:1- Part:3

#This script can only be run once Part-1 script has already been run or all necessary table has
#already been created without any constraint.
use Products_DDL;            #Prepare database "Products_DDL" for further modification.

alter table product add primary key (ProductID);          #make ProductID primary key.
alter table product change ProductID ProductID integer auto_increment;    #add constraint auto increment to primary key ProductID. Auto increment can only be assign to one column of a table and that must be primary key.
alter table product modify ProductCode char(8) not null unique ;    #all input values should be of 8 character length. add a constraint so that no two values entered in this column are similar.
alter table product modify ProductName varchar(50) not null ;       #data must be input for a column with not null constraint. add not null constraint.
alter table product modify RetailPrice double not null check(RetailPrice>0) ;  #add constraint check to check value range. in this case if value greater than 0.
alter table product modify SalesPrice double check (SalesPrice>0) ;
alter table product modify ProductRating float not null check (ProductRating>=1 and ProductRating<=5) ;  #add constraint check if data entered is within upper and lower limit of data.
alter table product modify NumberInStock integer not null default 0 ;       #Set default value 0.
alter table product modify IsActive bit not null default 1 ;          #set default value 1.
alter table product modify IsDiscontinued bit not null default 1 ;    #set default value 1.

alter table Supplier add primary key (SupplierID) ;
alter table Supplier change SupplierID SupplierID integer auto_increment ;
alter table Supplier modify SupplierName varchar(100) not null ;
alter table Supplier modify Address varchar(255) not null ;
alter table Supplier modify IsActive bit not null default 1 ;

alter table ClothingCategory add primary key (CategoryID) ;
alter table ClothingCategory change CategoryID CategoryID integer auto_increment ;
alter table ClothingCategory modify CategoryName varchar(50) not null ;
alter table ClothingCategory modify IsActive bit not null default 1 ;

alter table ClothingSize add primary key (SizeID) ;
alter table ClothingSize change SizeID SizeID integer auto_increment ;
alter table ClothingSize modify SizeAbbreviation enum('XS','S','M','L','XL','XXL') not null ;   #add constraint to force user to choose one of the 6 option as input. options are 'XS','S','M','L','XL','XXL'.
alter table ClothingSize modify SizeName varchar(50) not null ;
alter table ClothingSize modify IsActive bit not null default 1 ;

alter table Colour add primary key (ColourID) ;
alter table Colour change ColourID ColourID integer auto_increment ;
alter table Colour modify ColourName varchar(50) not null ;
alter table Colour modify ColourCode char(3) not null unique ;
alter table Colour modify IsActive bit not null default 1 ;