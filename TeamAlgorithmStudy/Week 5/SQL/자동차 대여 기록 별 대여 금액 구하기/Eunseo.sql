--코드 작성
select distinct HISTORY_ID, fee from 
(
    select HISTORY_ID,
        case when date_calculate='할인 없음' then fee
             else fee * (100-DISCOUNT_RATE) / 100 
        end as fee
    from(
        select fee, HISTORY_ID, DURATION_TYPE,DISCOUNT_RATE,
            case when DateNum >= 7 and DateNum < 30 then '7일 이상'
                when DateNum >= 30 and DateNum < 90 then '30일 이상'
                when DateNum >= 90 then '90일 이상'
                else '할인 없음' 
            end as date_calculate
            from (
                SELECT b.HISTORY_ID as HISTORY_ID, 
                    (b.END_DATE - b.START_DATE + 1) as DateNum, 
                    a.DAILY_FEE * (b.END_DATE - b.START_DATE + 1) as fee,
                    c.DURATION_TYPE as DURATION_TYPE,
                    c.DISCOUNT_RATE as DISCOUNT_RATE
                from CAR_RENTAL_COMPANY_CAR a 
                    join 
                    CAR_RENTAL_COMPANY_RENTAL_HISTORY  b 
                    on a.CAR_ID = b.CAR_ID
                    join 
                    CAR_RENTAL_COMPANY_DISCOUNT_PLAN c
                    on a.CAR_TYPE = c.CAR_TYPE
                where c.CAR_TYPE='트럭')
        )
    where date_calculate = duration_type or date_calculate ='할인 없음'
    )
order by fee desc, HISTORY_ID desc
