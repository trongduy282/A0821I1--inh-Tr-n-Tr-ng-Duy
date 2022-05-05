use quanlysinhvien;
select address, count(studentid) as 'Số lượng học viên'
from student
group by address;
select s.studentid, s.studentname, avg(mark)
from student s join mark m on s.StudentId = m.StudentId
group by s.StudentId, s.StudentName
having avg(mark)>15;
select s.studentid, s.studentname, avg(mark)
from student s join mark m on s.StudentId = m.StudentId
group by s.StudentId, s.StudentName
having avg(mark) >=all(SELECT AVG(Mark) FROM Mark GROUP BY Mark.StudentId);