use classicmodels;
delimiter //
Create procedure findAllCustomers()
begin
select * from customers;
end //
delimiter ;

delimiter //
drop procedure if exists findAllCustomers//

delimiter //
CREATE PROCEDURE findAllCustomers()

BEGIN

SELECT * FROM customers where customerNumber = 175;

END //