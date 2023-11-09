-- 코드를 입력하세요
SELECT
    IFO.INGREDIENT_TYPE
    , SUM(TOTAL_ORDER) AS TOTAL_ORDER
FROM ICECREAM_INFO IFO
INNER JOIN FIRST_HALF FH
ON   IFO.FLAVOR = FH.FLAVOR
GROUP BY INGREDIENT_TYPE
ORDER BY TOTAL_ORDER ASC
