-- 7월 아이스크림 총 주문량과 상반기의 아이스크림 총 주문량을 더한 값이 큰 순서대로 
-- 상위 3개의 맛을 조회하는 SQL 문을 작성

SELECT      flavor
FROM        (SELECT     a.flavor
                        ,(a.total_order + b.total_order) as total_order
             FROM       first_half a
             JOIN       
             (SELECT    flavor
                        ,sum(total_order) as total_order 
             FROM       july
             GROUP BY   flavor) b
             ON         a.flavor = b.flavor
             ORDER BY   2 desc
            )
WHERE       rownum <= 3
