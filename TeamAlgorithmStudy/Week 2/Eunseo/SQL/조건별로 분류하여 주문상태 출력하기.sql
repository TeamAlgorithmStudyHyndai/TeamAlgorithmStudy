SELECT 
    ORDER_ID, 
    PRODUCT_ID,
    to_char(out_date,'yyyy-mm-dd') as OUT_DATE,
    case when OUT_DATE is NULL then '출고미정'
        when to_char(out_date,'yymmdd') > 220501 then '출고대기'
    else '출고완료'
    end as 출고여부
from FOOD_ORDER
order by ORDER_ID
