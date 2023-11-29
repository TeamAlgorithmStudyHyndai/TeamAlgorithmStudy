SELECT 
    T2.FLAVOR
FROM(
    SELECT
        FH.FLAVOR
        , SUM(FH.TOTAL_ORDER + T1.TOTAL_ORDER) AS TTL_ORDER
    FROM
        FIRST_HALF FH
    INNER JOIN(
        SELECT
             FLAVOR
            , TOTAL_ORDER
        FROM JULY 
    )T1
    ON FH.FLAVOR = T1.FLAVOR
    GROUP BY FH.FLAVOR
    ORDER BY TTL_ORDER DESC
)T2
WHERE ROWNUM BETWEEN 1 AND 3