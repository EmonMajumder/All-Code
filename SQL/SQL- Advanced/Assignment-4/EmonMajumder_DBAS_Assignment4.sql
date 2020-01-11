use Chinook;

drop table if exists EmployeeCommission;
create table EmployeeCommission (
CommissionId int primary key identity,
EmployeeId int not null,
InvoiceId int not null,
CommMonth int default month(getdate()),
CommYear int default year(getdate()),
CommAmount money default 0,
foreign key (EmployeeId) references Employee(EmployeeId),  
);

alter table Employee
add CommissionAmounttoDate money not null default 0;

alter table Customer
drop column if exists NumBonusesToDate;

alter table Customer
add NumBonusesToDate int not null default 0;

/*A track record is added to track table*/
insert into track(Name,AlbumId,MediaTypeId,GenreId,Composer,Milliseconds,Bytes,UnitPrice)
values ('Chinook Bonus Track Voucher',5,3,1,'Emon Majumder',201483,4204208,2.99);
go

/*Add Employee cimmission row if invoice is deleted.*/
create or alter trigger trgInvoice_AddEmployeeCommission
on Invoice for insert,update
as
begin
	begin tran
		begin try
			declare @employeeId int
			declare @salescommission money
			declare @date datetime
			declare @InvoiceId int
			declare @customerId int
			select @InvoiceId=max(InvoiceId) from Invoice;
			select @customerId=CustomerId from Invoice where InvoiceId=@InvoiceId;
			select @employeeId=SupportRepId from Customer where CustomerId=@customerId;
			select @date=InvoiceDate from Invoice where InvoiceId=@InvoiceId;
			select @salescommission=Total from Invoice where InvoiceId=@InvoiceId;
			set @salescommission=@salescommission*0.1;
			insert into EmployeeCommission (EmployeeId,InvoiceId,CommMonth,CommYear,CommAmount)
			values(@employeeId,@InvoiceId,month(@date),year(@date),@salescommission);
		end try
		begin catch
			print 'Error occurred. Data entry failed for trgInvoice_AddEmployeeCommission.'
			if @@TRANCOUNT>0
				rollback tran;
		end catch
	if @@TRANCOUNT>0
		commit tran;
end
go

/*Delete Employee cimmission row if invoice is deleted.*/
create or alter trigger trgInvoice_DeleteEmployeeCommission
on Invoice for delete
as
begin
	begin tran
		begin try
			declare @invoicetotal int
			declare @bonusqualifylimit money=20
			declare @InvoiceId int
			declare @pNumbonus int
			declare @Customer int
			select @InvoiceId=InvoiceId from deleted;
			select @invoicetotal=Total from deleted;
			select @Customer=CustomerId from deleted;
			if (@invoicetotal>=@bonusqualifylimit)
				begin
					select @pNumbonus=NumBonusesToDate from Customer where CustomerId=@Customer;
					set @pNumbonus=@pNumbonus-1;
					update Customer
					set NumBonusesToDate=@pNumbonus where CustomerId=@Customer;
				end
			delete from EmployeeCommission where InvoiceId=@InvoiceId;
		end try
		begin catch
			print 'Error occurred. EmployeeCommission record was not deleted.'
			if @@TRANCOUNT>0
				rollback tran;
		end catch
	if @@TRANCOUNT>0
		commit tran;
end
go

/*Credit Employee commission if invoice added*/
create or alter trigger trgEmpComm_CreditEmployeeCommToDate
on EmployeeCommission for insert,update
as
begin
	begin tran
		begin try
			declare @salescommission money
			declare @Employee int
			declare @pcomm money
			select @Employee=EmployeeId from inserted;
			select @salescommission=CommAmount from EmployeeCommission where EmployeeId=@Employee;
			select @pcomm=CommissionAmounttoDate from Employee where EmployeeId=@Employee;
			update Employee
			set CommissionAmounttoDate=(@pcomm+@salescommission) where EmployeeId=@Employee;
		end try
		begin catch
			print 'Error occurred.'
			if @@TRANCOUNT>0
				rollback tran;
		end catch
	if @@TRANCOUNT>0
		commit tran;
