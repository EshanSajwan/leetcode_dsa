# Write your MySQL query statement below
with x as (
    select product_id , max( change_date ) as latest
    from Products 
    where change_date <= '2019-08-16' 
    group by product_id
) ,
dis as ( select distinct product_id from Products),
w as ( 
    select p.product_id , p.new_price
    from Products as p
    join x 
    on p.product_id = x.product_id and p.change_date = x.latest   
)
select t1.product_id , (
    case
    when t2.product_id is null then 10
    else t2.new_price
    end
) as price
from dis as t1
left join w as t2
on t1.product_id = t2.product_id;

