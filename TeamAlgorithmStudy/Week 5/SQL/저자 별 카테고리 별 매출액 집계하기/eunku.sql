-- 코드를 입력하세요
select a.AUTHOR_ID, a.AUTHOR_NAME, a.CATEGORY, sum(a.PRICE*b.sales) as TOTAL_SALES
from
(SELECT b.AUTHOR_ID as AUTHOR_ID,
        b.PRICE as PRICE,
        b.CATEGORY as CATEGORY,
        b.BOOK_ID as BOOK_ID,
        a.AUTHOR_NAME as AUTHOR_NAME
FROM
    BOOK b JOIN AUTHOR a
on b.AUTHOR_ID = a.AUTHOR_ID) a
join (select book_id, sum(Sales) as sales
      from
        BOOK_SALES
      where TO_CHAR(SALES_DATE, 'YYYYMM') = 202201
      group by
            book_id) b
on a.BOOK_ID = b.BOOK_ID
group by
    category, author_id, author_name
order by
    author_id asc, category desc