# Write your MySQL query statement below
with emp as ( 
    select * from Employees where salary < 30000
)
select e.employee_id
from emp as e
where e.manager_id not in (
    select employee_id from Employees
)
order by e.employee_id;