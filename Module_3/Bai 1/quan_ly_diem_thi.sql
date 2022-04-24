create database quan_ly_diem_thi;
use quan_ly_diem_thi;
create table hocsinh(
ma_hs int auto_increment primary key,
ten_hs varchar(50),
ngaysinh date,
lop varchar(50),
GT varchar(50)
);
create table giaovien(
ma_gv int auto_increment primary key,
ten_gv varchar(50),
sdt varchar(20)
);
create table mon_hoc(
ma_mh int auto_increment primary key,
ten_mh varchar(50),
ma_gv int,
foreign key (ma_gv) references giaovien(ma_gv)
);
create table bangdiem(
ma_hs int,
ma_mh int,
diemthi int,
ngay_kt date,
primary key (ma_hs,ma_mh),
foreign key (ma_hs) references hocsinh(ma_hs),
foreign key (ma_mh) references mon_hoc(ma_mh)
);
