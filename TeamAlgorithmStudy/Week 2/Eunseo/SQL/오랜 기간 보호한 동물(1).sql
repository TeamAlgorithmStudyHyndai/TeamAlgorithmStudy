select *
from( 
    select a.name, a.datetime 
    from animal_ins a LEFT JOIN ANIMAL_OUTS b
    on a.animal_id = b.animal_id
    where a.animal_id not in(
    select animal_id from animal_outs)
    order by datetime
) 
where rownum <= 3;