create database TC3_EmpProject;
use TC3_EmpProject;

create table Employee
(
  Employee_ID integer auto_increment primary key ,
  First_Name varchar(50) not null ,
  Last_Name varchar(50) not null ,
  Email_Address varchar(100) not null unique ,
  Hire_Date datetime
);

create table Project_Category
(
  Category_ID integer auto_increment primary key ,
  Category_Name varchar(50) not null
);

create  table Project
(
  Project_ID integer auto_increment primary key ,
  Project_Name varchar(50) not null unique ,
  Start_Date datetime not null ,
  End_Date datetime not null ,
  Budget float not null ,
  Category_ID integer ,
  constraint foreign key (Category_ID) references Project_Category(Category_ID) ,
  constraint check (Budget>=0 and Budget<99999.99)
);

create  table Employee_Project
(
  Employee_Project_ID integer auto_increment primary key ,
  Project_ID integer ,
  Employee_ID integer ,
  Project_Lead bit not null ,
  constraint foreign key (Employee_ID) references Employee(Employee_ID) ,
  constraint foreign key (Project_ID) references Project(Project_ID)
);



