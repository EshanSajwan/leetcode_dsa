# Write your MySQL query statement below
with daily_amount as (
    select visited_on , 
    SUM(amount) as amount
    from Customer
    group by visited_on
    order by visited_on
),
profit_week as (
    select visited_on , 
    SUM(amount) over(
        order by visited_on
        range between interval 6 day preceding and current row
    ) as amount,
    ROUND(AVG(amount) over(
        order by visited_on
        range between interval 6 day preceding and current row
    ) , 2) as average_amount,
    row_number() over(order by visited_on) as rn
    from daily_amount
)
select visited_on , amount , average_amount
from profit_week where rn > 6;