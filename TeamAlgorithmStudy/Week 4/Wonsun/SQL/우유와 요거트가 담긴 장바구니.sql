-- 우유와 요거트를 동시에 구입한 장바구니의 아이디를 조회하는 SQL 문을 작성
-- 이때 결과는 장바구니의 아이디 순으로 나와야 합니다.

SELECT      cart_id
FROM        cart_products
WHERE       NAME = 'Milk'
INTERSECT
SELECT      cart_id
FROM        cart_products
WHERE       name = 'Yogurt'
