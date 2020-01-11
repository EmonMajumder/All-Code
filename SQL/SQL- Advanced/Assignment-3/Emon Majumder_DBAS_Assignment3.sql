use chinook;

/*Create a table Named RecordLogging to record any modifiaction or attempt to modify*/
create table RecordLogging (
LogId int primary key Identity,
TableName varchar(30) not null,
RecordId int,
ActionType varchar(30),
IsError bit,
ErrorNum int,
LogDate datetime);
go

/*Create a store proc to add record to the RecordLogging table*/
create proc uspAddRecordLog
@TableName varchar(30), @RecordId int, @ActionType varchar(30), @IsError bit, @ErrorNum int
as
begin
	begin tran
		begin try
			insert into RecordLogging (TableName, RecordId, ActionType, IsError, ErrorNum, LogDate)
			values(@TableName,@RecordId,@ActionType,@IsError,@ErrorNum,getdate());
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


/*Create a Store proc to insert data in the table Track*/
create proc uspTrack_Insert
@Name varchar(200),@AlbumId int=null,@MediatypeId int,@GenreId int=null,
@Composer varchar(220)=null,@Milliseconds int,@Bytes int=null,@UnitPrice numeric(10,2),@RecordId int=null Output
as
begin
	begin tran
		declare @ErrorNum int=0;
		declare @IsError bit=0;
		begin try
			insert into Track(Name,AlbumId,MediatypeId,GenreId,Composer,Milliseconds,Bytes,UnitPrice)
			values(@Name,@AlbumId,@MediatypeId,@GenreId,@Composer,@Milliseconds,@Bytes,@UnitPrice);
			select @RecordId=max(TrackId) from Track;
		end try
		begin catch
			print 'Error occurred. Data entry failed.'
			select @ErrorNum=error_number()
			set @IsError=1;
			set @RecordId=-1;  
			if @@TRANCOUNT>0
				rollback tran;
		end catch
		if @@TRANCOUNT>0
			commit tran;
		exec uspAddRecordLog @TableName='Track',@RecordId=@RecordId, @ActionType='Insert',@IsError=@IsError,@ErrorNum=@ErrorNum;						
end;
go

/*Create a Store proc to delete data from the table Track*/
create proc uspTrack_DeleteByID
@TrackId int,@RecordId int=null output
as
begin
	begin tran
		declare @ErrorNum int=0;
		declare @IsError bit=0;
		begin try
			delete from Track where TrackId=@TrackId;
			set @RecordId=@TrackId;
		end try
		begin catch
			print 'Error occurred. Could not delete data.'
			select @ErrorNum=error_number()
			set @IsError=1;
			set @RecordId=-1;  
			if @@TRANCOUNT>0
				rollback tran;
		end catch
		if @@TRANCOUNT>0
			commit tran;
		exec uspAddRecordLog @TableName='Track',@RecordId=@RecordId, @ActionType='Delete',@IsError=@IsError,@ErrorNum=@ErrorNum;						
end;
go

/*Create a Store proc to insert data in the table Album*/
create proc uspAlbum_Insert
@Title varchar(160),@ArtistId int,@RecordId int=null output
as
begin
	begin tran
		declare @ErrorNum int=0;
		declare @IsError bit=0;
		begin try 
			insert into Album(Title,ArtistId)
			values(@Title,@ArtistId);
			select @RecordId=max(AlbumId) from Album;
		end try
		begin catch
			print 'Error occurred. Data entry failed.'
			select @ErrorNum=error_number()
			set @IsError=1;
			set @RecordId=-1;  
			if @@TRANCOUNT>0
				rollback tran;
		end catch
		if @@TRANCOUNT>0
			commit tran;
		exec uspAddRecordLog @TableName='Album',@RecordId=@RecordId, @ActionType='Insert',@IsError=@IsError,@ErrorNum=@ErrorNum;						
end;
go

/*Create a Store proc to delete data from the table Album*/
create proc uspAlbum_DeleteByID
@AlbumId int,@RecordId int=null output
as
begin
	begin tran
		declare @IsError int=0;
		declare @ErrorNum int=0;
		begin try
			delete from Album where AlbumId=@AlbumId;
			set @RecordId = @AlbumId;
		end try
		begin catch
			print 'Error occurred. Could not delete data.'
			select @ErrorNum=error_number()
			set @IsError=1;
			set @RecordId=-1;    
			if @@TRANCOUNT>0
				rollback tran;
		end catch
		if @@TRANCOUNT>0
			commit tran;
		exec uspAddRecordLog @TableName='Album',@RecordId=@RecordId, @ActionType='Delete',@IsError=@IsError,@ErrorNum=@ErrorNum;						
end;
go

/*Create a Store proc to insert data in the table Genre*/
create proc uspGenre_Insert
@Name varchar(160),@RecordId int=null output
as
begin
	begin tran
		declare @ErrorNum int=0;
		declare @IsError bit=0;
		begin try 
			insert into Genre(Name)
			values(@Name);
			select @RecordId=max(GenreId) from Genre;
		end try
		begin catch
			print 'Error occurred. Data entry failed.'
			select @ErrorNum=error_number()
			set @IsError=1;
			set @RecordId=-1;  
			if @@TRANCOUNT>0
				rollback tran;
		end catch
		if @@TRANCOUNT>0
			commit tran;
		exec uspAddRecordLog @TableName='Genre',@RecordId=@RecordId, @ActionType='Insert',@IsError=@IsError,@ErrorNum=@ErrorNum;						
end;
go

