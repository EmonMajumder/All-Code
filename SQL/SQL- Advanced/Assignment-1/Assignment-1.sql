/*Assignment-1
Emon Majumder*/

/*SELECT Query Requirements*/
use Chinook;


/*1.(Chinook db) Display the First Name, Last Name of each customer along with the First Name and Last Name of 
their support rep, sorted by customer last and first names. Give the support rep columns an appropriate alias.*/

select Customer.FirstName, Customer.LastName, CONCAT(Employee.FirstName,' ',Employee.LastName) Representative from Customer
inner join Employee on Customer.SupportRepId = Employee.EmployeeId
order by Customer.LastName, Customer.FirstName asc;


/*2.(Chinook db) Display the track name, genre name, and media type name for each track in the database, 
sorted by track name.*/

select Track.Name, Genre.Name, MediaType.Name from Track
inner join Genre on Track.GenreId = Genre.GenreId
inner join MediaType on Track.MediaTypeId = MediaType.MediaTypeId
order by Track.Name asc;


/*3.(Chinook db) Display the name of every artist and the total number of albums each artist has 
available for sale. Results should show the highest totals first.*/

select Artist.Name, COUNT(Album.Title) as "Number of Album" from Artist
left join Album on Artist.ArtistId = Album.ArtistId
group by Artist.Name order by "Number of Album" desc;


/*4.(Chinook db) Display the first name and last name of each customer along with a unique list of 
the types of media that they have purchased.*/

select distinct Customer.FirstName, Customer.LastName, MediaType.Name from Customer
left join Invoice on Customer.CustomerId = Invoice.CustomerId
inner join InvoiceLine on Invoice.InvoiceId = InvoiceLine.InvoiceId
inner join Track on InvoiceLine.TrackId = Track.TrackId
inner join MediaType on Track.MediaTypeId = MediaType.MediaTypeId
order by Customer.FirstName asc;

 
/*5.(Chinook db) Display the first name and last name of the single customer who has purchased the most video tracks.*/

select top 1 Customer.FirstName, Customer.LastName from Customer
left join Invoice on Customer.CustomerId = Invoice.CustomerId
inner join InvoiceLine on Invoice.InvoiceId = InvoiceLine.InvoiceId
inner join Track on InvoiceLine.TrackId = Track.TrackId
inner join MediaType on Track.MediaTypeId = MediaType.MediaTypeId
where MediaType.Name like '%video%' 
group by Customer.FirstName, Customer.LastName order by count(MediaType.Name) desc;


/*6.(Chinook db) Display the name of the artist and number of orders for the single artist who has had the highest 
number orders of his/her music placed.*/

select top 1 Artist.Name, count(InvoiceId) "Number of orders" from Artist
inner join Album on Artist.ArtistId = Album.ArtistId
inner join Track on Album.AlbumId = Track.AlbumId
inner join InvoiceLine on Track.TrackId = InvoiceLine.TrackId
group by Artist.Name order by count(InvoiceId) desc;


/*7.(Chinook db) Display the TrackID and TrackName of any tracks that have not yet been purchased.*/

select Track.TrackID, Track.Name from Track
left join InvoiceLine on Track.TrackId = InvoiceLine.TrackId
where InvoiceId is null;


Use Bookstore;
/*8.(Bookstore db) Using the “b_” tables, display the first and last names of all authors who currently do not have 
any books listed, sorted author last/first name.*/

select Fname FirstName, Lname LastName from B_AUTHOR a
left join B_BOOKAUTHOR  ba on a.AuthorID = ba.AUTHORid
where ISBN is null
order by FirstName;


/*9.(Bookstore db) Using the “b_” tables, display the Customer number, First name and Last name of any customers 
who have yet to place an order, sorted customer last/first name.*/

select c.Customer# CustomerID, FirstName, LastName from B_CUSTOMERS c
left join B_ORDERS o on c.Customer# = o.Customer#
where Order# is null
order by FirstName asc;

use CarsDB;
/*10.(Cars db) Using the Cars_Car_Types, Cars_Number_Of_Doors, Cars_Colors tables, create a query that returns every 
possible combination of the values of each table. (Hint: The result set should contain 24 rows.)*/

select CAR_TYPE, Color, Doors from CARS_CAR_TYPES
Cross join CARS_COLORS 
Cross join CARS_NUMBER_OF_DOORS;

use LunchesDB;
/*11.(Lunches db) List the employee ID,last name,and phone number of each employee with the name and phone number 
of his or her manager.Make sure that every employee is listed,even those that do not have a manager.
Sort the rows by the employee’s id number.*/

select L_E.EMPLOYEE_ID, L_E.LAST_NAME, L_E.PHONE_NUMBER, MANAGER from L_EMPLOYEES L_E
left join (select EMPLOYEE_ID, CONCAT(FIRST_NAME,' ',LAST_NAME) MANAGER, PHONE_NUMBER from L_EMPLOYEES) MList 
on MANAGER_ID = MList.EMPLOYEE_ID
order by L_E.EMPLOYEE_ID asc;


/*12.(Multiple dbs) Create one full list of first names and lastnames of all customers from the Chinooktables,
all authors from the Bookstore tables,all customers from the Bookstore tables,and all employees 
from the Lunches tables.Sort the list by last name and first name in ascending order.*/

select FirstName COLLATE DATABASE_DEFAULT, LastName COLLATE DATABASE_DEFAULT from Chinook.dbo.Customer
union all
select Fname COLLATE DATABASE_DEFAULT, Lname COLLATE DATABASE_DEFAULT from Bookstore.dbo.B_AUTHOR
union all
select FirstName COLLATE DATABASE_DEFAULT, LastName COLLATE DATABASE_DEFAULT from Bookstore.dbo.B_CUSTOMERS
union all
select FIRST_NAME COLLATE DATABASE_DEFAULT, LAST_NAME COLLATE DATABASE_DEFAULT from LunchesDB.dbo.L_EMPLOYEES
order by FirstName COLLATE DATABASE_DEFAULT, LastName COLLATE DATABASE_DEFAULT asc;

use numbersDB;
/*13.(Numbers db) Using the Numbers_Twos and Numbers_Threes tables, show the results of a query 
that only displays numbers that do not have a matching value in the other table.*/

select MULTIPLE_OF_2, MULTIPLE_OF_3 from NUMBERS_TWOS
full outer join NUMBERS_THREES on MULTIPLE_OF_2 = MULTIPLE_OF_3
where MULTIPLE_OF_2 is null or MULTIPLE_OF_3 is null
order by MULTIPLE_OF_2, MULTIPLE_OF_3 asc;


/*14.(Numbers db) Using the Numbers_Twos and Numbers_threes tables, show the results of a query 
that only displays numbers that have a matching value in the other table. 
Here’s the catch:You are not permitted to use a WHERE clause or JOINs for this query.*/

select MULTIPLE_OF_2 Matching_Values from NUMBERS_TWOS
intersect
select MULTIPLE_OF_3 Matching_Values from NUMBERS_THREES;