create database Exercise6;

use Exercise6;

begin tran;
create table Employee (
EmployeeID int not null identity(1,1) Primary key,
FirstName varchar(50) not null,
LastName varchar(50)
);
commit;

begin tran;
create table PhoneNumber (
PhoneID int not null identity(1,1) Primary key,
PhoneNumber varchar(15) not null,
Phonetype varchar(50),
EmployeeID int foreign key references Employee(EmployeeID)
);
commit;

begin tran;
insert into Employee (FirstName,LastName) 
values  ('Mahmud','Hasan'),
		('Mahmudul','Haque'),
		('Jahid','Kawsar'),
		('Al-amin','Hossen'),
		('Mursalin','Ahnaf');

insert into PhoneNumber (PhoneNumber, Phonetype, EmployeeID) 
values  ('01712008360','Symbian',3),
		('01711101392','Android',2),
		('90244825285','Android',4),
		('01190070086','iPhone',1),
		('10574543896','iPhone',5);
commit;

begin tran;
delete from Employee where FirstName='Mursalin';
rollback;

begin tran;
save tran save1;
delete from PhoneNumber where EmployeeID=1;
save tran save2
delete from PhoneNumber where EmployeeID=5;
save tran save3;
rollback;
delete from Employee where FirstName='Mursalin';
save tran save4;
delete from Employee where EmployeeID=1;
rollback save2;
commit;
