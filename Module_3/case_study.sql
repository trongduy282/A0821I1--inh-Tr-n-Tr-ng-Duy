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
-- th??m m???i th??ng tin
insert into vi_tri(ten_vi_tri) values ("Qu???n L??"),("Nh??n Vi??n");
insert into trinh_do(ten_trinh_do) values ("Trung C???p"),("Cao ?????ng"),("?????i H???c"),("Sau ?????i H???c");
insert into bo_phan(ten_bo_phan) values ("Sale-Marketing"),("H??nh ch??nh"),("Ph???c v???"),("Qu???n l??");
insert into nhan_vien(ho_ten,ngay_sinh,so_cmnd,luong,so_dien_thoai,email,dia_chi,ma_vi_tri,ma_trinh_do,ma_bo_phan) 
values ("Nguy???n V??n An","1970-11-07","456231786",10000000,"0901234121","annguyen@gmail.com","295 Nguy???n T???t Th??nh, ???? N???ng",1,3,1),
("L?? V??n B??nh","1997-04-09","654231234",7000000,"0934212314","binhlv@gmail.com","22 Y??n B??i, ???? N???ng",1,2,2),
("H??? Th??? Y???n","1995-12-12","999231723",14000000,"0412352315","thiyen@gmail.com","K234/11 ??i???n Bi??n Ph???, Gia Lai",1,3,2),
("V?? C??ng To???n","1980-04-04","123231365",17000000,"0374443232","toan0404@gmail.com","77 Ho??ng Di???u, Qu???ng Tr???",1,4,4),
("Nguy???n B???nh Ph??t","1999-12-09","454363232",6000000,"0902341231","phatphat@gmail.com","43 Y??n B??i, ???? N???ng",2,1,1),
("Kh??c Nguy???n An Nghi","2000-11-08","964542311",7000000,"0978653213","annghi20@gmail.com","294 Nguy???n T???t Th??nh, ???? N???ng",2,2,3),
("Nguy???n H???u H??","1993-01-01","534323231",8000000,"0941234553","nhh0101@gmail.com","4 Nguy???n Ch?? Thanh, Hu???",2,3,2),
("Nguy???n H?? ????ng","1989-09-03","234414123",9000000,"0642123111","donghanguyen@gmail.com","111 H??ng V????ng, H?? N???i",2,4,4),
("T??ng Hoang","1982-09-03","256781231",6000000,"0245144444","hoangtong@gmail.com","213 H??m Nghi, ???? N???ng",2,4,4),
("Nguy???n C??ng ?????o","1994-01-08","755434343",8000000,"0988767111","nguyencongdao12@gmail.com","6 Ho?? Kh??nh, ?????ng Nai",2,3,2);
insert into loai_khach(ten_loai_khach) values ("Diamond"),("Platinium"),("Gold"),("Silver"),("Member");
insert into khach_hang(ho_ten,ngay_sinh,gioi_tinh,so_cmnd,so_dien_thoai,email,dia_chi,ma_loai_khach)
values ("Nguy???n Th??? H??o","1970-11-07",0,643431213,"0945423362","thihao07@gmail.com","23 Nguy???n Ho??ng, ???? N???ng",5),
("Ph???m Xu??n Di???u","1992-08-08",1,865342123,"0954333333","xuandieu92@gmail.com","K77/22 Th??i Phi??n, Qu???ng Tr???",3),
("Tr????ng ????nh Ngh???","1990-02-27",1,488645199,"0373213122","nghenhan2702@gmail.com","K323/12 ??ng ??ch Khi??m, Vinh",1),
("D????ng V??n Quan","1981-07-08",1,543432111,"0490039241","duongquan@gmail.com","K453/12 L?? L???i, ???? N???ng",1),
("Ho??ng Tr???n Nhi Nhi","1995-12-09",0,795453345,"0312345678","nhinhi123@gmail.com","224 L?? Th??i T???, Gia Lai",4),
("T??n N??? M???c Ch??u","2005-12-06",0,732434215,"0988888844","tonnuchau@gmail.com","37 Y??n Th???, ???? N???ng",4),
("Nguy???n M??? Kim","1984-04-08",0,856453123,"0912345698","kimcuong84@gmail.com","K123/45 L?? L???i, H??? Ch?? Minh",1),
("Nguy???n Th??? H??o","1999-04-08",0,965656433,"0763212345","haohao99@gmail.com","55 Nguy???n V??n Linh, Kon Tum",3),
("Tr???n ?????i Danh","1994-07-01",1,432341235,"0643343433","danhhai99@gmail.com","24 L?? Th?????ng Ki???t, Qu???ng Ng??i",1),
("Nguy???n T??m ?????c","1989-07-01",1,344343432,"0987654321","dactam@gmail.com","22 Ng?? Quy???n, ???? N???ng",2)
;
insert into kieu_thue(ten_kieu_thue) values ("year"),("month"),("day"),("hour");
insert into loai_dich_vu(ten_loai_dich_vu) values ("Villa"),("House"),("Room");
insert into dich_vu(ten_dich_vu,dien_tich,chi_phi_thue,so_nguoi_toi_da,tieu_chuan_phong,mo_ta_tien_nghi_khac,dien_tich_ho_boi,so_tang,ma_kieu_thue,ma_loai_dich_vu) 
values ("Villa Beach Front",25000,10000000,10,"vip","C?? h??? b??i",500,4,3,1),
("House Princess 01",14000,5000000,7,"vip","C?? th??m b???p n?????ng",null,3,2,2),
("Room Twin 01",5000,1000000,2,"normal","C?? tivi",null,null,4,3),
("Villa No Beach Front",22000,9000000,8,"normal","C?? h??? b??i",300,3,3,1),
("House Princess 02",10000,4000000,5,"normal","C?? th??m b???p n?????ng",null,2,3,2),
("Room Twin 02",3000,900000,2,"normal","C?? tivi",null,null,4,3);
insert into dich_vu_di_kem(ten_dich_vu_di_kem,gia,don_vi,trang_thai) 
values ("Karaoke",10000,"gi???","ti???n nghi, hi???n t???i"),
("Thu?? xe m??y",10000,"chi???c","h???ng 1 xe"),
("Thu?? xe ?????p",20000,"chi???c","t???t"),
("Buffet bu???i s??ng",15000,"su???t","?????y ????? ????? ??n, tr??ng mi???ng"),
("Buffet bu???i tr??a",90000,"su???t","?????y ????? ????? ??n, tr??ng mi???ng"),
("Buffet bu???i t???i",16000,"su???t","?????y ????? ????? ??n, tr??ng mi???ng")
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
-- C??u 2
select * from nhan_vien
where (ho_ten like "H%" or  ho_ten like "T%" Or ho_ten like "K%") and char_length(ho_ten)<=15;
-- C??u 3
select * from khach_hang
where (dia_chi like "%???? N???ng%" or dia_chi like "%Qu???ng Tr???%") and (YEAR(CURDATE()) -year(ngay_sinh)) between 18 and 50;

