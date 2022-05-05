use quanlybanhang;
-- Hiển thị các thông tin gồm oID, oDate, oPrice 
-- trong bảng Order
select id, ngay_dat, totalPrice
from `order`;

-- Hiển thị danh sách các khách hàng đã mua hàng
-- và danh sách sản phẩm được mua bởi các khách
select customer.*, product.pname
from customer
join `order` on customer.id = `order`.id_khach_hang
join order_detail on `order`.id = order_detail.order_id
join product on order_detail.product_id = product.id;

-- Hiển thị tên những khách hàng 
-- không mua bất kỳ một sản phẩm nào
select customer.*
from customer 
where customer.id not in
(
	select id_khach_hang
    from `order`
);

-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn 
-- giá một hóa đơn = tổng mặt hàng
-- Giá bán của từng loại được tính = odQTY*pPrice
select `order`.id, ngay_dat, sum(quantity * totalPrice) as `Gia hoa don` 
from `order` join order_detail
on `order`.id = order_detail.order_id
group by `order`.id;

