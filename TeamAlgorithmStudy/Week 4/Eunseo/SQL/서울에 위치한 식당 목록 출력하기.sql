SELECT a.REST_ID, a.REST_NAME, a.FOOD_TYPE, a.FAVORITES, a.ADDRESS,
round(avg(b.REVIEW_SCORE),2) as SCORE
from REST_INFO a inner join REST_REVIEW b
on a.REST_ID = b.REST_ID
where a.ADDRESS like '서울%'
group by  a.REST_ID, a.REST_NAME, a.FOOD_TYPE, a.FAVORITES, a.ADDRESS 
order by round(avg(b.REVIEW_SCORE),2) desc, a.FAVORITES desc