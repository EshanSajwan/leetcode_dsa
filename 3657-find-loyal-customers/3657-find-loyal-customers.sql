# Write your MySQL query statement below
with condition_1 as (
    select customer_id 
    from customer_transactions 
    where transaction_type = 'purchase'
    group by customer_id
    having count(transaction_type) > 2
),
condition_2 as (
    select customer_id
    from customer_transactions 
    group by customer_id
    having DATEDIFF(MAX(transaction_date) ,MIN(transaction_date)) > 29
),
condition_3 as (
    select customer_id
    from customer_transactions 
    group by customer_id
    having round((sum(transaction_type = 'refund') / count(*)) * 100) < 20
)
select distinct customer_id
from customer_transactions 
where customer_id in (select * from condition_1) and
      customer_id in (select * from condition_2) and 
      customer_id in (select * from condition_3);