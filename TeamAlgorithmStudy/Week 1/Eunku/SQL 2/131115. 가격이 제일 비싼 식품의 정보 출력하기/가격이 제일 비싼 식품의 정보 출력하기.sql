-- 코드를 입력하세요
SELECT * from FOOD_PRODUCT
WHERE PRICE = (SELECT max(price) from food_product)