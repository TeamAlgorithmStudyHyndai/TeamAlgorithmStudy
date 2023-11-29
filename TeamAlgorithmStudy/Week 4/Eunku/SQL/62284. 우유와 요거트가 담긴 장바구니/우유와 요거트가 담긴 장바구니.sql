-- 코드를 입력하세요
select a.cart_id
from
(SELECT CART_ID, NAME
FROM
    CART_PRODUCTS
WHERE NAME IN ('Milk', 'Yogurt')
group by cart_id, name) a
group by cart_id
having count(cart_id)>=2
order by cart_id asc