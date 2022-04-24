create database quan_ly_don_hang;
use quan_ly_don_hang;
create table phieu_xuat(
so_px int primary key,
ngay_xuat datetime
);
create table vat_tu(
ma_vtu int primary key,
ten_vtu varchar(50)
);
create table phieu
create table phieu_nhap(
so_pn int primary key,
ngay_nhap datetime
);
create table nha_cc(
ma_ncc int primary key,
ten_ncc varchar(50),
diachi varchar(50),
sdt varchar(20)
);
create table don_dh(
so_dh int primary key,
ngay_dh datetime,
ma_ncc int,
foreign key (ma_ncc) references nha_cc(ma_ncc)
);