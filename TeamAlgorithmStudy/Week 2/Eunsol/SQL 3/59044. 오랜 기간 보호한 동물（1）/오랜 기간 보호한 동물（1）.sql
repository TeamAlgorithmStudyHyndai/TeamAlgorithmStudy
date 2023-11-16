-- 코드를 입력하세요
SELECT 
    NAME
    , DATETIME
FROM(
    SELECT 
        NAME
       , DATETIME
      , ROWNUM AS RN
    FROM(
        SELECT
            NAME
            , DATETIME
        FROM 
            ANIMAL_INS
        WHERE ANIMAL_ID NOT IN(
            SELECT
                ANIMAL_ID
            FROM ANIMAL_OUTS 
        )
        ORDER BY DATETIME
    )T1
)T2
WHERE T2.RN BETWEEN 1 AND 3
