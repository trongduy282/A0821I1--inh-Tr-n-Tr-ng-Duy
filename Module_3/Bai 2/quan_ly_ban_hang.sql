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

INSERT INTO `quan_ly_ban_hang`.`order` (`o_id`, `c_id`, `o_date`) VALUES ('1', '1', '2006-03-21');
INSERT INTO `quan_ly_ban_hang`.`order` (`o_id`, `c_id`, `o_date`) VALUES ('2', '2', '2006-03-23');
INSERT INTO `quan_ly_ban_hang`.`order` (`o_id`, `c_id`, `o_date`) VALUES ('3', '1', '2006-03-16');

INSERT INTO `quan_ly_ban_hang`.`product` (`p_id`, `p_name`, `p_price`) VALUES ('1', 'May Giat', '3');
INSERT INTO `quan_ly_ban_hang`.`product` (`p_id`, `p_name`, `p_price`) VALUES ('2', 'Tu Lanh', '5');
INSERT INTO `quan_ly_ban_hang`.`product` (`p_id`, `p_name`, `p_price`) VALUES ('3', 'Dieu Hoa', '7');
INSERT INTO `quan_ly_ban_hang`.`product` (`p_id`, `p_name`, `p_price`) VALUES ('4', 'Quat', '1');
INSERT INTO `quan_ly_ban_hang`.`product` (`p_id`, `p_name`, `p_price`) VALUES ('5', 'Bep Dien', '2');

INSERT INTO `quan_ly_ban_hang`.`order_detail` (`o_id`, `p_id`, `od_qty`) VALUES ('1', '1', '3');
INSERT INTO `quan_ly_ban_hang`.`order_detail` (`o_id`, `p_id`, `od_qty`) VALUES ('1', '3', '7');
INSERT INTO `quan_ly_ban_hang`.`order_detail` (`o_id`, `p_id`, `od_qty`) VALUES ('1', '4', '2');
INSERT INTO `quan_ly_ban_hang`.`order_detail` (`o_id`, `p_id`, `od_qty`) VALUES ('2', '1', '1');
INSERT INTO `quan_ly_ban_hang`.`order_detail` (`o_id`, `p_id`, `od_qty`) VALUES ('3', '1', '8');
INSERT INTO `quan_ly_ban_hang`.`order_detail` (`o_id`, `p_id`, `od_qty`) VALUES ('2', '5', '4');
INSERT INTO `quan_ly_ban_hang`.`order_detail` (`o_id`, `p_id`, `od_qty`) VALUES ('2', '3', '3');

-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
select o_id,o_date, o_total_price from `order`;

-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
select c_name, p_name from customer
join `order` on customer.c_id = `order`.c_id
join order_detail on `order`.o_id = order_detail.o_id
join product on product.p_id = order_detail.p_id;


-- CÂU NI ĐANG SAI Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
select c_name from customer
join `order` on customer.c_id = `order`.c_id
join order_detail on `order`.o_id = order_detail.o_id
where customer.c_id <>  `order`.c_id;

-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn. Giá bán của từng loại được tính = odQTY*pPrice)
select `order`.o_id, o_date, sum(p_price*od_qty) as hoa_don from `order`
join order_detail on order_detail.o_id = `order`.o_id
join product on product.p_id = order_detail.p_id
group by `order`.o_id;