select extract(month from START_DATE) as month, car_id, count(history_id) as records
from
    CAR_RENTAL_COMPANY_RENTAL_HISTORY
where TO_CHAR(START_DATE, 'YYYYMMDD') BETWEEN 20220801 AND 20221031
and car_id in(
SELECT CAR_ID
FROM
    CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE TO_CHAR(START_DATE, 'YYYYMMDD') BETWEEN 20220801 AND 20221031 
GROUP BY
    CAR_ID
having count(*) >=5)
group by
    car_id, extract(month from START_DATE)
order by
    extract(month from START_DATE) asc, car_id desc