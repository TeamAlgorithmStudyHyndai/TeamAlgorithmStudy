SELECT distinct b.USER_ID, b.NICKNAME,
b.CITY || ' ' || b.STREET_ADDRESS1 || ' '|| b.STREET_ADDRESS2 as 전체주소,  
substr(b.tlno,1,3) || '-' || substr(tlno,4,4) || '-' || substr(tlno,8,4) as 전화번호
from USED_GOODS_BOARD a join USED_GOODS_USER b
on a.WRITER_ID = b.USER_ID
where b.user_id in(
select WRITER_ID
from USED_GOODS_BOARD 
group by WRITER_ID
having count(WRITER_ID) >= 3
)
order by b.USER_ID desc