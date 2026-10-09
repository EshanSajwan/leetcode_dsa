# Write your MySQL query statement below
with report as (
    select
    tiv_2016,
    count(tiv_2015) over( partition by tiv_2015 ) as tiv_15_count,
    count(lat) over( partition by lat , lon ) as loc_count
    from Insurance
)
select round(sum(tiv_2016) , 2) as tiv_2016
from report
where tiv_15_count > 1 and loc_count = 1;