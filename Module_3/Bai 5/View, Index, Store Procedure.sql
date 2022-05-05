create database demo;
use demo;
create table products(
id int primary key,
product_code varchar(50),
product_name varchar(50),
product_price float,
product_amount int,
product_description varchar(500),
product_status boolean
);

INSERT INTO `demo`.`products` (`id`, `product_code`, `product_name`, `product_price`, `product_amount`, `product_description`, `product_status`) VALUES ('1', '1', 'mot', '1000', '10', 'nhat', 1);
INSERT INTO `demo`.`products` (`id`, `product_code`, `product_name`, `product_price`, `product_amount`, `product_description`, `product_status`) VALUES ('2', '2', 'hai', '2000', '20', 'nhi', 0);
INSERT INTO `demo`.`products` (`id`, `product_code`, `product_name`, `product_price`, `product_amount`, `product_description`, `product_status`) VALUES ('3', '3', 'ba', '3000', '30', 'tam', 1);

-- Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục)
select * from products;
create 	index index_product_code
on products(product_code);

-- Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)
create index index_product_name_price
on products(product_name,product_price);

-- Sử dụng câu lệnh EXPLAIN để biết được câu lệnh SQL của bạn thực thi như nào
explain select * from products where product_code = 1;

-- Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products.
create view bai_tap as
select product_code, product_name, product_price, product_status 
from products;

-- Tiến hành sửa đổi view

create or replace view bai_tap as
select product_code, product_name, product_price
from products;

-- Tiến hành xoá view
drop view bai_tap;

-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product

delimiter //
create procedure get_all()
begin
select * from products;
end //
delimiter ;
call get_all();

-- Tạo store procedure thêm một sản phẩm mới
delimiter //
create procedure add_product(in id int, product_code varchar(50),
product_name varchar(50),
product_price float,
product_amount int,
product_description varchar(500),
product_status boolean)
begin
INSERT INTO `demo`.`products` (`id`, `product_code`, `product_name`, `product_price`, `product_amount`, `product_description`, `product_status`) VALUES (id, product_code, product_name, product_price, product_amount, product_description, product_status);
end //
delimiter ;
call add_product('4', '1', 'mot', '1000', '10', 'nhat', 1);
select * from products;

-- Tạo store procedure sửa thông tin sản phẩm theo id
delimiter //
create procedure update_product(in id int, in product_code varchar(50),
in product_name varchar(50),
in product_price float,
in product_amount int,
in product_description varchar(500),
in product_status boolean)
begin
update products 
set 
product_code =product_code , product_name = product_name, product_price = product_price, product_amount = product_amount , product_description = product_description, product_status = product_status
where id =id;
end //

-- ĐANG KO CHẠY Tạo store procedure xoá sản phẩm theo id
delimiter // ;
create procedure delete_product(in id int)
begin
delete from products
where products.id = id
end //
delimiter ; //