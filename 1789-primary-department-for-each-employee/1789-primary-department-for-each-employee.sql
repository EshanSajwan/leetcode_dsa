# Write your MySQL query statement below
select t.employee_id , j.department_id
from (
    select employee_id 
    from Employee
    group by employee_id
    having COUNT(department_id) > 1
) as t
join Employee as j
on t.employee_id = j.employee_id and j.primary_flag = 'Y'
UNION
select k.employee_id , k.department_id
from Employee as k
group by employee_id
having COUNT(department_id) = 1;  
