-- 보호소에서는 몇 시에 입양이 가장 활발하게 일어나는지 알아보려 합니다. 
-- 0시부터 23시까지, 
-- 각 시간대별로 입양이 몇 건이나 발생했는지 조회하는 SQL문을 작성
-- 결과는 시간대 순으로 정렬해야 합니다.
SELECT  HOURS.hour
        ,NVL(COUNT(ao.animal_id), 0) as COUNT
FROM    (SELECT LEVEL - 1 AS hour 
         FROM DUAL 
         CONNECT BY LEVEL <= 24) HOURS
LEFT
JOIN    animal_outs ao
ON      to_char(ao.datetime, 'HH24') = HOURS.hour
GROUP BY
        HOURS.hour
ORDER BY
        HOURS.hour
