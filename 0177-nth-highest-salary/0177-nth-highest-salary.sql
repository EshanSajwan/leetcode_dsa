CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
    with Employee_sal as (
        select distinct salary from Employee
    ) ,
    salary_rank as (
        select 
            salary ,
            dense_rank() over(order by salary desc) as rank_
        from Employee_sal
    )
    , highest_rank as (
        select max(rank_) from salary_rank
    )
    select
        case
        when (select * from highest_rank) < N then null
        else (select salary from salary_rank
                where rank_ = N)
        end as getNthHighestSalary
  );
END