use classicmodels;
select * from customers where customername = 'Land Of Toys Inc.'; 
explain select * from customers where customername = 'Land Of Toys Inc.'; 
alter table customers add index idx_customerName(customername);
explain select * from customers where customername = 'Land Of Toys Inc.';
alter table customers add index idx_full_name(contactfirstname,contactlastname);
explain select * from customers where contactFirstName ='Jean' or contactFirstName = 'King';
alter table customers drop index idx_full_name;
