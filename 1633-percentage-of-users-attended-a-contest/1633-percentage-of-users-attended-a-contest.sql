# Write your MySQL query statement below
SELECT contest_id,
ROUND( COUNT( contest_id ) / (
    SELECT COUNT(*) FROM Users
) , 4) * 100 AS percentage
FROM Register AS r
GROUP BY contest_id
ORDER BY 2 DESC , contest_id; 