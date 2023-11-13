SELECT b.user_id, b.nickname, sum(a.PRICE) as TOTAL_SALES
from USED_GOODS_BOARD a join USED_GOODS_USER b
on a.WRITER_ID = b.USER_ID
where a.STATUS = 'DONE'
group by b.user_id,b.nickname
having sum(a.PRICE) >= 700000
order by sum(a.PRICE)