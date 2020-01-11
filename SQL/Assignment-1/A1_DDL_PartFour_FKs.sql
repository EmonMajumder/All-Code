#Emon Majumder (W0411567)- Assignment:1- Part:4

#This scripts only work if script part-1 and part-3 or part-2 has been run. All tables with constraint must be prepared prior.
#This script will create relations between entities.

use Products_DDL;

alter table Product add column SupplierID integer ;   #Add a new column 'SupplierID' to the table 'Product' with datatyoe integer.
alter table Product add foreign key (SupplierID) references supplier (SupplierID) ;   #Mark SupplierID as forign key that relates to primary key SupplierID in table Supplier. This establish a one to many relation supplier to product.

create table ProductCategory        #this is a intermediate table to establish relation between table Product and ClothingCategory.
(
  ProductID integer not null ,
  CategoryID integer not null ,
  constraint primary key (ProductID,CategoryID) ,   #make both ProductID and CategoryID together a primary key.
  constraint foreign key (ProductID) references Product (ProductID) ,     #one to many relation is established Product to ProductCategory. Forighn key ProductID refer to primary key ProductID inside table Product.
  constraint foreign key (CategoryID) references ClothingCategory (CategoryID)    #establish one to many relation ClothingCategory to ProductCategory by linking CategoryID inside ProductCategory to primary key CategoryID inside ClothingCategory
);

create table ProductSize
(
  ProductID integer not null ,
  SizeID integer not null ,
  constraint primary key (ProductID,SizeID) ,
  constraint foreign key (ProductID) references Product (ProductID) ,   #Product to ProductSize> one to many.
  constraint foreign key (SizeID) references ClothingSize (SizeID)      #ClothingSize to ProductSize> one to many.
);

create table ProductColour
(
  ProductID integer not null ,
  ColourID integer not null ,
  constraint primary key (ProductID,ColourID) ,
  constraint foreign key (ProductID) references Product (ProductID) ,   #Product to ProductColour> one to many.
  constraint foreign key (ColourID) references Colour (ColourID)        #Colur to ProductColour> one to many.
);


