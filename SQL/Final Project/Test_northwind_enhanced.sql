use northwind_enhanced;

#Test New Database for Data integrity

#Test 1: Numbers of customers from different countries.
select Country,count(all CompanyName) as NumberofCompany from customers
inner join country on Customers.CountryID=Country.CountryID
group by Country order by Country asc;

#Test 2: Number of products in different Category
select CategoryName, count(all ProductID) as NumberofProducts from products
inner join categories on Categories.CategoryID = products.CategoryID
group by CategoryName order by CategoryName asc ;

#Test 3: Number of products supplied by each supplier
select CompanyName, count(all ProductID) as NumberofProducts from products
inner join suppliers on products.SupplierID = suppliers.SupplierID
group by suppliers.SupplierID order by CompanyName asc ;

#Test 4: Products discontinued
select ProductID, ProductName from products
where Discontinued = 'y' order by ProductID asc ;

#Test 5: Number of Customers with different contact title.
select ContactTitle, count(all ContactName) from customers
group by ContactTitle order by ContactTitle asc;

#Test 6: Number of customers serviced by different employees
select Title_and_Fullname, count(distinct CustomerID) from employee_title_and_fullname
inner join orders on orders.EmployeeID = employee_title_and_fullname.EmployeeID
group by orders.EmployeeID order by Title_and_Fullname asc;

#Test 7: Numbers of orders shipped by different shippers
select CompanyName,count(OrderID) from orders
inner join shippers s on orders.ShipVia = s.ShipperID
group by CompanyName ;

#Test 8: Order amount by different customer (Value in cash)
select CompanyName, sum(UnitPrice*Quantity-UnitPrice*Quantity*Discount) as Total_Revenue from order_details
inner join orders o on order_details.OrderID = o.OrderID
inner join customers c on o.CustomerID = c.CustomerID
group by CompanyName order by Total_Revenue desc;

#Test 9: Revenue from products of different suppliers
select CompanyName, sum(order_details.UnitPrice*Quantity-order_details.UnitPrice*Quantity*Discount) as Total_Revenue from order_details
inner join products p on order_details.ProductID = p.ProductID
inner join northwind_orig.suppliers on p.SupplierID=suppliers.SupplierID
group by CompanyName order by Total_Revenue desc;

#Test 10: Number of products in different warehouse
select WareHouseName, count(all ProductID) from warehouse
inner join stock s on warehouse.WareHouseID = s.WareHouseID
group by WareHouseName;

#Test 11: Revenue from different product category
select categoryname, sum(order_details.UnitPrice*Quantity-order_details.UnitPrice*Quantity*Discount) as Total_Revenue from order_details
inner join products p on order_details.ProductID = p.ProductID
inner join categories c on p.CategoryID = c.CategoryID
group by categoryname order by Total_Revenue desc;

#Test 12: Number of orders processed by each employee
select Title_and_Fullname, count(OrderID) as NumberofOrders from employee_title_and_fullname
inner join employees e on employee_title_and_fullname.EmployeeID = e.EmployeeID
inner join orders on e.EmployeeID = orders.EmployeeID
group by Title_and_Fullname order by NumberofOrders desc;

#Test 13: Number of orders processed by each employee that was shipped via different shippers
select CompanyName, Title_and_Fullname, count(OrderID) as NumberofOrders from employee_title_and_fullname
inner join employees e on employee_title_and_fullname.EmployeeID = e.EmployeeID
inner join orders on e.EmployeeID = orders.EmployeeID
inner join shippers s on orders.ShipVia = s.ShipperID
group by Title_and_Fullname, CompanyName order by CompanyName asc, NumberofOrders desc;

#Test 14: Numbers of orders from different country
select Country, count(OrderID) as NumberofOrders from orders
inner join country c on orders.ShipCountryID = c.CountryID
group by Country order by NumberofOrders desc ;

#Test 15: List of products shipped to Canada from different supplier via "United Package"
select Country,ProductName, s.CompanyName, s2.CompanyName from orders
inner join country c on orders.ShipCountryID = c.CountryID
inner join order_details od on orders.OrderID = od.OrderID
inner join products p on od.ProductID = p.ProductID
inner join shippers s on orders.ShipVia = s.ShipperID
inner join suppliers s2 on p.SupplierID = s2.SupplierID
where Country= 'Canada' and s.CompanyName= 'United Package'
group by ProductName;