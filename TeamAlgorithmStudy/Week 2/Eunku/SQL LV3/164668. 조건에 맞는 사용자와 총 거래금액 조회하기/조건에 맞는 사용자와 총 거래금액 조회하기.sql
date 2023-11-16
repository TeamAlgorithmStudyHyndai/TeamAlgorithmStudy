select B.user_id, B.nickname, A.total_sales 
from (
select writer_id, sum(price) as total_sales
from USED_GOODS_BOARD 
where STATUS = 'DONE'
group by writer_id
having sum(price) >= 700000
) A join USED_GOODS_USER B
on A.writer_id = B.user_id
order by A.total_sales