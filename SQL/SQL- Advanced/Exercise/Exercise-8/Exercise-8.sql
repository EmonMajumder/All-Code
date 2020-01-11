use Chinook;

delete from PremiumTrack;
DBCC CHECKIDENT(PremiumTrack, RESEED, 0)

declare @trackCounter int
declare @totalTrack int
declare @trackLength int
declare @rating float
declare @newPrice float

set @trackCounter = 1
select @totalTrack = max(trackid) from Track;

begin tran
	while @trackCounter<@totalTrack+1
		begin			
			begin try
				if (select Milliseconds from Track where trackid=@trackCounter)>=500000
					begin
						while @trackCounter<@totalTrack+1
							begin
								if (select Milliseconds from Track where trackid=@trackCounter)>3000000
									begin
										set @rating=5
										set @newPrice=5.99
										break
									end 
								if (select Milliseconds from Track where trackid=@trackCounter)>2500000
									begin
										set @rating=4
										set @newPrice=4.99
										break
									end
								if (select Milliseconds from Track where trackid=@trackCounter)>2000000
									begin
										set @rating=3
										set @newPrice=3.99
										break
									end
								if (select Milliseconds from Track where trackid=@trackCounter)>1000000
									begin
										set @rating=2
										set @newPrice=2.99
										break
									end
								if (select Milliseconds from Track where trackid=@trackCounter)>=500000
									begin
										set @rating=1
										set @newPrice=1.99
										break
									end
							end																																				
						INSERT INTO PremiumTrack(Name,Composer,Milliseconds,Bytes,UnitPrice,Rating)
						select Name,Composer,Milliseconds,Bytes,@newPrice,@rating from Track
						where TrackId=@trackCounter;
						set @trackCounter=@trackCounter+1;							
					end
				else
					set @trackCounter=@trackCounter+1;
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
			end catch
			if @@TRANCOUNT > 0 					
				commit tran;						
		end	
go

select * from PremiumTrack;

select count(*) from PremiumTrack;
select count(*) from PremiumTrack
where Milliseconds <500000;
select count(*) from PremiumTrack
where Milliseconds between 500000 and 999999;
select count(*) from PremiumTrack
where Milliseconds between 1000000 and 1999999;
select count(*) from PremiumTrack
where Milliseconds between 2000000 and 2499999;
select count(*) from PremiumTrack
where Milliseconds between 2500000 and 2999999;
select count(*) from PremiumTrack
where Milliseconds > 3000000;