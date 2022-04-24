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
create table phieuxuat_vattu(
so_px int,
ma_vtu int,
dg_xuat varchar(50),
sl_xuat int,
foreign key (so_px) references phieu_xuat(so_px),
foreign key (ma_vtu) references vat_tu(ma_vtu),
primary key (so_px,ma_vtu)
);
alter table phieuxuat_vattu
add dg_xuat varchar(50);
alter table phieuxuat_vattu
add sl_xuat varchar(50);
create table phieu_nhap(
so_pn int primary key,
ngay_nhap datetime
);
create table DG_nhap_SL_nhap(
ma_vtu int,
so_pn int,
foreign key (ma_vtu) references vat_tu(ma_vtu),
foreign key (so_pn) references phieu_nhap(so_pn),
primary key (ma_vtu,so_pn)
);
alter table DG_nhap_SL_nhap
add dg_nhap varchar(50);
alter table DG_nhap_SL_nhap
add sl_nhap varchar(50);
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
create table vat_tu_don_hang(
ma_vtu int,
so_dh int,
foreign key (ma_vtu) references vat_tu(ma_vtu),
foreign key (so_dh) references don_dh(so_dh),
primary key (ma_vtu,so_dh)
);