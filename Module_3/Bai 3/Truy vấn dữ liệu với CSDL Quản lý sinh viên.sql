use quanlysinhvien;
select * from student;
select * from student 
where `status` = true;
select * from subject
where Credit < 10;
select s.studentid, s.studentname, c.classname
from student s join class c on s.ClassId = c.ClassId
where c.classname = 'A1';
select s.studentid, s.studentname, sub.subname, m.mark
from student s join mark m on s.studentid = m.studentid join subject sub on m.SubId =sub.SubId
where sub.SubName ='CF';