end
go

/*Debit Employee commission if invoice deleted*/
create or alter trigger trgEmpComm_DebitEmployeeCommToDate
on EmployeeCommission for delete
as
begin
	begin tran
		begin try
			declare @salescommission money
			declare @Employee int
			declare @pcomm money
			select @Employee=EmployeeId from deleted;
			select @salescommission=CommAmount from deleted where EmployeeId=@Employee;
			select @pcomm=CommissionAmounttoDate from Employee where EmployeeId=@Employee;
			update Employee
			set CommissionAmounttoDate=(@pcomm-@salescommission) where EmployeeId=@Employee;
		end try
		begin catch
			print 'Error occurred.'
			if @@TRANCOUNT>0
				rollback tran;
		end catch
	if @@TRANCOUNT>0
		commit tran;
end
go

/*Customer gets a bonus track if applicable*/
create or alter trigger trgInvoice_AddBonusTrackVoucher
on Invoice for insert
as
begin
	begin tran
		begin try
			declare @Customer int
			declare @invoicetotal money
			declare @bonusqualifylimit money=20
			declare @pNumbonus int
			declare @invoiceId int
			select @invoiceId=max(InvoiceId) from Invoice;
			select @invoicetotal=Total from Invoice where InvoiceId=@invoiceId;
			select @Customer=CustomerId from Invoice where InvoiceId=@invoiceId;
			select @invoiceId=InvoiceId from Invoice where InvoiceId=@invoiceId;
			if (@invoicetotal>=@bonusqualifylimit)
				begin
					print 'Chinook Bonus Track Voucher__________$2.99'
					insert into InvoiceLine (InvoiceId,TrackId,UnitPrice,Quantity)
					values (@invoiceId,3504,2.99,1);
					select @pNumbonus=NumBonusesToDate from Customer where CustomerId=@Customer;
					set @pNumbonus=@pNumbonus+1;
					update Customer
					set NumBonusesToDate=@pNumbonus where CustomerId=@Customer;
				end
		end try
		begin catch
			print 'Error occurred. Data entry failed for AddBonusTrackVoucher.'
			if @@TRANCOUNT>0
				rollback tran;
		end catch
	if @@TRANCOUNT>0
		commit tran;					
end
go

/*Stored procedure to delete data from Invoice table*/
create or alter proc dltInvoice
@InvoiceId int
as
begin
	begin tran
		begin try
			delete from invoiceline where InvoiceId=@InvoiceId;
			delete from invoice where InvoiceId=@InvoiceId;			
		end try
		begin catch
			print 'Error occurred. Action was not completed.'
			if @@TRANCOUNT>0
				rollback tran;
		end catch
		if @@TRANCOUNT>0
			commit tran;			
end;
go


/*Testing Statements*/
select * from Track;

/*Insert a new invoice where Customer gets a bonus track*/
insert into Invoice (CustomerId,InvoiceDate,BillingAddress,BillingCity,BillingCountry,BillingPostalCode,BillingState,Total)
values (35,getdate(),'294 Osborne St','Halifax','Canada','2K5 7F3','NS',26);

/*Insert a new invoice where Customer does not get a bonus track*/
insert into Invoice (CustomerId,InvoiceDate,BillingAddress,BillingCity,BillingCountry,BillingPostalCode,BillingState,Total)
values (30,getdate(),'294 kjh St','Truro','Canada','2K5 7F3','NS',15);

/*Must delete record from Invoice through stored proc dltInvoice. Other wise need to delete associated Invoiceline item first.*/
exec dltInvoice 413;
exec dltInvoice 414;

/*Check tables for action completed*/
select * from InvoiceLine;
select * from Invoice;
select * from Employee;
select * from Customer;
select * from EmployeeCommission;


