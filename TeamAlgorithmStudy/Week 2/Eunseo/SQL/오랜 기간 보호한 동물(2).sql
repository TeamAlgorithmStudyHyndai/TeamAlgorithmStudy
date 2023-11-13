SELECT *
from 
(
select a.animal_id, a.name 
from ANIMAL_INS a inner join ANIMAL_OUTS b
on a.ANIMAL_ID = b.ANIMAL_ID
order by (a.DATETIME - b.DATETIME)
)
where rownum <= 2