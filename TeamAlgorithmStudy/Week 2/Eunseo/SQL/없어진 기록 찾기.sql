SELECT b.ANIMAL_ID, b.name
from ANIMAL_INS a right join ANIMAL_OUTS b
on a.ANIMAL_ID = b.ANIMAL_ID
where a.ANIMAL_ID is null
and b.ANIMAL_ID is not null
order by b.ANIMAL_ID;