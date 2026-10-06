# Write your MySQL query statement below
SELECT r.contest_id,
ROUND( COUNT( r.contest_id ) / (
    SELECT COUNT(*) FROM Users
) , 4) * 100 AS percentage
FROM Users AS u
JOIN Register AS r
ON u.user_id = r.user_id
GROUP BY r.contest_id
ORDER BY 2 DESC , r.contest_id; 