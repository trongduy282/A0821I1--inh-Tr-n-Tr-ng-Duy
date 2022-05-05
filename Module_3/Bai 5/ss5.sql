select * from student where name = "Việt";

create index index_name 
on student(name);

-- Tạo view 
create view people as
select id, name, birthday, "hoc vien" as vi_tri
from student
union
select id, name, birthday, "giang vien"
from instructor;

select * from people where name = "Thắng";


-- Dùng tham số dạng OUT
delimiter //
create procedure find_student_by_name2( key_name varchar(10), out so_luong int )
begin
	 set so_luong = ( select count(*) from student
    where name = key_name ) ;
end;
// delimiter ;

call find_student_by_name2("Ân", @amount);
select @amount;

-- Dùng tham số dạng INOUT
delimiter //
create procedure find_student_by_name3( inout key_search varchar(10))
begin
	 set key_search = ( select count(*) from student
    where name = key_search ) ;
end;
// delimiter ;
set @key_search = "Ân";
call find_student_by_name3(@key_search);
select @key_search ;

-- FUNCTION 

delimiter //
create function sum_2_num (num1 int, num2 int) 
returns int
deterministic
begin
    declare total int;
    set total = num1 + num2 ;
    return total;
end;
// delimiter ;

select sum_2_num(2, 5);

-- Trigger
-- Khi thêm thông tin vào bảng student -> Tự động lấy email làm account, 
-- password mặc định là 123456 để tạo bảng jame .
-- new : Đại diện cho dòng dữ liệu thêm vào
delimiter //
create trigger save_account_james
-- Hành động để kích hoạt trigger
before insert
on student for each row
begin
     insert into jame
     values ( new.email, '123456') ;
     
    if new.`account` is null then 
         set new.`account` = new.email ;
    end if;
end;
// delimiter ;     

insert into student (id, name , birthday, gender, email, `point` )
values (222, "Sơn", "2000-10-10", 1, "son@gmail.com", 10) ;







