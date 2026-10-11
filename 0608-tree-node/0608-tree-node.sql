# Write your MySQL query statement below
with x as ( 
select t1.id , 
    (
        case
        when count(t2.p_id) = 0 then 'Leaf'
        else 'Inner'
        end
    ) as type
from Tree as t1
left join Tree as t2
on t1.id = t2.p_id
group by t1.id
        )
-- update x 
-- set type = 'Root'
-- where id in ( select id from Tree where p_id is null)

select id , (
    case 
    when id in (select id from Tree where p_id is null) then 'Root'
    else type
    end
) as type
from x;