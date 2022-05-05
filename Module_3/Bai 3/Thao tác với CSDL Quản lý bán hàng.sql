use quanlybanhang;
select * from `order`;
-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
select oid, odate, ototalprice from `order`;
-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
select customer.*,product.pname 
from customer
join 
-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào 
select customer.* 
from customer
where customer.cid not in
(
select cid 
from `order`
);