-- C??u 4
select khach_hang.ma_khach_hang, ho_ten, count(khach_hang.ma_khach_hang) from khach_hang
join hop_dong on khach_hang.ma_khach_hang =hop_dong.ma_khach_hang
join loai_khach on loai_khach.ma_loai_khach = khach_hang.ma_loai_khach
where ten_loai_khach = "Diamond"
group by khach_hang.ma_khach_hang,ho_ten
order by count(ma_khach_hang) asc;

-- C??u 5 ???? S???A
-- ma_khach_hang, ho_ten: B???NG KHACH H??NG//
--  ten_loai_khach: B???NG LO???I KH??CH//
-- ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, : B???NG H???P ?????NG//
-- ten_dich_vu: B???NG D???CH V???//
-- tong_tien : B???NG dich_vu_di_kem, hop_dong_chi_tiet
-- t???ng ti???n ???????c t??nh theo c??ng th???c nh?? sau: Chi Ph?? Thu?? + S??? L?????ng * Gi??
-- chi ph?? thu??: B???NG D???CH V???//
select khach_hang.ma_khach_hang, ho_ten, ten_loai_khach, hop_dong.ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, 
(chi_phi_thue + ifnull((so_luong*gia),0)) as tong_tien
from khach_hang
left join loai_khach on loai_khach.ma_loai_khach = khach_hang.ma_loai_khach
left join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
left join dich_vu on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
left join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
left join dich_vu_di_kem on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
group by hop_dong.ma_hop_dong;