/*Create a Store proc to delete data from the table Genre*/
create proc uspGenre_DeleteByID
@GenreId int,@RecordId int=null output
as
begin
	begin tran
		declare @IsError int=0;
		declare @ErrorNum int=0;
		begin try
			delete from Genre where GenreId=@GenreId;
			set @RecordId = @GenreId;
		end try
		begin catch
			print 'Error occurred. Could not delete data.'
			select @ErrorNum=error_number()
			set @IsError=1;
			set @RecordId=-1;    
			if @@TRANCOUNT>0
				rollback tran;
		end catch
		if @@TRANCOUNT>0
			commit tran;
		exec uspAddRecordLog @TableName='Genre',@RecordId=@RecordId, @ActionType='Delete',@IsError=@IsError,@ErrorNum=@ErrorNum;						
end;
go

/*Create a Store proc to insert data in the table Artist*/
create proc uspArtist_Insert
@Name varchar(160),@RecordId int=null output
as
begin
	begin tran
		declare @ErrorNum int=0;
		declare @IsError bit=0;
		begin try 
			insert into Artist(Name)
			values(@Name);
			select @RecordId=max(ArtistId) from Artist;
		end try
		begin catch
			print 'Error occurred. Data entry failed.'
			select @ErrorNum=error_number()
			set @IsError=1;
			set @RecordId=-1;  
			if @@TRANCOUNT>0
				rollback tran;
		end catch
		if @@TRANCOUNT>0
			commit tran;
		exec uspAddRecordLog @TableName='Artist',@RecordId=@RecordId, @ActionType='Insert',@IsError=@IsError,@ErrorNum=@ErrorNum;						
end;
go

/*Create a Store proc to delete data from the table Artist*/
create proc uspArtist_DeleteByID
@ArtistId int,@RecordId int=null output
as
begin
	begin tran
		declare @IsError int=0;
		declare @ErrorNum int=0;
		begin try
			delete from Artist where ArtistId=@ArtistId;
			set @RecordId = @ArtistId;
		end try
		begin catch
			print 'Error occurred. Could not delete data.'
			select @ErrorNum=error_number()
			set @IsError=1;
			set @RecordId=-1;    
			if @@TRANCOUNT>0
				rollback tran;
		end catch
		if @@TRANCOUNT>0
			commit tran;
		exec uspAddRecordLog @TableName='Artist',@RecordId=@RecordId, @ActionType='Delete',@IsError=@IsError,@ErrorNum=@ErrorNum;						
end;
go

/*Create a Store proc to insert data in the table Artist*/
create proc uspMediaType_Insert
@Name varchar(160),@RecordId int=null output
as
begin
	begin tran
		declare @ErrorNum int=0;
		declare @IsError bit=0;
		begin try 
			insert into MediaType(Name)
			values(@Name);
			select @RecordId=max(MediaTypeId) from MediaType;
		end try
		begin catch
			print 'Error occurred. Data entry failed.'
			select @ErrorNum=error_number()
			set @IsError=1;
			set @RecordId=-1;  
			if @@TRANCOUNT>0
				rollback tran;
		end catch
		if @@TRANCOUNT>0
			commit tran;
		exec uspAddRecordLog @TableName='MediaType',@RecordId=@RecordId, @ActionType='Insert',@IsError=@IsError,@ErrorNum=@ErrorNum;						
end;
go

/*Create a Store proc to delete data from the table Artist*/
create proc uspMediaType_DeleteByID
@MediaTypeId int,@RecordId int=null output
as
begin
	begin tran
		declare @IsError int=0;
		declare @ErrorNum int=0;
		begin try
			delete from MediaType where MediaTypeId=@MediaTypeId;
			set @RecordId = @MediaTypeId;
		end try
		begin catch
			print 'Error occurred. Could not delete data.'
			select @ErrorNum=error_number()
			set @IsError=1;
			set @RecordId=-1;  
			if @@TRANCOUNT>0
				rollback tran;
		end catch
		if @@TRANCOUNT>0
			commit tran;
		exec uspAddRecordLog @TableName='MediaType',@RecordId=@RecordId, @ActionType='Delete',@IsError=@IsError,@ErrorNum=@ErrorNum;						
end;
go

/*Executing Procs & Testing Statements*/
exec uspTrack_Insert @Name='emon',@AlbumId=5,@MediatypeId=4,@GenreId=2,@Composer='Emon',@Milliseconds=150,@Bytes=200,@UnitPrice=.99;
exec uspTrack_DeleteByID 50;

exec uspAlbum_Insert @Title='emons Song',@ArtistId=10;
exec uspAlbum_DeleteByID 50;

exec uspArtist_Insert @Name='Emon Majumder';
exec uspArtist_DeleteByID 5;

exec uspGenre_Insert @Name='emons Song';
exec uspGenre_DeleteByID 6;

exec uspMediaType_Insert @Name='Youtube';
exec uspMediaType_DeleteByID 3;

exec uspTrack_DeleteByID 3504;
exec uspAlbum_DeleteByID 348;
exec uspArtist_DeleteByID 276;
exec uspGenre_DeleteByID 26;
exec uspMediaType_DeleteByID 6;

exec uspTrack_Insert @Name='emon',@AlbumId=5,@MediatypeId=8,@GenreId=29,@Composer='Emon',@Milliseconds=150,@Bytes=200,@UnitPrice=.99;
exec uspAlbum_Insert @Title='emons Song',@ArtistId=295;


select * from Track;
select * from Album;
select * from Artist;
select * from Genre;
select * from MediaType;
select * from RecordLogging;

/*TRUNCATE TABLE RecordLogging;*/