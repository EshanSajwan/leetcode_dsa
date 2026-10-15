# Write your MySQL query statement below
with matching as (
    select distinct product_id 
    from Sales
    where year(sale_date) = 2019 and 
    month(sale_date) between 1 and 3
) , notMatching as (
    select distinct product_id 
    from Sales
    where year(sale_date) <> 2019 or 
    month(sale_date) > 3
) , ids as (
    select product_id
    from matching 
    where product_id not in (
        select * from notMatching
    ) 
)
select product_id , product_name
from Product
where product_id in (
    select * from ids
);