SELECT distinct to_char(a.SALES_DATE, 'yyyy') as YEAR
     , to_number(to_char(a.SALES_DATE, 'mm')) as MONTH
     , count(distinct a.user_id) as PUCHASED_USERS
     , ROUND(count(distinct a.user_id) 
             / (select count(DISTINCT user_id) 
                from USER_INFO
                where to_char(joined, 'yyyy') = '2021'),1) as PUCHASED_RATIO
from  ONLINE_SALE a join USER_INFO b on a.USER_ID = b.USER_ID     
where to_char(b.joined,'yyyy') = '2021'
group by to_char(a.SALES_DATE, 'mm'), to_char(a.SALES_DATE, 'yyyy')
order by to_char(a.SALES_DATE, 'mm'), to_char(a.SALES_DATE, 'yyyy')
