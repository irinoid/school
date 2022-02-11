select * from student;
select * from faculty;
select * from student
where age <= 25 and age >= 2;
select name from student;
select * from student where name like '%k%';
select * from student where age < id;
select SUM(age) from student;
select COUNT(*) from student where age < 15;
select * from student, faculty
where student.faculty_id = faculty."id"
  and student."name" = 'Garry';