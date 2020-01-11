use chinook;

drop table if exists DiscontinuedArtists;
create table DiscontinuedArtists (
DiscArtistId int primary key identity,
OriginalArtistId int not null,
ArtistName varchar(120),
DiscontinuedDate datetime not null default GETDATE(), 
);
go

create or alter proc uspCheckForDiscontinuedArtists
as
begin
	set nocount on;
	begin tran
		begin try
			declare @RecordId int=1, @ArtistId int, @ArtistName nvarchar(120), @AlbumTitle nvarchar(160),
			@TrackName nvarchar(200), @Composer nvarchar(220), @checkid int=0

			--Create cursor, using the result set from the query defined in the FOR clause
			declare ArtistCursor cursor 
				for 
					select Artist.ArtistId, Artist.Name, Title, Track.Name, Composer from Artist
					left join Album on Artist.ArtistId=Album.ArtistId
					left join Track on Album.AlbumId=Track.AlbumId 
					order by Artist.ArtistId asc;

			-- Open our cursor
			open ArtistCursor;

			-- Get first record from result set, BEFORE entering the loop.
			-- Cursors don't automatically move to first record, we have to do it manually
			-- FETCH statement uses INTO to set the variables with the fetched record's values
			fetch next from ArtistCursor 
				into @ArtistId, @ArtistName, @AlbumTitle, @TrackName, @Composer;

			--Print a title and column headers for our report
			print 'All Artist by Album and Track'
			print 'RecordId ArtistID  Last   First   Company   City   Country  State'
			print '--------------------------------------------------'

			-- While there are still more rows to fecth from result set...
			while @@FETCH_STATUS = 0
			begin
				set @checkid = 0;
				if (@AlbumTitle is null)
				begin
					select @checkid=DiscArtistId from DiscontinuedArtists where ArtistName=@ArtistName;
					if (@checkid = 0)
					begin
						insert into DiscontinuedArtists (OriginalArtistId,ArtistName)
						values (@ArtistId,@ArtistName);
					end
					delete from Artist where ArtistId=@ArtistId;
					print CAST(@RecordId as nvarchar)+' - '+CAST(@ArtistId as nvarchar) + ' - ' + @ArtistName+ ' - ' + ISNULL(@AlbumTitle,'NO ALBUMS OR TRACKS');
				end
				else
				-- For each row, print a record-specific string as a line in the report
					print CAST(@RecordId as nvarchar)+' - '+CAST(@ArtistId as nvarchar) + ' - ' + @ArtistName+ ' - ' + @AlbumTitle
					 + ' - ' + ISNULL(@TrackName,'NO TRACKS') + ' - ' + ISNULL(@Composer,'UNKNOWN COMPOSER')
				
				set @RecordId=@RecordId+1;

				-- Get the next row from result set before moving to the next iteration of the WHILE loop
				fetch next from ArtistCursor 
				into @ArtistId, @ArtistName, @AlbumTitle, @TrackName, @Composer;
			end
			--Close and deallocate the cursor... this should ALWAYS be done.
			close ArtistCursor;
			deallocate ArtistCursor;
		end try
		begin catch
			print 'Error occurred. Data entry failed.'
			if @@TRANCOUNT>0
				rollback tran;
		end catch
		if @@TRANCOUNT>0
			commit tran;			
end;
go

/* Test-1 */
exec uspCheckForDiscontinuedArtists;
select * from DiscontinuedArtists;
select * from Artist;
select Name from Artist
inner join DiscontinuedArtists on Artist.Name=DiscontinuedArtists.ArtistName;


/* Test-2 */
insert into Artist (Name) values ('Emon Majumder');
insert into Artist (Name) values ('Jyoty Dev Nath');
insert into Artist (Name) values ('Bijan Majumder');
insert into Artist (Name) values ('Baby Consuelo');		/*Common Record with */
insert into Artist (Name) values ('Ney Matogrosso');	/*Common Record with */
select * from Artist;
exec uspCheckForDiscontinuedArtists;
select * from DiscontinuedArtists;
select * from Artist;
select Name from Artist
inner join DiscontinuedArtists on Artist.Name=DiscontinuedArtists.ArtistName;

delete from DiscontinuedArtists where ArtistName='Emon Majumder';
delete from DiscontinuedArtists where ArtistName='Jyoty Dev Nath';
delete from DiscontinuedArtists where ArtistName='Bijan Majumder';
