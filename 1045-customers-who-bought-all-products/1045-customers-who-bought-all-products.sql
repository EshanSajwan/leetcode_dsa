# Write your MySQL query statement below
--  pele cross join marke ye nikal ki product_key same kis kis ki hai , un records ko lele
-- fir isme product key ek tabe ki find kar ki distinct kitni hai 
-- agar uska count = hai Product table ke count hai toh vo id utha le

-- with totalProducts as (
--     select count(product_key)
--     from Product
-- )
select c.customer_id
from Customer as c
cross join Product as p
where c.product_key = p.product_key
group by c.customer_id
having COUNT(distinct c.product_key) = (
    select count(product_key)
    from Product
);