use Chinook;

select * from Customer where Company is not null;
select * from Track where Composer is null;
select * from Track where name like '%love%';
select * from Track where Bytes between 1000000 and 2000000 order by Milliseconds desc;
select FirstName, LastName from Customer where Email like '%.ca';
select round(avg(Total),2) from Invoice ;
select CONCAT(FirstName,' ',LastName) , round(avg(Total),2) from Invoice 
inner join Customer on Invoice.CustomerId=Customer.CustomerId
group by CONCAT(FirstName,' ',LastName) order by round(avg(Total),2) desc ;
select CONCAT(FirstName,' ',LastName) , round(avg(Total),2) from Invoice 
inner join Customer on Invoice.CustomerId=Customer.CustomerId 
group by CONCAT(FirstName,' ',LastName) having round(avg(Total),2)>= 6.00 
order by round(avg(Total),2) desc ;
select count(Name) from Track;
select Title, count(Name) as 'Number of Songs' from Track 
inner join Album on Track.AlbumId=Album.AlbumId
group by Title order by Title asc;
select top 1 Artist.Name, count(Artist.Name) as 'Number of Songs' from Track 
inner join Album on Track.AlbumId=Album.AlbumId
inner join Artist on Album.ArtistId=Artist.ArtistId
group by Artist.Name order by [Number of Songs] desc ;  
select Track.name, Genre.Name, MediaType.Name from Track
inner join Genre on Track.GenreId=Genre.GenreId
inner join MediaType on Track.MediaTypeId=MediaType.MediaTypeId 
order by MediaType.Name, Genre.Name, Track.name asc;
select LastName, FirstName, Track.Name, InvoiceDate from Customer
inner join Invoice on Customer.CustomerId=Invoice.CustomerId
inner join InvoiceLine on Invoice.InvoiceId=InvoiceLine.InvoiceId
inner join Track on InvoiceLine.TrackId=Track.TrackId
order by LastName, FirstName, Track.Name asc;
select Track.Name, Album.Title, Artist.Name from Track
inner join Album on Track.AlbumId=Album.AlbumId
inner join Artist on Album.ArtistId=Artist.ArtistId
order by Artist.Name, Album.Title, Track.Name asc;

