create database quan_ly_sinh_vien;
use quan_ly_sinh_vien;
create table class(
class_id int not null primary key auto_increment,
class_name varchar(60) not null,
start_date datetime not null,
`status` bit 
);
create table student(
student_id int not null primary key auto_increment,
student_name varchar(30) not null,
address varchar(50),
phone varchar(20),
`status` bit,
class_id int not null,
foreign key (class_id) references class(class_id)
);
create table `subject`(
sub_id int not null primary key auto_increment,
sub_name varchar(30) not null,
credit tinyint not null default 1 check(credit>=1),
`status` bit default 1 
);
create table mark(
mark_id int not null primary key auto_increment,
sub_id int not null,
foreign key (sub_id) references `subject`(sub_id),
student_id int not null,
foreign key (student_id) references student(student_id),
mark float default 0 check(mark<=100) check(mark>=0),
exam_times tinyint default 1
);
drop table mark;
-- [Thực hành] Thêm dữ liệu vào trong cơ sở dữ liệu quản lý sinh viên
insert into class(class_name,start_date,`status`) values ("A1","2008-12-20",1),
("A2","2008-12-22",1), ("B3",current_date(),0);
insert into student(student_name, address, phone,`status`, class_id) 
values ('Hung', 'Ha Noi', '0912113113', 1, 1),
('Manh', 'HCM', '0123123123', 0, 2);
insert into student(student_name, address,`status`, class_id) 
values ('Hoa', 'Hai phong', 1, 1);
insert into `subject` 
values (1, 'CF', 5, 1),
       (2, 'C', 6, 1),
       (3, 'HDJ', 5, 1),
       (4, 'RDBMS', 10, 1);
insert into mark(sub_id,student_id,mark,exam_times)
 values (1, 1, 8, 1),(1, 2, 10, 2), (2, 1, 12, 1);
 
-- [Thực hành] Truy vấn dữ liệu với CSDL Quản lý sinh viên
select * from student;

select * from student
where status=true;

select * from `subject`
where credit < 10;

select class_name,student_name from class
join student on class.class_id=student.class_id
where class_name="A1";

select mark,student_name,sub_name,student.student_id from mark
join student on mark.student_id=student.student_id
join `subject` on `subject`.sub_id= mark.sub_id
where `subject`.sub_name="CF";

-- Hiển thị tất cả các sinh viên có tên bắt đầu bảng ký tự ‘h’
select student_name from student
where student_name like "h%";

-- Hiển thị các thông tin lớp học có thời gian bắt đầu vào tháng 12.
select class_name,start_date from class
where month(start_date)=12;

-- Hiển thị tất cả các thông tin môn học có credit trong khoảng từ 3-5.
select * from subject
where credit between 3 and 5;

-- Thay đổi mã lớp(ClassID) của sinh viên có tên ‘Hung’ là 2.
update student set class_id=2
where student_name="Hung";

-- Hiển thị các thông tin: StudentName, SubName, Mark. Dữ liệu sắp xếp theo điểm thi (mark) giảm dần. nếu trùng sắp theo tên tăng dần.
select student_name,sub_name,mark from student
join mark on student.student_id= mark.student_id
join `subject` on mark.sub_id= `subject`.sub_id
order by mark desc, student_name asc;