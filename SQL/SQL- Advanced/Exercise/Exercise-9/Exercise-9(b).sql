use Chinook;
go;


/*Step 1*/
create proc spOrdersByYearAndCountryAndArtistAndAlbum
@Year int, @Country varchar(30)= null, @Artist varchar(30)= null, @Album varchar(30)=null
as
begin
	select InvoiceYear, Total, BillingCountry, ArtistName, AlbumName from vwOrderData
	where InvoiceYear = @Year
	and BillingCountry= isnull(@Country,BillingCountry)
	and ArtistName= isnull(@Artist,ArtistName)
	and AlbumName like '%'+isnull(+@Album,AlbumName)+'%';
end
go;

/*Step 2(a)*/
exec spOrdersByYearAndCountryAndArtistAndAlbum 2010;

/*Step 2(b)*/
exec spOrdersByYearAndCountryAndArtistAndAlbum 2010, @Country='United Kingdom';

/*Step 2(c)*/
exec spOrdersByYearAndCountryAndArtistAndAlbum 2010, @Country='Canada', @Artist='Led Zeppelin';

/*Step 2(d)*/
exec spOrdersByYearAndCountryAndArtistAndAlbum 2010, @Country='Canada', @Artist='Led Zeppelin',@Album='IV';
go;

/*Step 3*/
create proc spOrdersByYearAndCountryAndArtistAndAlbum_Summary
@Year int, @Country varchar(30)= null, @Artist varchar(30)= null, @Album varchar(30)=null
as
begin
	select InvoiceYear, max(Total) Total, BillingCountry, ArtistName, AlbumName from vwOrderData
	where InvoiceYear = @Year
	and BillingCountry= isnull(@Country,BillingCountry)
	and ArtistName= isnull(@Artist,ArtistName)
	and AlbumName like '%'+isnull(+@Album,AlbumName)+'%'
	group by InvoiceYear, BillingCountry, ArtistName, AlbumName;
end

/*Step 4(a)*/
exec spOrdersByYearAndCountryAndArtistAndAlbum_Summary 2010;

/*Step 4(b)*/
exec spOrdersByYearAndCountryAndArtistAndAlbum_Summary 2010, @Country='United Kingdom';

/*Step 4(c)*/
exec spOrdersByYearAndCountryAndArtistAndAlbum_Summary 2010, @Country='Canada', @Artist='Led Zeppelin';

/*Step 4(d)*/
exec spOrdersByYearAndCountryAndArtistAndAlbum_Summary 2010, @Country='Canada', @Artist='Led Zeppelin',@Album='IV';
go;


/*Step 5*/
create proc spOrdersByYear_SUMMARYByCountryOrArtistOrAlbum
@Year int, @Country varchar(30)= null, @Artist varchar(30)= null, @Album varchar(30)=null
as
begin
	if (@Country is not null )
		begin
			select InvoiceYear, sum(all Total) 'Sum Total' from vwOrderData
			where InvoiceYear = @Year and BillingCountry= @Country
			group by InvoiceYear, BillingCountry;
		end
	else if (@Artist is not null )
		begin
			select InvoiceYear, sum(all Total) 'Sum Total' from vwOrderData
			where InvoiceYear = @Year and ArtistName= @Artist
			group by InvoiceYear, ArtistName;
		end
	else if (@Album is not null )
		begin
			select InvoiceYear, sum(all Total) 'Sum Total' from vwOrderData
			where InvoiceYear = @Year and AlbumName like '%'+@Album+'%'
			group by InvoiceYear, AlbumName;
		end
	else
		begin
			print 'No country, artist or album parameters were entered'
		end
end
go;


/*Step 6(a)*/
exec spOrdersByYear_SUMMARYByCountryOrArtistOrAlbum 2010;

/*Step 6(b)*/
exec spOrdersByYear_SUMMARYByCountryOrArtistOrAlbum 2010, @Country= 'United Kingdom';

/*Step 6(c)*/
exec spOrdersByYear_SUMMARYByCountryOrArtistOrAlbum 2010, @Artist= 'Led Zeppelin';

/*Step 6(d)*/
exec spOrdersByYear_SUMMARYByCountryOrArtistOrAlbum 2010, @Album= 'Big';
