-- 코드를 입력하세요
SELECT HISTORY_ID, round(b.DAILY_FEE * ((100 - IFNULL(c.DISCOUNT_RATE, 0)) / 100) * (DATEDIFF(a.END_DATE, a.START_DATE) + 1)) AS FEE
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY a
    JOIN CAR_RENTAL_COMPANY_CAR b ON a.CAR_ID = b.CAR_ID AND b.CAR_TYPE = '트럭'
    LEFT JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN c ON b.CAR_TYPE = c.CAR_TYPE AND DATEDIFF(a.END_DATE, a.START_DATE) + 1 >= LEFT(c.DURATION_TYPE, length(c.DURATION_TYPE) - 4)
GROUP BY HISTORY_ID
ORDER BY 2 DESC, 1 DESC