use sakila;

#Number of films rented by 2 different staff
select concat(first_name,' ',last_name) as Full_Name,count(distinct film_id) as Number_of_Films from staff
inner join inventory on staff.store_id=inventory.store_id group by Full_Name ;

#Names of movies done by different actors
select concat(first_name,' ',last_name) as Full_Name,title from actor
inner join film_actor on actor.actor_id=film_actor.actor_id
inner join film on film_actor.film_id=film.film_id
order by Full_Name asc ;

#Gives the number of customers from different countries.
select country,count(concat(first_name,' ',last_name)) as Number_of_Customers from customer
inner join address on customer.address_id=address.address_id
inner join city on address.city_id=city.city_id
inner join country on city.country_id = country.country_id
group by country order by country asc ;

#Number of films in different rating for different Category
select name as Category_Name,rating,count(title) as Total_Film from category
inner join film_category on category.category_id=film_category.category_id
inner join film on film_category.film_id=film.film_id
group by Category_Name,rating order by Category_Name,rating,Total_Film desc ;

#Gives number of movies done by different actors in different category.
select concat(first_name,' ',last_name) as Full_Name,name,count(title) as Film_number from actor
inner join film_actor on actor.actor_id=film_actor.actor_id
inner join film on film_actor.film_id=film.film_id
inner join film_category on film.film_id=film_category.film_id
inner join category on film_category.category_id=category.category_id
group by Full_Name,name
order by Full_Name,name,title asc ;

#Total payment made by customers from different country
select country,sum(all amount) as Total_Amount from city
inner join country on city.country_id=country.country_id
inner join address on city.city_id=address.city_id
inner join customer on address.address_id=customer.address_id
inner join payment on customer.customer_id=payment.customer_id
group by country order by Total_Amount desc ;


