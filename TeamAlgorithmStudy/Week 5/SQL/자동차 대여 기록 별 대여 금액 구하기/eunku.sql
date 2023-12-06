select L.history_id as HISTORY_ID, L.day*L.daily_fee*(100-nvl(D.discount_rate,0))/100 as FEE

from

(select h.history_id, h.day, c.daily_fee, c.car_type,
        case when h.day<7  then '7일 미만'
             when h.day<30 then '7일 이상'
             when h.day<90 then '30일 이상'
             else '90일 이상'
             end as duration_type
from
    CAR_RENTAL_COMPANY_CAR C
JOIN
(SELECT history_id,
    car_id,
    end_date - start_date +1 as day
from
   CAR_RENTAL_COMPANY_RENTAL_HISTORY) H
on c.car_id =h.car_id
where
    c.car_type = '트럭') L
left join
    CAR_RENTAL_COMPANY_DISCOUNT_PLAN D
on
    L.duration_type = D.duration_type and L.CAR_TYPE = d.car_type
    
    
order by
    L.day*L.daily_fee*(100-nvl(D.discount_rate,0))/100 desc,
    L.history_id desc