-- C??U 6 ???? S???A
select dich_vu.ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu from dich_vu 
join loai_dich_vu on loai_dich_vu.ma_loai_dich_vu = dich_vu.ma_loai_dich_vu
-- join hop_dong on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
where dich_vu.ma_dich_vu not in 
(select hop_dong.ma_dich_vu from hop_dong
where ngay_lam_hop_dong between "2021-01-01" and "2021-03-31"
);

-- C??u 7 ???? S???A
-- ma_dich_vu, ten_dich_vu,dien_tich,so_nguoi_toi_da, chi_phi_thue : B???NG D???CH V???
-- ten_loai_dich_vu : B???NG LO???I D???CH V???
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

-- C??U 8 KH??NG BI???T L??M
select distinct ho_ten from khach_hang;

-- C??U 9 ???? S???A
select month(ngay_lam_hop_dong) as thang, count(ma_khach_hang) from hop_dong 
where year(hop_dong.ngay_lam_hop_dong) =2021
group by month(ngay_lam_hop_dong);
-- C??U 10 
-- ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, : B???NG H???P ????NG
-- so_luong_dich_vu_di_kem : B???NG D???CH V??? ??I K??M
-- TH??M H???P ????NG CHI TI???T
select hop_dong.ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, sum(so_luong) from hop_dong
join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
join dich_vu_di_kem on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
group by hop_dong_chi_tiet.ma_hop_dong;

-- C??U 11
-- d???ch v??? ??i k??m: b???ng d???ch v??? ??i k??m ??I V???I h???p ?????ng chi ti???t, ??I V???I h???p ?????ng
-- kh??ch h??ng: b???ng kh??ch h??ng
-- lo???i kh??ch: b???ng lo???i kh??ch
select dich_vu_di_kem.ma_dich_vu_di_kem,ten_dich_vu_di_kem,gia, don_vi, trang_thai, ten_loai_khach,dia_chi from dich_vu_di_kem
join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
join hop_dong on hop_dong.ma_hop_dong= hop_dong_chi_tiet.ma_hop_dong
join khach_hang on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
join loai_khach on loai_khach.ma_loai_khach =khach_hang.ma_loai_khach
where (ten_loai_khach = "Diamond" and dia_chi like "%Vinh%") or (ten_loai_khach = "Diamond" and dia_chi like "%Qu???ng Ng??i%");

-- C??U 12 ???? S???A
-- ma_hop_dong hop_dong//
-- ho_ten b???ng nh??n vi??n//
-- ho_ten b???ng, so_dien_thoai b???ng kh??ch h??ng//
--  ten_dich_vu b???ng d???ch v???//
-- so_luong_dich_vu_di_kem b???ng hop_dong_chi_tiet//(???????c t??nh d???a tr??n vi???c sum so_luong ??? dich_vu_di_kem), 
-- tien_dat_coc b???ng hop_dong c???a t???t c??? c??c d???ch v??? ???? t???ng ???????c kh??ch h??ng ?????t
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

-- C??U 13 ???? S???A
-- c??c b???ng: khach_hang, hop_dong//, hop_dong_chi_tiet//, dich_vu_di_kem//
select dich_vu_di_kem.ma_dich_vu_di_kem, ten_dich_vu_di_kem, sum(so_luong) from dich_vu_di_kem
join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
-- join hop_dong on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
-- join khach_hang on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
group by ma_dich_vu_di_kem
having sum(so_luong)>=
(select max(so_luong) from dich_vu_di_kem
join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_dich_vu_di_kem= dich_vu_di_kem.ma_dich_vu_di_kem);

