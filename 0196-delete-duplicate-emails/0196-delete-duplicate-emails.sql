# Write your MySQL query statement below
delete from person
where id not in (
    select ids from (
        select min(id) as ids from Person group by email
    ) as t
);
