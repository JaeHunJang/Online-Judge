-- 코드를 입력하세요
SELECT ORDER_ID, PRODUCT_ID, date_format(OUT_DATE, '%Y-%m-%d') AS OUT_DATE,
if(OUT_DATE is null, '출고미정', if(datediff('2022-05-01', OUT_DATE) >= 0, '출고완료', '출고대기')) AS '출고여부'
FROM FOOD_ORDER 
ORDER BY 1