-- C??U 14
select ten_dich_vu_di_kem,gia, hop_dong.ma_hop_dong,ten_loai_dich_vu, count(so_luong) as so_lan_su_dung from dich_vu_di_kem
join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
join hop_dong on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
join khach_hang on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
join dich_vu on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
join loai_dich_vu on loai_dich_vu.ma_loai_dich_vu = dich_vu.ma_loai_dich_vu
group by dich_vu_di_kem.ma_dich_vu_di_kem
having so_lan_su_dung= 1;

-- C??U 15
-- B???NG: nhan_vien, trinh_do, bo_phan, hop_dong
select nhan_vien.ma_nhan_vien,nhan_vien.ho_ten, ten_trinh_do,ten_bo_phan,nhan_vien.so_dien_thoai,nhan_vien.dia_chi from nhan_vien
join trinh_do on trinh_do.ma_trinh_do = nhan_vien.ma_trinh_do
join bo_phan on bo_phan.ma_bo_phan = nhan_vien.ma_bo_phan
join hop_dong on hop_dong.ma_nhan_vien = nhan_vien.ma_nhan_vien
group by nhan_vien.ma_nhan_vien
having count(hop_dong.ma_nhan_vien)<=3;

-- C??U 16 ???? S???A X??a nh???ng Nh??n vi??n ch??a t???ng l???p ???????c h???p ?????ng n??o t??? n??m 2019 ?????n n??m 2021.
-- b???ng: nh??n vi??n,h???p ?????ng
select nhan_vien.ma_nhan_vien,nhan_vien.ho_ten from nhan_vien
join hop_dong on hop_dong.ma_nhan_vien= nhan_vien.ma_nhan_vien
group by nhan_vien.ma_nhan_vien
having nhan_vien.ma_nhan_vien not in (select nhan_vien.ma_nhan_vien from nhan_vien 
join hop_dong on hop_dong.ma_nhan_vien=nhan_vien.ma_nhan_vien
where hop_dong.ngay_lam_hop_dong between "2019-01-01" and "2021-01-01"
group by ma_nhan_vien
);

-- C??U 17 ???? S???A
-- b???ng: khach_hang, dich_vu_di_kem,dich_vu,hop_dong, loai_khach
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

-- C??U 18
-- b???ng khach_hang
-- b???ng hop_dong
select khach_hang.ma_khach_hang, khach_hang.ho_ten from khach_hang
join hop_dong on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
where ngay_lam_hop_dong <= "2020-12-31";

-- C??U 19
select hop_dong_chi_tiet.ma_dich_vu_di_kem, ten_dich_vu_di_kem,so_luong,ngay_lam_hop_dong from dich_vu_di_kem
join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
join hop_dong where hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
group by hop_dong_chi_tiet.ma_dich_vu_di_kem
having hop_dong_chi_tiet.so_luong>10 and year(ngay_lam_hop_dong)="2020";

-- C??U 20
select ma_khach_hang, ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi from khach_hang
union
select ma_nhan_vien, ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi from nhan_vien;

-- C??U 21
create view v_nhan_vien as 
select ho_ten, nhan_vien.ma_nhan_vien, ngay_sinh, so_cmnd, luong,so_dien_thoai, email,dia_chi,ma_vi_tri, ma_trinh_do,ma_bo_phan from nhan_vien
join hop_dong on hop_dong.ma_nhan_vien = nhan_vien.ma_nhan_vien
where dia_chi like "%H???i Ch??u%" and ngay_lam_hop_dong = "2019-12-12";

-- C??U 22 ????? b??? ??i??n h???, c?? c??i n??o hi???n ra c??i view ????u m?? thay ?????i

-- C??U 23 sp_xoa_khach_hang 

delimiter //
create procedure xoa_khach_hang( in ma_khach_hang int)
begin
	 delete from khach_hang
    where ma_khach_hang = xoa_khach_hang;
end;
// delimiter ;
-- C??U 24
