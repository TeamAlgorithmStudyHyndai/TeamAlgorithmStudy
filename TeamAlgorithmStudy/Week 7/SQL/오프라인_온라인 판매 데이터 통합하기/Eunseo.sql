select SALES_DATE, PRODUCT_ID, USER_ID, SALES_AMOUNT
from
    (
        select to_char(SALES_DATE, 'yyyy-mm-dd') AS SALES_DATE, PRODUCT_ID, USER_ID, SALES_AMOUNT
        from ONLINE_SALE  
        where to_char(SALES_DATE, 'yyyymm') = '202203' 
    ) 
    union all
    (
        select to_char(SALES_DATE, 'yyyy-mm-dd') AS SALES_DATE, PRODUCT_ID, NULL AS USER_ID,SALES_AMOUNT
        from OFFLINE_SALE 
        where to_char(SALES_DATE, 'yyyymm') = '202203'
    ) 
order by SALES_DATE, PRODUCT_ID, USER_ID
