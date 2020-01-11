##########################################################
# Use the Sakila database to build the following queries #
##########################################################
use sakila;
#1. Create a query that returns the email address for customer Alfred Casillas (1 record)
select email from customer where first_name='Alfred' and last_name='Casillas';

#2. Create a query that returns a list of all film categories, sorted in reverse alphabetical order. (16 records)
select name from category order by name DESC;

#3. Create a query that returns all movies that are about a lumberjack.  (72 records)
select title from film_text where description like '%lumberjack%';

#4. Create a query that returns customers who shop at store #2.  (273 records)
select concat(first_name,last_name) as "Full Name" from customer where store_id='2';

#5. Create a query that returns a list of the names and ratings for all films rated R or
# NC-17, sorted by rating (NC-17 first, then R), then by film name in alphabetical order. (405 records)
select title,rating from film where rating='R' or rating='NC-17' order by rating DESC,title ASC;

#6. Create a query that returns only a list of city names, for all Canadian cities.  (7 records)
select distinct city from city where country_id=(select country_id from country where country='Canada');

#7. Create a query that returns any language with name ending in 'n'.  (3 records)
select name from language where name like '%n';

#8. Create a query that returns any film name that begins with B, F or G   (155 records)
select title from film where title like 'B%' or title like 'F%' or title like 'G%';

#9. Create a query that returns the 5 highest payment amounts.
select distinct amount from payment order by amount DESC limit 5;

#10. Create a query that returns the title and length of the 3 shortest movies in the db. Rename
# the title column as Shorts and the time column as Minutes.
select title as "Shorts",length as "Minutes" from film order by length ASC limit 3;

#11. Create a query that returns all actors with a first name of Tom or a last name of Cruise.
#Display only the name fields, renamed as First and Last. (3 records)
select concat(first_name,last_name) as "Fast and Last" from actor where first_name='Tom' or last_name='Cruise';

#12. Create a query to return a list containing the addresses, districts and postal codes for all
# addresses in the district of Buenos Aires, sorted by street number and postal code. (10 records)
select address,district,postal_code from address where district='Buenos Aires' order by postal_code ASC,address ASC;

#13. Create a query that displays a list of all unique district names from the address
# table, sorted alphabetically. (378 records)
select distinct district from address order by district ASC;


#14. Create a query that returns all payment records made by customer 25 with an
# amount less than $8 but higher than $5. Sort from highest to lowest. (4 records)
select * from payment where customer_id='25' and (amount>5.00 and amount<8.00) order by amount DESC;


#15. Create a query that returns addresses that do not have ANY value for the second
# address field.  (4 records)
select address from address where address2 is null;

#16. Create a query that returns a list of all cities from the country of Chile. Do NOT
# use any hard-coded country IDs!
select city from city where country_id=(select country_id from country where country='Chile');


#17. Create a query that returns a list of all actor records whose first name does NOT
# start with a vowel. Sort by first, then last name and rename the first name field
# as "Vowel-less Firsts".   (176 records)
select distinct first_name as "Vowel-less Firts",last_name from actor where first_name not like 'a%' or 'e%' or 'i%' or 'o%' or 'u%'
and (select distinct concat(first_name,last_name) from actor) order by first_name ASC,last_name ASC;
