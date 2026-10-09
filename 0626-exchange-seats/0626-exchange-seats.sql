# Write your MySQL query statement below
with oddIds as (
    select *
    from Seat
    where id % 2 = 1
),
evenIds as (
    select *
    from Seat
    where id % 2 = 0
)
select o.id , ifnull(e.student , (
    select student from Seat where id = o.id
)) as student
from oddIds as o
left join evenIds as e
on o.id + 1 = e.id
union
select e.id , o.student
from oddIds as o
join evenIds as e
on o.id + 1 = e.id
order by id;