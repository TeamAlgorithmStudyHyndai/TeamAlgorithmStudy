SELECT distinct a.car_id, a.car_type, ((a.daily_fee * 30) * (100 - c.DISCOUNT_RATE) / 100) as FEE
from (CAR_RENTAL_COMPANY_CAR a 
      join 
      CAR_RENTAL_COMPANY_RENTAL_HISTORY  b 
      on a.CAR_ID = b.CAR_ID) 
        join 
        CAR_RENTAL_COMPANY_DISCOUNT_PLAN c
        on a.CAR_TYPE = c.CAR_TYPE 
where a.CAR_TYPE in ('세단', 'SUV')
      and a.CAR_ID not in (select car_id
                           from CAR_RENTAL_COMPANY_RENTAL_HISTORY
                           where to_char(end_date, 'yyyymmdd') >= '20221101'
                                 and
                                 to_char(start_date, 'yyyymmdd') <= '20221130'
                            )
group by a.car_id,a.car_type,a.daily_fee, c.duration_type, c.DISCOUNT_RATE
having c.duration_type = '30일 이상' 
        and ((a.daily_fee * 30) * (100 - c.DISCOUNT_RATE) / 100) < 2000000
            and ((a.daily_fee * 30) * (100 - c.DISCOUNT_RATE) / 100) >= 500000
order by FEE desc, a.car_type, a.car_id desc
