# Write your MySQL query statement below
with t_1 as (
    select 
        employee_id,
        review_date , 
        rating,
        dense_rank() over(
            partition by employee_id order by review_date desc) as dr
    from performance_reviews 
), t_2 as (
    select 
        employee_id,
        review_date , 
        rating,
        dr
    from t_1
    where dr < 4 and
    -- group by employee_id
    -- having count(*) > 2
    employee_id in (
        select employee_id
        from t_1
        where dr < 4
        group by employee_id
        having count(*) > 2
    )
), t_3 as (
    select 
        x.employee_id, 
        x.rating as xR,
        x.dr as xDr, 
        y.rating as yR,
        y.dr as yDr
    from t_2 as x
    left join t_2 as y
    on x.employee_id = y.employee_id and x.dr - 1 = y.dr
) , t_4 as (
    select 
        (
            case
            when yDr is null then employee_id
            when yR - xR > 0 then employee_id
            end
        )
        as employee_id
    from t_3
) , validId as (
    select
        distinct employee_id
    from t_4
    group by employee_id
    having count(*)  = 3
) , id_with_score as (
    select 
        v.employee_id,
        sum(t.yR - t.xR) as score
    from validId as v
    join t_3 as t
    on v.employee_id = t.employee_id 
    where t.xDr > 1
    group by v.employee_id
)
select 
    p.employee_id,
    q.name,
    p.score as improvement_score
from id_with_score as p
join employees as q
on p.employee_id = q.employee_id
order by improvement_score desc, q.name asc;


