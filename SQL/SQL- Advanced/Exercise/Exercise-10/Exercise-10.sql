Use Chinook;

/*1. Create a standard SELECT query that returns, in two fields, a list of each employee’s month of birth*/
select CONCAT(FirstName,' ',LastName) Employee, DateName(MONTH,BirthDate) BirthDate from Employee order by month(BirthDate);
go

/*2. Write another regular SELECT query to retrieve the birthdays, displayed in the exact date format specified*/
select CONCAT(FirstName,' ',LastName) Employee, concat(DateName(WEEKDAY,BirthDate),' ,',Day(BirthDate),' ',DateName(MONTH,BirthDate),' ,',year(BirthDate)) BirthDay from Employee
order by month(BirthDate);
go

/*3. Make a scalar user-defined function that you can use anytime to get the same birthday data, in the preferred format.*/
create function GetBirthday()
Returns Table
as
return
	(select CONCAT(FirstName,' ',LastName) Employee, concat(DateName(WEEKDAY,BirthDate),' ,',Day(BirthDate),' ',DateName(MONTH,BirthDate),' ,',year(BirthDate)) BirthDay from Employee)
go

/*4. Write a SQL statement that uses the UDF from step 3 to retrieve the birthday records. */
select * from dbo.GetBirthday();
go

/*5.	Create a table-valued UDF called ufnGetFormattedCustomerRecords that returns all customer data, with the following specifications:
a. If the customer belongs to a company, only show the company name, not the personal name.
b. The full address (Address, City, State, Country, PostalCode) should be integrated as a single field, with values separated by commas. 
If any part of the address is missing, do not include it. Yes, this means no extra spaces or commas in your output!*/

create function ufnGetFormattedCustomerRecords()  
returns @Report table
(  
	CustomerId int primary key not null,
    CustomerDescription varchar(255) NOT NULL 
) 
as
begin
	declare @Counter int=1;
	declare @CustomerIdmax int =0;
	declare @CustomerId int =0;
	declare @Name varchar(100)= null;
	declare @Company varchar(100)= null;
	declare @Address varchar(100)= null;
	declare @City varchar(100)= null;
	declare @State varchar(100)= null;
	declare @Country varchar(100)= null;
	declare @PostalCode varchar(100)=null
	select @CustomerIdmax=max(CustomerId) from Customer;
	while (@Counter<=@CustomerIdmax)
		begin
			select @Name=concat(FirstName,', ',LastName) from Customer where CustomerId=@Counter;
			select @Company=Company from Customer where CustomerId=@Counter;
			select @Address=Address from Customer where CustomerId=@Counter;

			select @City=City from Customer where CustomerId=@Counter;
			if (@City is not null)
				begin
					set @City=concat(', ',@City);
				end

			select @State=State from Customer where CustomerId=@Counter;
			if (@State is not null)
				begin
					set @State=concat(', ',@State);
				end
								
			select @Country=Country from Customer where CustomerId=@Counter;
			if (@Country is not null)
				begin
					set @Country=concat(', ',@Country);
				end

			select @PostalCode=PostalCode from Customer where CustomerId=@Counter;
			if (@PostalCode is not null)
				begin
					set @PostalCode=concat(', ',@PostalCode);
				end

			insert into @Report (CustomerId ,CustomerDescription)
			values (@Counter,CONCAT(isnull(@Company,@Name),' - ',isnull(@Address,''),isnull(@City,''),isnull(@State,''),isnull(@Country,''),isnull(@PostalCode,'')));
			
			set @Counter=@Counter+1; 
		end
return  
end;
go

/*6. Write a SQL statement that uses the UDF from step 5 to retrieve every customer’s Email, Phone and the formatted data from the UDF*/
select Email,Phone, CustomerDescription from dbo.ufnGetFormattedCustomerRecords() GCR
join Customer on GCR.CustomerId=Customer.CustomerId;