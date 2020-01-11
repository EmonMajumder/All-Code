use Chinook;

/*Step: 1*/
select YEAR(InvoiceDate) InvoiceYear, BillingState, BillingCountry, Total, Track.Name TrackName, 
Title AlbumName, Artist.Name ArtistName from Invoice
left join InvoiceLine on Invoice.InvoiceId=InvoiceLine.InvoiceId
left join Track on InvoiceLine.TrackId=Track.TrackId
left join Album on Track.AlbumId=Album.AlbumId
left join Artist on Album.ArtistId=Artist.ArtistId;


/*Step: 2*/
create view vwOrderData 
as
select YEAR(InvoiceDate) InvoiceYear, BillingState, BillingCountry, Total, Track.Name TrackName, 
Title AlbumName, Artist.Name ArtistName from Invoice
left join InvoiceLine on Invoice.InvoiceId=InvoiceLine.InvoiceId
left join Track on InvoiceLine.TrackId=Track.TrackId
left join Album on Track.AlbumId=Album.AlbumId
left join Artist on Album.ArtistId=Artist.ArtistId;
go


/*Step: 3*/
create procedure spOrdersByYear
(@year int = null)
as
begin
	if (@year > 0)
		begin 
			select * from vwOrderData where InvoiceYear=@year;
		end
	else
		begin
			select * from vwOrderData;
		end
end
go


/*Step: 4(a)*/
exec spOrdersByYear;
/*Step: 4(b)*/
exec spOrdersByYear 2010;
go;


/*Step: 5*/
create proc spOrdersByYear_ValidYear
@year int = null, @YearValidation varchar(50) = 'No records exist for that year' output,
@YearCount int = 0 output 
as
begin
	if (@year > 0)
		begin
			select @YearCount = count(*) from vwOrderData where InvoiceYear=@year;
			if(@YearCount>0)
				begin
					select * from vwOrderData where InvoiceYear=@year;
				end
			else
				begin
					print @YearValidation
				end
		end
	else
		begin
			select * from vwOrderData;
		end
end
go

/*Step: 6(a)*/
exec spOrdersByYear_ValidYear;

/*Step: 6(b)*/
exec spOrdersByYear_ValidYear 2010;

/*Step: 6(c)*/
exec spOrdersByYear_ValidYear 2050;
go;


/*Step: 7*/
create proc spOrdersByCountryAndState
@Country varchar(30), @State varchar(30) = null
as
begin
	if @Country='Canada' or @Country='USA'
		begin
			if @State is null
				begin
					print 'For Canada or the US, you must enter a province or state abbreviation.'
				end
			else
				begin
					select * from vwOrderData where BillingCountry = @Country and BillingState = @State;
				end
		end
	else
		begin
			select * from vwOrderData where BillingCountry = @Country;
		end
end
go


/*Step: 8(a)*/
exec spOrdersByCountryAndState;
 
/*Step: 8(b)*/
exec spOrdersByCountryAndState 'United Kingdom';

/*Step: 8(c)*/
exec spOrdersByCountryAndState 'Canada';

/*Step: 8(d)*/
exec spOrdersByCountryAndState @Country = 'Canada', @State='NS';