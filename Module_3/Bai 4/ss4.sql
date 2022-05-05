SELECT * FROM a1121i1.student ;

-- Điều kiện ở trong subquery phải ràng buộc với query ở ngoài. 
select * from student s1
where not exists 
( select * from student s2 where s1.account = s2.account)
;

select * from student 
where `account` in 
( select `account` from student where account is not null );


select * , count(gender) as so_luong from student group by gender ;
select max(point) from student  ;

select *, (point + class_id)/2 from student  ;

select name, id  from student
union
select id, name  from student
;
select length("Chiến");

select char_length("Chiến");

select datediff("2000-10-10", "2010-10-10");
select * from dich_vu 
where dich_vu.id_dich_vu not in (
select dich_vu.id_dich_vu from dich_vu 
join hop_dong on hop_dong.id_dich_vu = dich_vu.id_dich_vu
where ngay_lam_hop_dong between "2021-01-01" and "2021-03-31" )
;
