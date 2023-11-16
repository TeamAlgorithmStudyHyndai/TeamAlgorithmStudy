SELECT  a.CATEGORY, sum(SALES) as TOTAL_SALES
from BOOK a inner join BOOK_SALES b
on a.BOOK_ID = b.BOOK_ID
where to_char(SALES_DATE) like '%JAN-22'
group by a.category
order by a.category