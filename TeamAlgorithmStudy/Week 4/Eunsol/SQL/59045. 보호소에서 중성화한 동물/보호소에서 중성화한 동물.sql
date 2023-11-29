-- Spayed Female,Neutered Male 중성화 되어있음. Intact Male과 Intact Female은 그대로
SELECT
    AI.ANIMAL_ID
    , AI.ANIMAL_TYPE
    , AI.NAME
FROM
    ANIMAL_INS  AI
WHERE ANIMAL_ID IN (
    SELECT
        ANIMAL_ID
    FROM 
        ANIMAL_OUTS AO
    WHERE AO.SEX_UPON_OUTCOME IN('Spayed Female','Neutered Male')

) AND SEX_UPON_INTAKE IN ('Intact Male','Intact Female')
ORDER BY AI.ANIMAL_ID ASC
;
