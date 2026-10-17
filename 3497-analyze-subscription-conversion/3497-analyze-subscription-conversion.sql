# Write your MySQL query statement below
with free_vale as (
    select distinct user_id
    from UserActivity
    where activity_type = 'free_trial'
) , paid_vale as (
    select distinct user_id
    from UserActivity
    where activity_type = 'paid'
) , valid_users as (
    select distinct user_id
    from UserActivity
    where user_id in (select * from free_vale) and
        user_id  in (select * from paid_vale)
)
select 
    u.user_id,
    ROUND(AVG(
        case
        when u.activity_type = 'free_trial' then u.activity_duration
        -- else 0
        end
    ) , 2) as trial_avg_duration ,
    ROUND(AVG(
        case
        when u.activity_type = 'paid' then u.activity_duration
        -- else 0
        end
    ) , 2) as paid_avg_duration 

from UserActivity as u
join valid_users as v
on u.user_id = v.user_id
group by v.user_id
order by v.user_id;