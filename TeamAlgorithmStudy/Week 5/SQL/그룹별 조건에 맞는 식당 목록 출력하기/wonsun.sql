-- 코드를 입력하세요
SELECT      P.MEMBER_NAME, 
            R.REVIEW_TEXT, 
            TO_CHAR(R.REVIEW_DATE, 'YYYY-MM-DD') AS REVIEW_DATE
FROM        MEMBER_PROFILE P
INNER 
JOIN        REST_REVIEW R 
ON          P.MEMBER_ID = R.MEMBER_ID
INNER 
JOIN        (SELECT MEMBER_ID, 
                    RANK() OVER (ORDER BY COUNT DESC) AS RANK
            FROM    (SELECT MEMBER_ID, COUNT(REVIEW_ID) AS COUNT
                    FROM REST_REVIEW  GROUP BY MEMBER_ID )) C
ON          P.MEMBER_ID = C.MEMBER_ID
WHERE       C.RANK = 1
ORDER BY    R.REVIEW_DATE, R.REVIEW_TEXT
