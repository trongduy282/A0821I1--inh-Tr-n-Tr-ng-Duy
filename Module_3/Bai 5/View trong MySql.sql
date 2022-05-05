use classicmodels;
create view customer_views as
select customerNumber, customerName, phone
from customers;
select * from customer_views;
create or replace view customer_views as
select customerNumber, customerName, contactFirstname, contactLastname, phone
from customers
where city ='Nantes';
select * from customer_views;
drop view customer_views;
