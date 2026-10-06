# Write your MySQL query statement below
SELECT p.product_id , 
Round( IFNULL(SUM( p.price * us.units ) / SUM(us.units) , 0) , 2) AS average_price
FROM Prices AS p
LEFT JOIN UnitsSold AS us
ON p.product_id = us.product_id
AND 
-- us.product_id IS NULL OR 
us.purchase_date <= p.end_date 
AND us.purchase_date >= p.start_date
GROUP BY p.product_id;