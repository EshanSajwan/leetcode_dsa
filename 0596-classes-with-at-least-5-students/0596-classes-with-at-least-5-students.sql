# Write your MySQL query statement below
select t.class as class
from (
    select c.class , COUNT(c.student) as studentFreq
    from Courses as c
    group by c.class
) as t
where t.studentFreq > 4;