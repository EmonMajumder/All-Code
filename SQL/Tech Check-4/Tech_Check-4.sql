use sakila;

select first_name, last_name from actor where last_name like 'G%' order by last_name asc ;

select name as "Language" from language order by name asc ;

select address,phone from address where district='California' order by phone ASC ;

select distinct rating from film order by rating ASC ;

select concat(first_name,last_name) as Name,username,password  from staff where first_name='Mike' and last_name='Hillyer'