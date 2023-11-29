select flavor from(
select flavor, sum(s) as s1 from
(select flavor, sum(total_order) as s from FIRST_HALF
group by flavor
UNION ALL
select flavor, sum(total_order) as s from july
group by flavor)
GROUP BY flavor
order by s1 desc)
where ROWNUM < 4;
