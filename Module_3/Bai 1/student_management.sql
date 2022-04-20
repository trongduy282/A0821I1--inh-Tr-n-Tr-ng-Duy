create database class;
use class;
create table student(
id int,
`name` varchar(50),
age int,
country varchar(50)
);
select * from student;
create table class(
id int,
name varchar(50)
);
create table teacher(
id int auto_increment primary key,
`name` varchar(50),
age int,
country varchar(50)
);
select * from teacher;
drop table teacher;
insert into teacher (`name`,age,country) values ("chien",27,"vn"),("chanh",40,"vn");