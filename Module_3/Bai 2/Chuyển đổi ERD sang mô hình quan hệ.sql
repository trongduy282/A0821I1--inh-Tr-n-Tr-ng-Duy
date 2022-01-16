create database ERD;
use erd;
create table phieuxuat(
sopx int primary key,
ngayxuat datetime
);
create table vattu(
mavtu int primary key,
tenvtu varchar(50)
);
create table phieunhap(
sopn int,
ngaynhap datetime
);
create table dondh(
sodh int primary key,
ngaydh datetime
);
create table nhacc(
mancc int primary key,
tenncc varchar(50),
diachi varchar(50)
);
create table sdt(
sodt varchar(20) primary key,
mancc int,
foreign key (mancc) references nhacc(mancc)
);
create table chitietphieuxuat(
dgxuat int,
slxuat int,
sopx int,
mavtu int,
primary key (sopx, mavtu),
foreign key (sopx) references phieuxuat(sopx),
foreign key (mavtu) references vattu(mavtu)
);
create table chitietphieunhap (
dgnhap int,
slnhap int,
sopn int,
mavtu int,
primary key (sopn, mavtu),
foreign key (sopn) references phieunhap(sopn),
foreign key (mavtu) references vattu(mavtu)
);
create table chitietdondathang (
sodh int,
mavtu int,
primary key (sodh, mavtu),
foreign key (sodh) references dondh(sodh),
foreign key (mavtu) references vattu(mavtu)
);
alter table dondh add mancc int;
alter table dondh add foreign key (mancc) references nhacc(mancc);