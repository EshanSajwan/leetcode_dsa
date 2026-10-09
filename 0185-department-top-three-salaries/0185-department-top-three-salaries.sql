# Write your MySQL query statement below
with high_earners as (
    select
        d.name as dep_name ,
        e.name as emp_name, 
        e.salary ,
        dense_rank() over(
            partition by e.departmentId order by salary desc
        ) as dRank
    from Employee as e
    join Department as d
    on e.departmentId = d.id
)
select 
    dep_name as Department ,
    emp_name as Employee , 
    salary
from high_earners
where dRank < 4;
