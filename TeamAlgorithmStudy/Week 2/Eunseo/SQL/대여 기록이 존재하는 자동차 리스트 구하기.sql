SELECT distinct a.CAR_ID
from CAR_RENTAL_COMPANY_CAR a inner join CAR_RENTAL_COMPANY_RENTAL_HISTORY b
on a.CAR_ID = b.CAR_ID
where a.CAR_TYPE = '세단'
and to_char(b.START_DATE, 'yyyymmdd') like '%202210%'
order by a.CAR_ID desc