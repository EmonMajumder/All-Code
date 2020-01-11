use sakila;

#1.	Create a query that returns all film titles in alphabetical order for the language with ID = 1.
select title from film where language_id='1' order by title asc ;

#2.	Create a query that will list all the film titles containing the word “Drama” in the description.
# (You need only to accommodate the displayed spelling of the word.)
select title from film where description like '%Drama%' ;

#3.	Create a query that lists all films with the ratings 'G', 'PG, and 'PG-13' and also do not have an
#original language ID. Build the query to check for all conditions, regardless of the data. Sort the
# results alphabetically by rating, then title.
select title,rating,original_language_id from film where (rating='G' or rating='PG' or rating='PG-13')
and original_language_id is null order by rating,title asc ;

#4.	Create a query that lists all payment ids for amounts less than $2.99 and after the June 1st, 2005.
# Sort the results by payment date, then amount.
select payment_id,payment_date,amount from payment where payment_date>'2005-06-01 00:00:00' and
amount<2.99 order by payment_date,amount asc ;

#5.	Create a query that lists all cities who have 'Canada' as a country.  Build the query as if you
# do not know Canada's country id.  Hint: Remember you can have selects within select queries.
# Sort the results reverse alphabetically by city name.
select city from city where country_id=(select country_id from country where country='Canada')
order by city desc ;

#6.	Create a query that returns all films that either start with the letter ‘A’, or end with the
# letter ‘t’. Suppress any duplicate film names and sort the results in reverse alphabetical order.
select distinct title from film where title like 'A%' or title like '%t' order by title desc ;

#7.	Create a query that returns each customer ID and the count of payments they have made.
# Make sure you call the second column "count". Sort results by count in reverse order.
select customer_id,count(all amount) as Count from payment group by customer_id order by Count desc ;

#8.	Create a query that lists the CustomerId and maximum paid by each customer.  Then modify the
# query to display only those records whose amount was more than $5.99. Sort from highest total
# to lowest total, then sort by CustomerId from lowest to highest.
select customer_id,max(distinct amount) as Max from payment where amount>5.99 group by customer_id
order by Max desc,customer_id asc ;

#9.	Create a query that returns the CustomerId and the total number of items for each rental.
# Sort the results from the most number of items rented to least number of items rented.
# Note: this is using a different table from the previous two queries.
select customer_id,count(distinct rental_id) as Count from rental group by customer_id
order by Count desc ;

#10.	Create a query that returns all customers who have payments with a total over $7.00
# and were served by the staff with an ID of 1. Sort the results by customer ID from
#highest to lowest, then amount lowest to highest.
select customer_id,amount from payment where amount>7.00 and staff_id='1' order by customer_id desc,
amount asc ;

#11.	Create a query that lists the CategoryId and count of films (name this column Cat_Count).
# Restrict your results to only those categories with more than 60 films. Sort the results by the
# Category Count in descending order.
select category_id,count(all film_id) as Cat_Count from film_category group by category_id
having Cat_Count>60 order by Cat_Count desc ;

#12.	Create a query that returns the names of the films with Actor ID 107.  Sort the movie
# titles alphabetically.
select title from film where film_id in (select film_id from film_actor where actor_id='107')
order by title ;

#13.	Create a query that only lists the actor ids from films that contain more than 36 actors.
# Sort from largest to smallest amount of actors in film.
select actor_id,count(distinct film_id) as film_count from film_actor group by actor_id
having film_count>36 order by film_count desc  ;

#14.	Create a query that displays the total of films are not in inventory. Call the single
# column "Total Not In Inventory".
select count(film_id) from film where not exists(select film_id from inventory
where inventory.film_id=film.film_id) ;

#15.	Create a query that lists all of the film ids for any movies that contain the actor
# with the title "RIP CRAWFORD". Do not use the actor's ID in the query. Display Film IDs
# in Ascending order.
select film_id from film_actor where actor_id=(select actor_id from actor where first_name='Rip'
and last_name='Crawford') order by film_id asc ;