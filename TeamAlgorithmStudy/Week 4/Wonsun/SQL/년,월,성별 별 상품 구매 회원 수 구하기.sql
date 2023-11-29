-- USER_INFO 테이블과 ONLINE_SALE 테이블에서
-- 년, 월, 성별 별로 상품을 구매한 회원수를 집계하는 SQL문을 작성
-- 결과는 년, 월, 성별을 기준으로 오름차순 정렬
-- 이때, 성별 정보가 없는 경우 결과에서 제외

SELECT      extract(year from o.sales_date) as year
            ,extract(month from o.sales_date) as month
            ,u.gender
            ,count(distinct(o.user_id)) as users
FROM        online_sale o
JOIN        user_info u
ON          o.user_id = u.user_id
WHERE       u.gender is not null
GROUP BY    extract(year from o.sales_date), extract(month from o.sales_date), u.gender
ORDER BY    year, month, gender
