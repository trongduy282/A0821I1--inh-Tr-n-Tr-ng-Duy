create database casestudy;
use casestudy;
create table vi_tri(
ma_vi_tri int auto_increment primary key,
ten_vi_tri varchar(45)
);
create table trinh_do(
ma_trinh_do int auto_increment primary key,
ten_trinh_do varchar(45)
);
create table bo_phan(
ma_bo_phan int auto_increment primary key,
ten_bo_phan varchar(45)
);
create table nhan_vien(
ma_nhan_vien int auto_increment primary key,
ho_ten varchar(45),
ngay_sinh date,
so_cmnd varchar(45),
luong double,
so_dien_thoai varchar(45),
email varchar(45),
dia_chi varchar(45),
ma_vi_tri int,
ma_trinh_do int,
ma_bo_phan int,
foreign key (ma_vi_tri) references vi_tri(ma_vi_tri),
foreign key (ma_trinh_do) references trinh_do(ma_trinh_do),
foreign key (ma_bo_phan) references bo_phan(ma_bo_phan)
);
create table loai_khach(
ma_loai_khach int auto_increment primary key,
ten_loai_khach varchar(45)
);
create table khach_hang(
ma_khach_hang int auto_increment primary key,
ma_loai_khach int,
foreign key (ma_loai_khach) references loai_khach(ma_loai_khach),
ho_ten varchar(45),
ngay_sinh date,
gioi_tinh bit(1),
so_cmnd varchar(45),
so_dien_thoai varchar(45),
email varchar(45),
dia_chi varchar(45)
);
create table dich_vu_di_kem(
ma_dich_vu_di_kem int auto_increment primary key,
ten_dich_vu_di_kem varchar(45),
gia double,
don_vi varchar(10),
trang_thai varchar(45)
);
create table kieu_thue(
ma_kieu_thue int auto_increment primary key,
ten_kieu_thue varchar(45)
);
create table loai_dich_vu(
ma_loai_dich_vu int auto_increment primary key,
ten_loai_dich_vu varchar(45)
);
create table dich_vu(
ma_dich_vu int auto_increment primary key,
ten_dich_vu varchar(45),
dien_tich int,
chi_phi_thue double,
so_nguoi_toi_da int,
ma_kieu_thue int,
ma_loai_dich_vu int,
foreign key (ma_kieu_thue) references kieu_thue(ma_kieu_thue),
foreign key (ma_loai_dich_vu) references loai_dich_vu(ma_loai_dich_vu),
tieu_chuan_phong varchar(45),
mo_ta_tien_nghi_khac varchar(45),
dien_tich_ho_boi double,
so_tang int
);

