SELECT a.PRODUCT_ID, a.PRODUCT_NAME, a.price * b.amount as TOTAL_SALES
from FOOD_PRODUCT a inner join 
    (select product_id, sum(amount) as amount from FOOD_ORDER 
    where to_char(PRODUCE_DATE,'yymm') = '2205' 
     group by product_id) b 
on a.PRODUCT_ID = b.PRODUCT_ID
order by TOTAL_SALES desc, a.PRODUCT_ID