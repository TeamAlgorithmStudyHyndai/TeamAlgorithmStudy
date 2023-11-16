-- 코드를 입력하세요
SELECT NAME, count(*) as count
from animal_ins
group by name Having count(*)> 1 and name is not null
order by name asc;