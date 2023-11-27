SELECT to_char(SALES_DATE,'YYYY') as YEAR,to_number(to_char(SALES_DATE,'mm')) as MONTH, gender,count(distinct a.user_id) as users
from USER_INFO a inner join ONLINE_SALE b
on a.USER_ID = b.USER_ID
where a.GENDER is not null
group by to_char(SALES_DATE,'YYYY'),to_number(to_char(SALES_DATE,'mm')), gender
order by to_char(SALES_DATE,'YYYY'),to_number(to_char(SALES_DATE,'mm')), gender