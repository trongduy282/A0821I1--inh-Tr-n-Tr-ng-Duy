create database quan_ly_ban_hang;
use quan_ly_ban_hang;
create table customer(
c_id int primary key,
c_name varchar(50),
c_age int
);
create table product(
p_id int primary key,
p_name varchar(50),
p_price float
);
create table `order`(
o_id int primary key,
c_id int,
o_date datetime,
o_total_price float,
foreign key (c_id) references customer(c_id)
);
alter table `order`
add foreign key (c_id) references customer(c_id);
create table order_detail(
o_id int,
p_id int,
od_qty int,
foreign key (o_id) references `order`(o_id),
foreign key (p_id) references product(p_id),
primary key (o_id,p_id)
);

-- [Bài tập] Thao tác với CSDL Quản lý bán hàng
INSERT INTO `quan_ly_ban_hang`.`customer` (`c_id`, `c_name`, `c_age`) VALUES ('1', 'Minh Quan', '10');
INSERT INTO `quan_ly_ban_hang`.`customer` (`c_id`, `c_name`, `c_age`) VALUES ('2', 'Ngoc Oanh', '20');
INSERT INTO `quan_ly_ban_hang`.`customer` (`c_id`, `c_name`, `c_age`) VALUES ('3', 'Hong Ha', '50');

