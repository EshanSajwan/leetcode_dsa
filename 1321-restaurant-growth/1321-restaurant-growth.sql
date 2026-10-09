# Write your MySQL query statement below
with dates as (
    select distinct visited_on from Customer
), 
target_dates as (
    select c1.visited_on,
    sum(c2.amount) as amount,
    round(sum(c2.amount) / 7 , 2) as average_amount
    from dates as c1
    cross join Customer as c2
    where DATEDIFF(c1.visited_on , c2.visited_on) between 0 and 6
    group by c1.visited_on
    having count(distinct c2.visited_on) >= 7  
)
select * from target_dates;










-- with start_date as (
--     select MIN(visited_on) from Customer
-- )
-- with recursive ans as (
--     select start_date ,
--     SUM(amount) as amount,
--     AVG(amount) as average_amount
--     from Customer
--     where visited_on >= start_date and visited_on < start_date + 7

--     union all

--     select c.visited_on ,
--     SUM(amount) as amount,
--     AVG(amount) as average_amount
--     from Customer as c
--     join ans
--     on start_date = ans.


-- )