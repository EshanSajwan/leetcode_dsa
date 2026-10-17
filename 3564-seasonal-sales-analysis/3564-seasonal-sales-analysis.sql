# Write your MySQL query statement below
with sWs as (
    select
        sale_id ,
        product_id ,
        sale_date  ,
        quantity ,
        price, 
        (case
            when month(sale_date) in (1 , 2 , 12) then 'Winter'
            when month(sale_date) in (3 , 4 , 5) then 'Spring'
            when month(sale_date) in (6 , 7 , 8) then 'Summer'
            when month(sale_date) in (9 , 10 , 11) then 'Fall'
        end
        ) as season
    from sales
), sp as (
    select 
        sWs.sale_id ,
        sWs.product_id ,
        sWs.sale_date  ,
        sWs.quantity ,
        sWs.price , 
        sWs.season,
        pp.product_name,
        pp.category
    from sWs 
    join products as pp
    on sWs.product_id = pp.product_id
) , quantityPerCat as (
    select 
        sum(quantity) as total_quantity ,
        sum(quantity * price) as revenue , 
        season,
        category
    from sp 
    group by season , category
) , maxQuantityPerCat as (
    select 
        max(total_quantity) as max_total_quantity ,
        -- revenue , 
        season
        -- category
    from quantityPerCat 
    group by season 
    -- , category
) , maxQuantityVale as (
    select
        x.total_quantity as max_total_quantity ,
        x.revenue , 
        x.season,
        x.category
    from quantityPerCat as x
    join maxQuantityPerCat as y
    on x.season = y.season and
    --  x.category = y.category and
        x.total_quantity = y.max_total_quantity
) , maxRevenueVale as (
    select 
        -- max_total_quantity ,
        max(revenue) as max_revenue , 
        season
        -- category
    from maxQuantityVale 
    group by season 
    -- , category , max_total_quantity
) , result as (
    select
        a.max_total_quantity ,
        a.revenue , 
        a.season,
        a.category
    from maxQuantityVale as a
    join maxRevenueVale as b
    on a.season = b.season and 
    -- a.category = b.category and
    -- b.max_total_quantity = a.max_total_quantity and 
    a.revenue = b.max_revenue
)
select 
    season,
    min(category) as category ,
    max_total_quantity as total_quantity ,
    revenue as total_revenue
from result
group by season , max_total_quantity, revenue 
order by season;