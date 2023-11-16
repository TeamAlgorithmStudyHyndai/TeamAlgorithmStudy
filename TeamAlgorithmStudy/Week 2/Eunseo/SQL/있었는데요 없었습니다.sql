SELECT a.ANIMAL_ID, a.name
from ANIMAL_INS a inner join ANIMAL_OUTS b
on a.ANIMAL_ID = b.ANIMAL_ID
where a.DATETIME >= b.DATETIME
order by a.DATETIME