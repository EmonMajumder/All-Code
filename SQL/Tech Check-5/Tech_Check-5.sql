use sakila;

select film_id, title, name as Language from film
inner join language on film.language_id=language.language_id
where rating ='PG-13';

select customer.customer_id, sum(all amount) as Total_Amount from customer
inner join rental on customer.customer_id = rental.customer_id
inner join payment on rental.rental_id = payment.rental_id
where customer.customer_id=47 and month(rental_date) = 8 group by payment.customer_id;

select staff.staff_id,last_name,count(all amount) as number_of_payment from staff
inner join payment on staff.staff_id = payment.staff_id
group by staff.staff_id;

select first_name,last_name,title,name from actor
inner join film_actor on actor.actor_id = film_actor.actor_id
inner join film on film_actor.film_id = film.film_id
inner join film_category on film.film_id = film_category.film_id
inner join category on film_category.category_id = category.category_id
where name='Animation' order by last_name,title asc;

select concat(first_name,' ',last_name) as FULL_NAME,address,city, country from customer
inner join address on customer.address_id = address.address_id
inner join city on address.city_id = city.city_id
inner join country on city.country_id = country.country_id
where country='Germany' order by city desc;
