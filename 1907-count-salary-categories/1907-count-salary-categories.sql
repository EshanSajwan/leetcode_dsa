# Write your MySQL query statement below
WITH ctg AS (
    -- Bina CREATE TABLE ke virtual table banana
    SELECT 'Low Salary' AS category
    UNION SELECT 'Average Salary'
    UNION SELECT 'High Salary'
),
 x as
(select ctg.category , COUNT(acc.account_id) as county 
from ctg 
cross join Accounts as acc
where (ctg.category = 'Low Salary' and acc.income < 20000) or
(ctg.category = 'Average Salary' and acc.income <= 50000 and acc.income >= 20000) or
(ctg.category = 'High Salary' and acc.income > 50000)
group by ctg.category)

select ctg.category , ifnull( x.county, 0) as accounts_count 
from ctg
left join x
on ctg.category = x.category;
