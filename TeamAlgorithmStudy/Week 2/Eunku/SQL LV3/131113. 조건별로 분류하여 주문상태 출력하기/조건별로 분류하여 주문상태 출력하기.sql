-- 코드를 입력하세요
SELECT ORDER_ID, PRODUCT_ID, TO_CHAR(OUT_DATE, 'YYYY-MM-DD'), 
CASE WHEN OUT_DATE is null THEN '출고미정'
     WHEN TO_CHAR(OUT_DATE, 'YYYYMMDD') <=20220501 THEN '출고완료'
     else '출고대기' end
from FOOD_ORDER
order by order_id