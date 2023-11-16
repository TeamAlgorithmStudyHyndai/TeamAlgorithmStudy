-- 코드를 입력하세요
SELECT
    PRODUCT_CODE
    , SUM(P.PRICE * OFS.SALES_AMOUNT) AS SALES
FROM PRODUCT P
INNER JOIN OFFLINE_SALE OFS
ON P.PRODUCT_ID = OFS.PRODUCT_ID
GROUP BY PRODUCT_CODE
ORDER BY  SUM(P.PRICE * OFS.SALES_AMOUNT) DESC, PRODUCT_CODE ASC