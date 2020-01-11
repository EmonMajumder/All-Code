create view PersonsByCountry as 
select FirstName, MiddleName, LastName, pc.Name from Person.Person pp
left join Person.BusinessEntityAddress pba on pp.BusinessEntityID=pba.BusinessEntityID
inner join Person.Address pa on pba.AddressID=pa.AddressID
inner join Person.StateProvince ps on pa.StateProvinceID=ps.StateProvinceID
inner join Person.CountryRegion pc on ps.CountryRegionCode= pc.CountryRegionCode;
go

select * from PersonsByCountry
order by Name, LastName, FirstName asc;

alter view PersonsByCountry as
select pp.BusinessEntityID, FirstName, MiddleName, LastName, pc.Name from Person.Person pp
left join Person.BusinessEntityAddress pba on pp.BusinessEntityID=pba.BusinessEntityID
inner join Person.Address pa on pba.AddressID=pa.AddressID
inner join Person.StateProvince ps on pa.StateProvinceID=ps.StateProvinceID
inner join Person.CountryRegion pc on ps.CountryRegionCode= pc.CountryRegionCode
go

/*GUI Generated SQL Query*/
USE [AdventureWorks]
GO

/****** Object:  View [dbo].[PersonAndEmailsByCountry]    Script Date: 2/5/2019 11:41:25 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE VIEW [dbo].[PersonAndEmailsByCountry] AS 
SELECT dbo.PersonsByCountry.FirstName, dbo.PersonsByCountry.MiddleName, dbo.PersonsByCountry.LastName, Person.EmailAddress.EmailAddress, dbo.PersonsByCountry.Name FROM dbo.PersonsByCountry 
INNER JOIN Person.EmailAddress ON dbo.PersonsByCountry.BusinessEntityID = Person.EmailAddress.BusinessEntityID
GO
/*GUI Generated SQL Query Ends*/

select FirstName, MiddleName, LastName, EmailAddress, Name from PersonAndEmailsByCountry
where Name='United States' and EmailAddress like 'P%'
order by LastName, FirstName;

alter view PersonAndEmailsByCountry as
select Person.EmailAddress.BusinessEntityID, FirstName, MiddleName, LastName, EmailAddress, Name from PersonsByCountry 
inner join Person.EmailAddress on PersonsByCountry.BusinessEntityID = Person.EmailAddress.BusinessEntityID
go

create view PersonEmployees as
select FirstName, MiddleName, LastName, EmailAddress, Name, JobTitle, HireDate from PersonAndEmailsByCountry pec
inner join HumanResources.Employee he on pec.BusinessEntityID=he.BusinessEntityID;
go

select CONCAT(FirstName,' ',MiddleName,' ', LastName) as FullName, JobTitle, HireDate, EmailAddress, Name from PersonEmployees
where HireDate > '20120101'
order by HireDate desc, JobTitle, FullName asc;