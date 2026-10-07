# Write your MySQL query statement below
SELECT
ROUND( count(*) / (SELECT COUNT(DISTINCT player_id) FROM Activity) , 2)
AS fraction
FROM (
    SELECT a1.player_id AS pId ,
    MIN(a1.event_date) AS firstLogIn
    FROM Activity AS a1
    GROUP BY a1.player_id
) AS t1
JOIN Activity AS t2
ON t1.pId = t2.player_id AND
DATE_ADD(t1.firstLogIn , INTERVAL 1 DAY) = t2.event_date;