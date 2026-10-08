# Write your MySQL query statement below
select distinct num as ConsecutiveNums 
from ( 
    select num ,
    lead(num) over() as next,
    lead(num , 2) over() as next_next
    from Logs
) as t
where t.num = t.next and t.next = t.next_next;