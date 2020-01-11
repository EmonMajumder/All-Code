use Chinook;

select Name, Title from Artist
left join Album on Artist.ArtistId=Album.ArtistId
order by Name;

/*ArtistID:184 | Artist: Rodox | Album: No
  ArtistID:124 | Artist: R.E.M.| Album: Green */

select ArtistId, Name from Artist
where Name='R.E.M.';

select ArtistId, Name from Artist
where Name='Rodox';

begin tran
	begin try
		delete from Artist where ArtistId = 184;
	end try
	begin catch
		select ERROR_NUMBER() AS ErrorNumber ,
		ERROR_SEVERITY() AS ErrorSeverity,
		ERROR_STATE() AS ErrorState ,
		ERROR_PROCEDURE() AS ErrorProcedure ,
		ERROR_LINE() AS ErrorLine ,
		ERROR_MESSAGE() AS ErrorMessage;
		IF @@TRANCOUNT > 0 
			rollback tran;
	end catch;
	IF @@TRANCOUNT > 0
		commit tran;
go

select ArtistId, Name from Artist
where Name='Rodox';

begin tran
	begin try
		delete from Artist where ArtistId = 124;
	end try
	begin catch
		select ERROR_NUMBER() AS ErrorNumber ,
		ERROR_SEVERITY() AS ErrorSeverity,
		ERROR_STATE() AS ErrorState ,
		ERROR_PROCEDURE() AS ErrorProcedure ,
		ERROR_LINE() AS ErrorLine ,
		ERROR_MESSAGE() AS ErrorMessage;
		IF @@TRANCOUNT > 0 
			rollback tran;
	end catch;
	IF @@TRANCOUNT > 0
		commit tran;
go

/* ErrorMessage: The DELETE statement conflicted with the REFERENCE constraint 
"FK_AlbumArtistId". The conflict occurred in database "Chinook", 
table "dbo.Album", column 'ArtistId'. */

select ArtistId, Name from Artist
where Name='R.E.M.';

begin tran
	begin try
		delete from Artist where ArtistId = 124;
	end try
	begin catch
		IF @@TRANCOUNT > 0 
			rollback tran;
	end catch;
	IF @@TRANCOUNT > 0
		commit tran;
go

/*First attempt: 
No error message shown*/

begin tran
	begin try
		delete from Artist where ArtistId = 124;
	end try
	begin catch
		throw
		IF @@TRANCOUNT > 0 
			rollback tran;
	end catch;
	IF @@TRANCOUNT > 0
		commit tran;
go

/*Second attempt: 
Msg 547, Level 16, State 0, Line 79
The DELETE statement conflicted with the REFERENCE constraint 
"FK_AlbumArtistId". The conflict occurred in database "Chinook", 
table "dbo.Album", column 'ArtistId'. */

begin tran
	begin try
		delete from Artist where ArtistId = 124;
	end try
	begin catch
		throw 148300,'I got the Error msg of my own',1
		IF @@TRANCOUNT > 0 
			rollback tran;
	end catch;
	IF @@TRANCOUNT > 0
		commit tran;
go

/*Third attempt: 
Msg 148300, Level 16, State 1, Line 101
I got the Error msg of my own */

select ArtistId, Name from Artist
where Name='R.E.M.';