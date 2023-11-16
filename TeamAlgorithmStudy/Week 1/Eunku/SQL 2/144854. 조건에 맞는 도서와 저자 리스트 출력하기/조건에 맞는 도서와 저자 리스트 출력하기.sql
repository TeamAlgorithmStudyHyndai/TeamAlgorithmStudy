-- 코드를 입력하세요
SELECT b.BOOK_ID, a.AUTHOR_NAME, TO_CHAR(b.PUBLISHED_DATE, 'yyyy-mm-dd')
FROM BOOK b join AUTHOR a
on b.AUTHOR_ID = a.AUTHOR_ID
where b.CATEGORY = '경제'
order by
    b.PUBLISHED_DATE