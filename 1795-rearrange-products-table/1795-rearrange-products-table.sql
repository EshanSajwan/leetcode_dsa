# Write your MySQL query statement below
select 
    product_id,
    (select 'store1') as store,
    store1 as price
from Products
where store1 is not null
union 
select 
    product_id,
    (select 'store2') as store,
    store2 as price
from Products
where store2 is not null
union
select 
    product_id,
    (select 'store3') as store,
    store3 as price
from Products
where store3 is not null