create table hop_dong(
ma_hop_dong int auto_increment primary key,
ngay_lam_hop_dong datetime,
ngay_ket_thuc datetime,
tien_dat_coc double,
ma_nhan_vien int,
ma_khach_hang int,
ma_dich_vu int,
foreign key (ma_nhan_vien) references nhan_vien(ma_nhan_vien),
foreign key (ma_khach_hang) references khach_hang(ma_khach_hang),
foreign key (ma_dich_vu) references dich_vu(ma_dich_vu)
);
create table hop_dong_chi_tiet(
ma_hop_dong_chi_tiet int auto_increment primary key,
ma_hop_dong int,
ma_dich_vu_di_kem int,
foreign key (ma_hop_dong) references hop_dong(ma_hop_dong),
foreign key (ma_dich_vu_di_kem) references dich_vu_di_kem(ma_dich_vu_di_kem),
so_luong int
);
-- thêm mới thông tin
insert into vi_tri(ten_vi_tri) values ("Quản Lý"),("Nhân Viên");
insert into trinh_do(ten_trinh_do) values ("Trung Cấp"),("Cao Đẳng"),("Đại Học"),("Sau Đại Học");
insert into bo_phan(ten_bo_phan) values ("Sale-Marketing"),("Hành chính"),("Phục vụ"),("Quản lý");
insert into nhan_vien(ho_ten,ngay_sinh,so_cmnd,luong,so_dien_thoai,email,dia_chi,ma_vi_tri,ma_trinh_do,ma_bo_phan) 
values ("Nguyễn Văn An","1970-11-07","456231786",10000000,"0901234121","annguyen@gmail.com","295 Nguyễn Tất Thành, Đà Nẵng",1,3,1),
("Lê Văn Bình","1997-04-09","654231234",7000000,"0934212314","binhlv@gmail.com","22 Yên Bái, Đà Nẵng",1,2,2),
("Hồ Thị Yến","1995-12-12","999231723",14000000,"0412352315","thiyen@gmail.com","K234/11 Điện Biên Phủ, Gia Lai",1,3,2),
("Võ Công Toản","1980-04-04","123231365",17000000,"0374443232","toan0404@gmail.com","77 Hoàng Diệu, Quảng Trị",1,4,4),
("Nguyễn Bỉnh Phát","1999-12-09","454363232",6000000,"0902341231","phatphat@gmail.com","43 Yên Bái, Đà Nẵng",2,1,1),
("Khúc Nguyễn An Nghi","2000-11-08","964542311",7000000,"0978653213","annghi20@gmail.com","294 Nguyễn Tất Thành, Đà Nẵng",2,2,3),
("Nguyễn Hữu Hà","1993-01-01","534323231",8000000,"0941234553","nhh0101@gmail.com","4 Nguyễn Chí Thanh, Huế",2,3,2),
("Nguyễn Hà Đông","1989-09-03","234414123",9000000,"0642123111","donghanguyen@gmail.com","111 Hùng Vương, Hà Nội",2,4,4),
("Tòng Hoang","1982-09-03","256781231",6000000,"0245144444","hoangtong@gmail.com","213 Hàm Nghi, Đà Nẵng",2,4,4),
("Nguyễn Công Đạo","1994-01-08","755434343",8000000,"0988767111","nguyencongdao12@gmail.com","6 Hoà Khánh, Đồng Nai",2,3,2);
insert into loai_khach(ten_loai_khach) values ("Diamond"),("Platinium"),("Gold"),("Silver"),("Member");
insert into khach_hang(ho_ten,ngay_sinh,gioi_tinh,so_cmnd,so_dien_thoai,email,dia_chi,ma_loai_khach)
values ("Nguyễn Thị Hào","1970-11-07",0,643431213,"0945423362","thihao07@gmail.com","23 Nguyễn Hoàng, Đà Nẵng",5),
("Phạm Xuân Diệu","1992-08-08",1,865342123,"0954333333","xuandieu92@gmail.com","K77/22 Thái Phiên, Quảng Trị",3),
("Trương Đình Nghệ","1990-02-27",1,488645199,"0373213122","nghenhan2702@gmail.com","K323/12 Ông Ích Khiêm, Vinh",1),
("Dương Văn Quan","1981-07-08",1,543432111,"0490039241","duongquan@gmail.com","K453/12 Lê Lợi, Đà Nẵng",1),
("Hoàng Trần Nhi Nhi","1995-12-09",0,795453345,"0312345678","nhinhi123@gmail.com","224 Lý Thái Tổ, Gia Lai",4),
("Tôn Nữ Mộc Châu","2005-12-06",0,732434215,"0988888844","tonnuchau@gmail.com","37 Yên Thế, Đà Nẵng",4),
("Nguyễn Mỹ Kim","1984-04-08",0,856453123,"0912345698","kimcuong84@gmail.com","K123/45 Lê Lợi, Hồ Chí Minh",1),
("Nguyễn Thị Hào","1999-04-08",0,965656433,"0763212345","haohao99@gmail.com","55 Nguyễn Văn Linh, Kon Tum",3),
("Trần Đại Danh","1994-07-01",1,432341235,"0643343433","danhhai99@gmail.com","24 Lý Thường Kiệt, Quảng Ngãi",1),
("Nguyễn Tâm Đắc","1989-07-01",1,344343432,"0987654321","dactam@gmail.com","22 Ngô Quyền, Đà Nẵng",2)
;
insert into kieu_thue(ten_kieu_thue) values ("year"),("month"),("day"),("hour");
insert into loai_dich_vu(ten_loai_dich_vu) values ("Villa"),("House"),("Room");
insert into dich_vu(ten_dich_vu,dien_tich,chi_phi_thue,so_nguoi_toi_da,tieu_chuan_phong,mo_ta_tien_nghi_khac,dien_tich_ho_boi,so_tang,ma_kieu_thue,ma_loai_dich_vu) 
values ("Villa Beach Front",25000,10000000,10,"vip","Có hồ bơi",500,4,3,1),
("House Princess 01",14000,5000000,7,"vip","Có thêm bếp nướng",null,3,2,2),
("Room Twin 01",5000,1000000,2,"normal","Có tivi",null,null,4,3),
("Villa No Beach Front",22000,9000000,8,"normal","Có hồ bơi",300,3,3,1),
("House Princess 02",10000,4000000,5,"normal","Có thêm bếp nướng",null,2,3,2),
("Room Twin 02",3000,900000,2,"normal","Có tivi",null,null,4,3);
insert into dich_vu_di_kem(ten_dich_vu_di_kem,gia,don_vi,trang_thai) 
values ("Karaoke",10000,"giờ","tiện nghi, hiện tại"),
("Thuê xe máy",10000,"chiếc","hỏng 1 xe"),
("Thuê xe đạp",20000,"chiếc","tốt"),
("Buffet buổi sáng",15000,"suất","đầy đủ đồ ăn, tráng miệng"),
("Buffet buổi trưa",90000,"suất","đầy đủ đồ ăn, tráng miệng"),
("Buffet buổi tối",16000,"suất","đầy đủ đồ ăn, tráng miệng")
;
insert into hop_dong(ngay_lam_hop_dong,ngay_ket_thuc,tien_dat_coc,ma_nhan_vien,ma_khach_hang,ma_dich_vu) 
values ("2020-12-08","2020-12-08",0,3,1,3),
("2020-07-14","2020-07-21",200000,7,3,1),
("2021-03-15","2021-03-17",50000,3,4,2),
("2021-01-14","2021-01-18",100000,7,5,5),
("2021-07-14","2021-07-15",0,7,2,6),
("2021-06-01","2021-06-03",0,7,7,6),
("2021-09-02","2021-09-05",100000,7,4,4),
("2021-06-17","2021-06-18",150000,3,4,1),
("2020-11-19","2020-11-19",0,3,4,3),
("2021-04-12","2021-04-14",0,10,3,5),
("2021-04-25","2021-04-25",0,2,2,1),
("2021-05-25","2021-05-27",0,7,10,1)
;
insert into hop_dong_chi_tiet(so_luong,ma_hop_dong,ma_dich_vu_di_kem) 
values (5,2,4),
(8,2,5),
(15,2,6),
(1,3,1),
(11,3,2),
(1,1,3),
(2,1,2),
(2,12,2)
;
-- Câu 2
select * from nhan_vien
where (ho_ten like "H%" or  ho_ten like "T%" Or ho_ten like "K%") and char_length(ho_ten)<=15;
-- Câu 3
select * from khach_hang
where (dia_chi like "%Đà Nẵng%" or dia_chi like "%Quảng Trị%") and (YEAR(CURDATE()) -year(ngay_sinh)) between 18 and 50;

