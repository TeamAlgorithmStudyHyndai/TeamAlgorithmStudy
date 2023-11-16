-- 코드를 입력하세요
SELECT 
    T2.ANIMAL_ID
    , T2.NAME
    FROM(
        SELECT 
            T1.ANIMAL_ID
            , T1.NAME
            , ROWNUM AS RN
        FROM(
        SELECT
            AI.ANIMAL_ID
            , AI.NAME
            , AO.DATETIME-AI.DATETIME
        FROM
            ANIMAL_INS AI
        INNER JOIN ANIMAL_OUTS  AO
        ON AI.ANIMAL_ID = AO.ANIMAL_ID
        ORDER BY  AO.DATETIME-AI.DATETIME DESC
    )T1
)T2 WHERE T2.RN BETWEEN 1 AND 2