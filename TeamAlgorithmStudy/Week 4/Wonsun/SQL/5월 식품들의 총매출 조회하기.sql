-- 생산일자가 2022년 5월인 식품들의
-- 식품 ID, 식품 이름, 총매출을 조회하는 SQL문
-- 결과는 총매출을 기준으로 내림차순 정렬
-- 총매출이 같다면 식품 ID를 기준으로 오름차순 정렬

SELECT      o.product_id
            ,p.product_name
            ,sum(o.amount * p.price) as total_sales
FROM        food_order o
JOIN        food_product p
ON          o.product_id = p.product_id
WHERE       extract(month from o.produce_date) = 5
and         extract(year from o.produce_date) = 2022
GROUP BY    o.product_id, p.product_name
ORDER BY    total_sales desc, o.product_id asc