-- Câu 4
select khach_hang.ma_khach_hang, ho_ten, count(khach_hang.ma_khach_hang) from khach_hang
join hop_dong on khach_hang.ma_khach_hang =hop_dong.ma_khach_hang
join loai_khach on loai_khach.ma_loai_khach = khach_hang.ma_loai_khach
where ten_loai_khach = "Diamond"
group by khach_hang.ma_khach_hang,ho_ten
order by count(ma_khach_hang) asc;

-- Câu 5 ĐÃ SỬA
-- ma_khach_hang, ho_ten: BẢNG KHACH HÀNG//
--  ten_loai_khach: BẢNG LOẠI KHÁCH//
-- ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, : BẢNG HỢP ĐỒNG//
-- ten_dich_vu: BẢNG DỊCH VỤ//
-- tong_tien : BẢNG dich_vu_di_kem, hop_dong_chi_tiet
-- tổng tiền được tính theo công thức như sau: Chi Phí Thuê + Số Lượng * Giá
-- chi phí thuê: BẢNG DỊCH VỤ//
select khach_hang.ma_khach_hang, ho_ten, ten_loai_khach, hop_dong.ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, 
(chi_phi_thue + ifnull((so_luong*gia),0)) as tong_tien
from khach_hang
left join loai_khach on loai_khach.ma_loai_khach = khach_hang.ma_loai_khach
left join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
left join dich_vu on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
left join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
left join dich_vu_di_kem on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
group by hop_dong.ma_hop_dong;

-- CÂU 6 ĐÃ SỬA
select dich_vu.ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu from dich_vu 
join loai_dich_vu on loai_dich_vu.ma_loai_dich_vu = dich_vu.ma_loai_dich_vu
-- join hop_dong on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
where dich_vu.ma_dich_vu not in 
(select hop_dong.ma_dich_vu from hop_dong
where ngay_lam_hop_dong between "2021-01-01" and "2021-03-31"
);

-- Câu 7 ĐÃ SỬA
-- ma_dich_vu, ten_dich_vu,dien_tich,so_nguoi_toi_da, chi_phi_thue : BẢNG DỊCH VỤ
-- ten_loai_dich_vu : BẢNG LOẠI DỊCH VỤ
select dich_vu.ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu from dich_vu 
join loai_dich_vu on loai_dich_vu.ma_loai_dich_vu = dich_vu.ma_loai_dich_vu
-- join hop_dong on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
where dich_vu.ma_dich_vu in 
(select hop_dong.ma_dich_vu from hop_dong
where ngay_lam_hop_dong between "2020-01-01" and "2020-12-31"
)
and dich_vu.ma_dich_vu not in (select hop_dong.ma_dich_vu from hop_dong
where ngay_lam_hop_dong between "2021-01-01" and "2021-12-31"
);

