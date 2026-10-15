# Write your MySQL query statement below
with temp as (
    select distinct 
    student_id , 
    subject,
    first_value(score) over(
        partition by student_id , subject
        order by exam_date
        rows between unbounded preceding and unbounded following
        ) as first_score,
    last_value(score) over(
        partition by student_id , subject
        order by exam_date
        rows between unbounded preceding and unbounded following
        ) as latest_score
    from Scores
    -- group by student_id , subject
    -- having count(*) > 1
)
select *
from temp
where first_score < latest_score;