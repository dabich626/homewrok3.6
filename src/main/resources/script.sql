select id
from student;

select color
from faculty;

select name, color
from faculty;

select student from faculty
where age between (10,20);

select name, count(name) from faculty
GROUP BY name;

select name, count(name) from faculty
group by name
HAVING like '%o%';

select  from student
where name = id > age;

select  from faculty
ORDER BY age;

