/*1.(Chinook DB) Create a query that lists the id and name of all tracks that have not yet been purchased at least once. 
Sort the results by track name in alphabetical order.*/
Use Chinook;
Select Track.TrackId, Name from Track
left join InvoiceLine on Track.TrackId=InvoiceLine.TrackId
group by Track.TrackId, Track.Name
having count(InvoiceLine.InvoiceLineId) = 0
order by Name asc;


/*2.(Chinook DB) Create a query that lists the id and name of all playlists that do not have any tracks assigned to them. 
Alias the columns appropriately*/
Select Pl.PlaylistId, Name from playlist pl
left join PlaylistTrack pt on Pl.PlaylistId=Pt.PlaylistId
group by Pl.PlaylistId, Name
having count(TrackId) = 0
order by Name asc;


/*3.(Numbers db) Using the Multiples_Of_Two and Multiples_Of_Three tables, show the results of a query that only displays 
numbers that have a matching value in the other table. 
Here’s the catch: You are not permitted to use a WHERE clause or joins for this query*/
use NumbersDB;
select Twos from Multiples_Of_Two
intersect
select Threes from Multiples_Of_Three;


/*4.(Chinook db) Create a query to find a list of all employees that have never served as a rep for any customers. 
Both the employee’s first and last names should only be displayed in a single field named “Employee Name”, 
and include the employee’s job title in your result*/
Use Chinook;
select CONCAT(Employee.FirstName,' ',Employee.LastName) as "Employee Name", Employee.Title from Employee
left join Customer on Employee.EmployeeId = Customer.SupportRepId
group by CONCAT(Employee.FirstName,' ',Employee.LastName), Employee.Title
having count(CustomerId) = 0
order by CONCAT(Employee.FirstName,' ',Employee.LastName);


/*5.(Multiple DBs) Create a query to gather a list of all first & last names and the country of residence of people 
living in either Canada or France, from the Customer and Employee tables in Chinook and the Person.Person and Person.
CountryRegion tables in AdventureWork*/
select FirstName COLLATE DATABASE_DEFAULT, LastName COLLATE DATABASE_DEFAULT, Country COLLATE DATABASE_DEFAULT from Customer where Country = 'Canada' or Country = 'France'
union all
select FirstName COLLATE DATABASE_DEFAULT, LastName COLLATE DATABASE_DEFAULT, Country COLLATE DATABASE_DEFAULT from Employee where Country = 'Canada' or Country = 'France'
union all
select FirstName COLLATE DATABASE_DEFAULT, LastName COLLATE DATABASE_DEFAULT, AdventureWorks.Person.CountryRegion.Name COLLATE DATABASE_DEFAULT from AdventureWorks.Person.Person
inner join AdventureWorks.Person.BusinessEntityAddress on AdventureWorks.Person.Person.BusinessEntityID = AdventureWorks.Person.BusinessEntityAddress.BusinessEntityID
inner join AdventureWorks.Person.Address on AdventureWorks.Person.BusinessEntityAddress.AddressID = AdventureWorks.Person.Address.AddressID
inner join AdventureWorks.Person.StateProvince on AdventureWorks.Person.Address.StateProvinceID = AdventureWorks.Person.StateProvince.StateProvinceID
inner join AdventureWorks.Person.CountryRegion on  AdventureWorks.Person.StateProvince.CountryRegionCode = AdventureWorks.Person.CountryRegion.CountryRegionCode
where AdventureWorks.Person.CountryRegion.Name = 'Canada' or AdventureWorks.Person.CountryRegion.Name = 'France'
order by Country COLLATE DATABASE_DEFAULT, FirstName, LastName asc;