# Write your MySQL query statement below
SELECT * 
FROM Cinema
WHERE id & 1 = 1 AND description != 'boring'
ORDER BY 4 DESC;