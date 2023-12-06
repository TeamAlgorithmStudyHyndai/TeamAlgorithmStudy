-- 코드를 입력하세요
select t.car_id, t.car_type, t.fee*(100-d.discount_rate)/100 as fee
from
(select car_id,car_Type, daily_fee *30 as fee
from
CAR_RENTAL_COMPANY_CAR
where
    car_id in
(select distinct car_id
from
    CAR_RENTAL_COMPANY_RENTAL_HISTORY
where
car_id not in (
SELECT
    CAR_ID
FROM
    CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE
    TO_CHAR(START_DATE, 'YYMM') =2211
OR
    TO_CHAR(END_DATE, 'YYMMDD') > 221101
)
AND car_type in ('세단', 'SUV'))) T

join (select car_type, discount_rate
      from
        CAR_RENTAL_COMPANY_DISCOUNT_PLAN
      where DURATION_TYPE = '30일 이상') D
on
    t.car_type = d.car_type

where
    t.fee*(100-d.discount_rate)/100  >= 500000
and
    t.fee*(100-d.discount_rate)/100  < 2000000
order by
    t.fee*(100-d.discount_rate)/100 desc,
    t.car_type asc,
    t.car_id desc