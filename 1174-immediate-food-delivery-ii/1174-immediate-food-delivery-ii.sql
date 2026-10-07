# Write your MySQL query statement below
SELECT 
ROUND( SUM( t2.order_date = t2.customer_pref_delivery_date) / COUNT(*) , 4) * 100 AS immediate_percentage 
FROM (
    SELECT d1.customer_id AS cusId ,
    MIN(order_date) AS first_order
    FROM Delivery AS d1
    GROUP BY d1.customer_id
) AS t1
JOIN Delivery AS t2
ON t1.cusId = t2.customer_id AND t1.first_order = t2.order_date;