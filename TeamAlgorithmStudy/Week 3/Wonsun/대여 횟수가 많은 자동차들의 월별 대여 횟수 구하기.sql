-- 코드를 입력하세요

SELECT      extract(month from start_date) as month
            ,car_id
            ,count(start_date) as records
FROM        car_rental_company_rental_history
WHERE       car_id in (
                        SELECT      car_id
                        FROM        car_rental_company_rental_history
                        WHERE       extract(month from start_date) in (8, 9, 10)
                                    and extract(year from start_date) = 2022
                        GROUP BY    car_id
                        HAVING      count(*) >= 5
)
and         8 <= EXTRACT(MONTH FROM START_DATE) AND EXTRACT(MONTH FROM START_DATE) <= 10
GROUP BY    extract(month from start_date), car_id 
ORDER BY    month, car_id desc;
