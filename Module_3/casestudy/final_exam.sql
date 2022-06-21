create database library;
use library;
create table book(
book_id int primary key auto_increment,
book_name varchar(45),
author_name varchar(45),
des varchar(45),
book_number int
);
create table student(
student_id int primary key auto_increment,
student_name varchar(45),
class varchar(45)
);
create table book_renting(
renting_id int primary key auto_increment,
book_id int,
foreign key(book_id) references book(book_id),
student_id int,
foreign key(student_id) references student(student_id),
`status` boolean,
rental_day date,
return_day date
);

