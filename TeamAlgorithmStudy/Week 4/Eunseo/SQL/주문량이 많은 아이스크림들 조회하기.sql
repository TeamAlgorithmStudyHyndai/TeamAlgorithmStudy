select Flavor
from(
select a.flavor as Flavor, a.total_order + julySum as total
from FIRST_HALF a inner join
(SELECT flavor, sum(total_order) as julySum
from JULY
group by Flavor) b
on a.flavor = b.flavor
order by total desc
    ) where rownum <= 3