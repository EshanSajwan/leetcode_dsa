# Write your MySQL query statement below
select salary as SecondHighestSalary
from (
    select 
        id , 
        salary ,
        dense_rank() over( order by salary desc) as dRank
    from Employee
) as t
where t.dRank = 2
union all 
select null
limit 1;