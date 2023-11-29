SELECT distinct CART_ID
from CART_PRODUCTS 
where cart_id in (
    select cart_id
    from CART_PRODUCTS
    where name = 'Milk'
)
and name = 'Yogurt'
order by CART_ID