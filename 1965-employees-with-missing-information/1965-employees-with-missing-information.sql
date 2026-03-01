# Write your MySQL query statement below
select employee_id
from (
        select e.employee_id as employee_id , e.name as name , s.salary as salary
        from employees as e
        left join salaries as s
        on e.employee_id = s.employee_id

        union

        select s1.employee_id as employee_id , e1.name as name , s1.salary as salary
        from employees as e1
        right join salaries as s1
        on e1.employee_id = s1.employee_id

    ) as t
where name is null or salary is null
order by employee_id;