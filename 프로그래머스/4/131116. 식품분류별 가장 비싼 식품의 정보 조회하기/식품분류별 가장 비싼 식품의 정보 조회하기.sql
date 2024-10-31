# -- 코드를 입력하세요
SELECT CATEGORY, price MAX_PRICE, PRODUCT_NAME
FROM FOOD_PRODUCT
WHERE (PRICE, CATEGORY) IN (SELECT max(price) MAX_PRICE, CATEGORY FROM FOOD_PRODUCT WHERE CATEGORY IN ('과자', '국', '김치', '식용유') GROUP BY CATEGORY ORDER BY price desc)
ORDER BY price desc;
