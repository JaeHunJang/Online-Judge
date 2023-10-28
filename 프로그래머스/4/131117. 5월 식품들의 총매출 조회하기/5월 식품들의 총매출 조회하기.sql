-- 코드를 입력하세요
SELECT a.PRODUCT_ID, a.PRODUCT_NAME, b.AMOUNT * a.PRICE AS TOTAL_SALES
FROM FOOD_PRODUCT a
    INNER JOIN (
        SELECT PRODUCT_ID, PRODUCE_DATE, SUM(AMOUNT) AS AMOUNT
        FROM FOOD_ORDER
        WHERE PRODUCE_DATE LIKE '2022-05%'
        GROUP BY PRODUCT_ID
    ) b ON a.PRODUCT_ID = b.PRODUCT_ID

ORDER BY TOTAL_SALES DESC, a.PRODUCT_ID

# INNER JOIN (
#         SELECT PRODUCT_ID, PRODUCE_DATE, SUM(AMOUNT) AS AMOUNT
#         FROM FOOD_ORDER
#         GROUP BY PRODUCT_ID
#         HAVING PRODUCE_DATE LIKE '2022-05%'
#     ) b ON a.PRODUCT_ID = b.PRODUCT_ID
