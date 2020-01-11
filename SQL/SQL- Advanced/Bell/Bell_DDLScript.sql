DROP TABLE BELL_CABLECUSTOMERS;
DROP TABLE BELL_MOBILITYCUSTOMERS;
DROP TABLE BELL_EMPLOYEES;

CREATE TABLE BELL_CABLECUSTOMERS (
  CustomerID int PRIMARY KEY,
  CustomerName varchar(50),
  EmailAddress varchar(50)  
);

CREATE TABLE BELL_MOBILITYCUSTOMERS (
  CustID int PRIMARY KEY,
  CustName varchar(50),
  Email varchar(50)  
);

CREATE TABLE BELL_EMPLOYEES (
  EmployeeID int PRIMARY KEY,
  EmpName varchar(50),
  EmpEmail varchar(50)  
);

INSERT INTO BELL_CABLECUSTOMERS VALUES (1, 'Joe Cable', 'joe_cable@gmail.com');
INSERT INTO BELL_CABLECUSTOMERS VALUES (2, 'Joe Both', 'joe_both@gmail.com');
INSERT INTO BELL_CABLECUSTOMERS VALUES (3, 'Jane Cable', 'jane_cable@gmail.com');
INSERT INTO BELL_CABLECUSTOMERS VALUES (4, 'Joe Employee', 'joe_employee@BELL.com');

INSERT INTO BELL_MOBILITYCUSTOMERS VALUES (1, 'Joe Mobile', 'joe_mobile@gmail.com');
INSERT INTO BELL_MOBILITYCUSTOMERS VALUES (2, 'Joe Both', 'joe_both@gmail.com');
INSERT INTO BELL_MOBILITYCUSTOMERS VALUES (3, 'Jane Mobile', 'jane_mobile@gmail.com');
INSERT INTO BELL_MOBILITYCUSTOMERS VALUES (4, 'Joe Employee', 'joe_employee@BELL.com');

INSERT INTO BELL_EMPLOYEES VALUES (1, 'Joe President', 'Prez@BELL.com');
INSERT INTO BELL_EMPLOYEES VALUES (2, 'Joe Manager', 'Joe_manager@BELL.com');
INSERT INTO BELL_EMPLOYEES VALUES (3, 'Joe Employee', 'joe_employee@BELL.com');