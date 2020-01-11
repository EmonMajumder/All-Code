use sakila;

select last_name,first_name from actor where last_name like 'G%' order by first_name asc ;

select name as "Language" from language order by name asc ;

select address,phone from address where district='California' order by phone desc ;

select distinct rating from film order by rating ASC ;

select first_name,last_name,username,password  from staff where first_name='Mike' and last_name='Hillyer'