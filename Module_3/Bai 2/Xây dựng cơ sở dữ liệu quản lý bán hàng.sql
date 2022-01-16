create database quanlybanhang;
use quanlybanhang;
create table customer(
cid int primary key auto_increment not null,
cname varchar(50),
cage varchar(20)
);
create table product(
pid int primary key auto_increment not null,
pname varchar(50),
pprice varchar(50)
);
create table `order`(
oid int primary key auto_increment not null,
cid int,
odate datetime,
ototalprice varchar(50),
foreign key (cid) references customer(cid)
);
create table orderdetail(
oid int,
pid int,
odqty int,
primary key (oid,pid),
foreign key (oid) references `order`(oid),
foreign key (pid) references product(pid)
);