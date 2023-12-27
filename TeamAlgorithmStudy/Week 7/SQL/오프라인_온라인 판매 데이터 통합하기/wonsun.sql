-- 2022년 3월의 오프라인/온라인 상품 판매 데이터의 
-- 판매 날짜, 상품ID, 유저ID, 판매량을 출력하는 SQL문을 작성
-- OFFLINE_SALE 테이블의 판매 데이터의 USER_ID 값은 NULL 로 표시
-- 결과는 판매일을 기준으로 오름차순 정렬
-- 판매일이 같다면 상품 ID를 기준으로 오름차순, 
-- 상품ID까지 같다면 유저 ID를 기준으로 오름차순 정렬

SELECT  to_char(sales_date, 'YYYY-MM-DD') as sales_date
        ,product_id
        ,NVL(user_id, NULL) as user_id
        ,sales_amount
FROM
        (
        SELECT  sales_date
                ,product_id
                ,user_id
                ,sales_amount
        FROM    online_sale 
        WHERE   to_char(sales_date, 'YYYY-MM') = '2022-03'
        UNION
        SELECT  sales_date
                ,product_id
                ,NULL
                ,sales_amount
        FROM    offline_sale
        WHERE   to_char(sales_date, 'YYYY-MM') = '2022-03'
        )
ORDER BY 
        sales_date, product_id, user_id
