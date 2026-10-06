# Write your MySQL query statement below
SELECT e.name
FROM Employee AS e
JOIN Employee AS r
ON e.id = r.managerId
GROUP BY e.id
HAVING count(e.id) > 4;