-- CÂU 8 KHÔNG BIẾT LÀM
select distinct ho_ten from khach_hang;

-- CÂU 9 ĐÃ SỬA
select month(ngay_lam_hop_dong) as thang, count(ma_khach_hang) from hop_dong 
where year(hop_dong.ngay_lam_hop_dong) =2021
group by month(ngay_lam_hop_dong);
-- CÂU 10 
-- ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, : BẢNG HỢP ĐÔNG
-- so_luong_dich_vu_di_kem : BẢNG DỊCH VỤ ĐI KÈM
-- THÊM HỢP ĐÔNG CHI TIẾT
select hop_dong.ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, sum(so_luong) from hop_dong
join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
join dich_vu_di_kem on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
group by hop_dong_chi_tiet.ma_hop_dong;

-- CÂU 11
-- dịch vụ đi kèm: bảng dịch vụ đi kèm ĐI VỚI hợp đồng chi tiết, ĐI VỚI hợp đồng
-- khách hàng: bảng khách hàng
-- loại khách: bảng loại khách
select dich_vu_di_kem.ma_dich_vu_di_kem,ten_dich_vu_di_kem,gia, don_vi, trang_thai, ten_loai_khach,dia_chi from dich_vu_di_kem
join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
join hop_dong on hop_dong.ma_hop_dong= hop_dong_chi_tiet.ma_hop_dong
join khach_hang on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
join loai_khach on loai_khach.ma_loai_khach =khach_hang.ma_loai_khach
where (ten_loai_khach = "Diamond" and dia_chi like "%Vinh%") or (ten_loai_khach = "Diamond" and dia_chi like "%Quảng Ngãi%");

-- CÂU 12 ĐÃ SỬA
-- ma_hop_dong hop_dong//
-- ho_ten bảng nhân viên//
-- ho_ten bảng, so_dien_thoai bảng khách hàng//
--  ten_dich_vu bảng dịch vụ//
-- so_luong_dich_vu_di_kem bảng hop_dong_chi_tiet//(được tính dựa trên việc sum so_luong ở dich_vu_di_kem), 
-- tien_dat_coc bảng hop_dong của tất cả các dịch vụ đã từng được khách hàng đặt
select hop_dong.ma_hop_dong, nhan_vien.ho_ten as ten_nhan_vien,khach_hang.ho_ten as ten_khach_hang, khach_hang.so_dien_thoai, ten_dich_vu, sum(so_luong) as so_luong_dich_vu_di_kem, tien_dat_coc from hop_dong
left join nhan_vien on nhan_vien.ma_nhan_vien = hop_dong.ma_nhan_vien
left join khach_hang on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
left join dich_vu on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
left join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
where dich_vu.ma_dich_vu in (select hop_dong.ma_dich_vu from hop_dong where ngay_lam_hop_dong between "2020-10-01" and "2020-12-31")
and
dich_vu.ma_dich_vu not in (select hop_dong.ma_dich_vu from hop_dong
where ngay_lam_hop_dong between "2021-01-01" and "2021-06-30")
group by hop_dong.ma_hop_dong;

-- CÂU 13 ĐÃ SỬA
-- các bảng: khach_hang, hop_dong//, hop_dong_chi_tiet//, dich_vu_di_kem//
select dich_vu_di_kem.ma_dich_vu_di_kem, ten_dich_vu_di_kem, sum(so_luong) from dich_vu_di_kem
join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
-- join hop_dong on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
-- join khach_hang on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
group by ma_dich_vu_di_kem
having sum(so_luong)>=
(select max(so_luong) from dich_vu_di_kem
join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_dich_vu_di_kem= dich_vu_di_kem.ma_dich_vu_di_kem);

-- CÂU 14
select ten_dich_vu_di_kem,gia, hop_dong.ma_hop_dong,ten_loai_dich_vu, count(so_luong) as so_lan_su_dung from dich_vu_di_kem
join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
join hop_dong on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
join khach_hang on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
join dich_vu on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
join loai_dich_vu on loai_dich_vu.ma_loai_dich_vu = dich_vu.ma_loai_dich_vu
group by dich_vu_di_kem.ma_dich_vu_di_kem
having so_lan_su_dung= 1;

