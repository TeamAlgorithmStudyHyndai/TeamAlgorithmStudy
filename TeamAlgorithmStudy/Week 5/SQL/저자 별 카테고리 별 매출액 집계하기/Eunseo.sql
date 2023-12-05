SELECT  a.AUTHOR_ID, a.AUTHOR_NAME, b.CATEGORY, sum(d.SALES * b.PRICE) as TOTAL_SALES 
from (author a join book b on a.AUTHOR_ID = b.AUTHOR_ID) join BOOK_SALES  d on b.BOOK_ID = d.book_id
where to_char(d.SALES_DATE, 'yyyymm') = '202201'
group by a.AUTHOR_ID, a.AUTHOR_NAME, b.CATEGORY
order by a.AUTHOR_ID, b.CATEGORY desc;
