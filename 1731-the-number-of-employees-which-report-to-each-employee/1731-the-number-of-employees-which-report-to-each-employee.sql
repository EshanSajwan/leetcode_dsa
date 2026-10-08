# Write your MySQL query statement below
select t1.employee_id , t1.name , 
COUNT(t2.reports_to) as reports_count,
ROUND(AVG(t2.age)) as average_age
from Employees as t1
join Employees as t2
on t1.employee_id = t2.reports_to
group by t1.employee_id
order by t1.employee_id;