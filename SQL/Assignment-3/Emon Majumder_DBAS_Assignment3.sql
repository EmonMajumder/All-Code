use sakila;

#1.	Create a query that displays a list of Sakila stores (IDs) and the first/last name of each store's manager.
select store_id,first_name,last_name from staff ;

#2.	Create a query that displays a list of all cities and their associated countries, alphabetized by country.
select city,country from city
inner join country on city.country_id=country.country_id order by country asc ;

#3.	Create a query that displays the names of every actor and the number of movies they are in. Display the
# actor's last and first names and sort from most movies to least. Rename columns as indicated.
select last_name as LastName,first_name as FirstName,count(distinct film_id) as Number_of_Movies from actor
inner join film_actor on actor.actor_id = film_actor.actor_id
group by actor.actor_id order by Number_of_Movies desc ;

#4.	Create a query that displays a list of all customers who currently reside in Japan.
# Show their last and first names, city and country, sorted by city of residence,
# then by customer last name, first name.
select customer_id,last_name,first_name,city,country from customer
inner join address on customer.address_id=address.address_id
inner join city on address.city_id=city.city_id
inner join country on city.country_id = country.country_id
where country='Japan' order by city,last_name,first_name asc ;

#5.	Create a query that lists all G-rated movies in which actress Audrey Olivier has appeared.
# Display the actress' name in a single field named ActorName. Rename other columns as indicated.
select concat(last_name,',',' ',first_name) as ActorName,title as Movie,rating as MovieRating from actor
inner join film_actor on actor.actor_id = film_actor.actor_id
inner join film on film_actor.film_id = film.film_id
where rating='G' and (last_name='Olivier' and first_name='Audrey')
order by Movie asc ;
#6.	Create a query that displays the total profits per staff member for rentals returned in July of 2005.
# Rename columns as indicated.
select first_name as FirstName,last_name as LastName,sum(all amount) as
'Profits on Returned Movies- july 2005' from payment
inner join staff on payment.staff_id = staff.staff_id
inner join rental on payment.rental_id = rental.rental_id
where return_date between '2005-07-01' and '2005-07-31'
group by payment.staff_id ;

#7.	Create a query that displays which and how many movies are available for rental from store #1,
# that have an R  rating, are 2 hours or less in run time, and that include deleted scenes as a
# special feature. Sort by movie length, from shortest to longest. Rename the Available column as indicated.
select title,count(all inventory_id),rating,length,special_features from film
inner join inventory on film.film_id = inventory.film_id
where store_id='1' and rating='R' and length<=120 and special_features like '%Deleted Scenes%'
group by title order by length asc ;

#8.	Create a query that displays the top five actors that have made the most rental profits for our
# store, sorted from largest profit to smallest. Rename columns as indicated.
select last_name as LastName,first_name as FirstName,sum(all amount) as 'Total profit by Actor' from film
inner join film_actor on film.film_id = film_actor.film_id
inner join actor on film_actor.actor_id = actor.actor_id
inner  join inventory on film.film_id=inventory.film_id
inner join rental on inventory.inventory_id = rental.inventory_id
inner join payment on rental.rental_id = payment.rental_id
group by LastName,FirstName order by sum(all amount) desc limit 5;

#9.	Create a query that displays all movies from the Action or Comedy categories that were rented by
# Canadian customers, sorted by movie title. Display the name of the rented movie, its category,
# the customer's name as a single field and the country. Rename columns as indicated.
select title as MovieRented,name as Category,concat(first_name,' ',last_name) as Customer, country from film
inner join film_category on film.film_id = film_category.film_id
inner join category on film_category.category_id = category.category_id
inner join inventory on film.film_id = inventory.film_id
inner join rental on inventory.inventory_id = rental.inventory_id
inner join payment on rental.rental_id = payment.rental_id
inner join customer on payment.customer_id = customer.customer_id
inner join address on customer.address_id = address.address_id
inner join city on address.city_id = city.city_id
inner join country on city.country_id = country.country_id
where (name='Action' or name='Comedy') and country='Canada'
order by MovieRented asc ;

#10.	Create a query that displays how many movies were rented by customer Ruby Washington,
# listed by category. Display the customer's last and first names, the category and how many
# movies from each category were rented by this customer. Sort by category, then by customer
# last name. Rename columns as indicated.
select last_name as LastName,first_name as FirstName,name as Category,count(title) as Rented from film
inner join film_category on film.film_id = film_category.film_id
inner join category on film_category.category_id = category.category_id
inner join inventory on film.film_id = inventory.film_id
inner join rental on inventory.inventory_id = rental.inventory_id
inner join customer on rental.customer_id = customer.customer_id
where last_name='Washington' and first_name='Ruby'
group by Category order by Category,LastName asc ;