-- CÂU 15
-- BẢNG: nhan_vien, trinh_do, bo_phan, hop_dong
select nhan_vien.ma_nhan_vien,nhan_vien.ho_ten, ten_trinh_do,ten_bo_phan,nhan_vien.so_dien_thoai,nhan_vien.dia_chi from nhan_vien
join trinh_do on trinh_do.ma_trinh_do = nhan_vien.ma_trinh_do
join bo_phan on bo_phan.ma_bo_phan = nhan_vien.ma_bo_phan
join hop_dong on hop_dong.ma_nhan_vien = nhan_vien.ma_nhan_vien
group by nhan_vien.ma_nhan_vien
having count(hop_dong.ma_nhan_vien)<=3;

-- CÂU 16 ĐÃ SỬA Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2019 đến năm 2021.
-- bảng: nhân viên,hợp động
select nhan_vien.ma_nhan_vien,nhan_vien.ho_ten from nhan_vien
join hop_dong on hop_dong.ma_nhan_vien= nhan_vien.ma_nhan_vien
group by nhan_vien.ma_nhan_vien
having nhan_vien.ma_nhan_vien not in (select nhan_vien.ma_nhan_vien from nhan_vien 
join hop_dong on hop_dong.ma_nhan_vien=nhan_vien.ma_nhan_vien
where hop_dong.ngay_lam_hop_dong between "2019-01-01" and "2021-01-01"
group by ma_nhan_vien
);

-- CÂU 17 ĐÃ SỬA
-- bảng: khach_hang, dich_vu_di_kem,dich_vu,hop_dong, loai_khach
select khach_hang.ma_khach_hang, ho_ten, loai_khach.ma_loai_khach, (chi_phi_thue + ifnull((so_luong*gia),0)) as tong_tien from khach_hang
left join hop_dong on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
left join loai_khach on loai_khach.ma_loai_khach = khach_hang.ma_loai_khach
left join dich_vu on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
left join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_hop_dong= hop_dong.ma_hop_dong
left join dich_vu_di_kem on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
where year(ngay_lam_hop_dong) =2021 and (chi_phi_thue + ifnull((so_luong*gia),0)) >=10000000 and khach_hang.ma_loai_khach =2
group by khach_hang.ma_khach_hang;
update khach_hang set ma_loai_khach = 1 where khach_hang.ma_khach_hang in( 
 select * from (select khach_hang.ma_khach_hang from khach_hang
left join hop_dong on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
left join loai_khach on loai_khach.ma_loai_khach = khach_hang.ma_loai_khach
left join dich_vu on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
left join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_hop_dong= hop_dong.ma_hop_dong
left join dich_vu_di_kem on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
where year(ngay_lam_hop_dong) =2021 and (chi_phi_thue + ifnull((so_luong*gia),0)) >=10000000 and khach_hang.ma_loai_khach =2
group by khach_hang.ma_khach_hang) as bang_1
);

-- CÂU 18
-- bảng khach_hang
-- bảng hop_dong
select khach_hang.ma_khach_hang, khach_hang.ho_ten from khach_hang
join hop_dong on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
where ngay_lam_hop_dong <= "2020-12-31";

-- CÂU 19
select hop_dong_chi_tiet.ma_dich_vu_di_kem, ten_dich_vu_di_kem,so_luong,ngay_lam_hop_dong from dich_vu_di_kem
join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
join hop_dong where hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
group by hop_dong_chi_tiet.ma_dich_vu_di_kem
having hop_dong_chi_tiet.so_luong>10 and year(ngay_lam_hop_dong)="2020";

-- CÂU 20
select ma_khach_hang, ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi from khach_hang
union
select ma_nhan_vien, ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi from nhan_vien;

-- CÂU 21
create view v_nhan_vien as 
select ho_ten, nhan_vien.ma_nhan_vien, ngay_sinh, so_cmnd, luong,so_dien_thoai, email,dia_chi,ma_vi_tri, ma_trinh_do,ma_bo_phan from nhan_vien
join hop_dong on hop_dong.ma_nhan_vien = nhan_vien.ma_nhan_vien
where dia_chi like "%Hải Châu%" and ngay_lam_hop_dong = "2019-12-12";

-- CÂU 22 đề bị điên hả, có cái nào hiện ra cái view đâu mà thay đổi

-- CÂU 23 sp_xoa_khach_hang 

delimiter //
create procedure xoa_khach_hang( in ma_khach_hang int)
begin
	 delete from khach_hang
    where ma_khach_hang = xoa_khach_hang;
end;
// delimiter ;
-- CÂU 24
