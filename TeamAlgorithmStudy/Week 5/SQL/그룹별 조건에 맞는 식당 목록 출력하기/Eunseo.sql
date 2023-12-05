select a.MEMBER_NAME, b.REVIEW_TEXT, to_char(b.REVIEW_DATE,'yyyy-mm-dd') as REVIEW_DATE
from MEMBER_PROFILE a join REST_REVIEW b on a.MEMBER_ID = b.MEMBER_ID
where a.member_id = (SELECT MEMBER_ID  from
(SELECT MEMBER_ID
from REST_REVIEW
group by MEMBER_ID
order by  count(REVIEW_ID) desc) where rownum = 1)
order by b.REVIEW_DATE, b.REVIEW_TEXT;
