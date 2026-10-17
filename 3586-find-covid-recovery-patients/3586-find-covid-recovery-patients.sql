# Write your MySQL query statement below
with penis as (
    select 
        patient_id,
        test_date
    from covid_tests
    where result = 'Positive'
), positives as (
    select 
        patient_id,
        MIN(test_date) as test_date
    from penis
    group by patient_id
)
, negatives as (
    select 
        patient_id,
        test_date
    from covid_tests
    where result = 'Negative'
),
x as (
    select 
        p.patient_id ,
        datediff(n.test_date , p.test_date) as recovery_time 
    from positives as p
    join negatives as n
    on p.patient_id = n.patient_id and n.test_date > p.test_date
) ,
result as (
    select 
        patient_id , 
        min(recovery_time) as recovery_time
    from x
    group by patient_id
)
select 
    pat.patient_id,
    pat.patient_name ,
    pat.age,
    result.recovery_time
from patients as pat
join result
on pat.patient_id = result.patient_id
order by result.recovery_time , pat.patient_name;
