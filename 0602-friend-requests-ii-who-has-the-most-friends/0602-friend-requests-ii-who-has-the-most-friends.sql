# Write your MySQL query statement below
with x as 
(select requester_id as a , COUNT(accepter_id) as b
from RequestAccepted
group by requester_id
union all
select accepter_id as a , COUNT(requester_id ) as b
from RequestAccepted
group by accepter_id),
frnds as
(select a as id , sum(b) as num
from x
group by a)

select id , num 
from frnds
where num = (
    select max(num) from frnds
);