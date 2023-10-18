-- 코드를 입력하세요
SELECT ri.REST_ID, REST_NAME, FOOD_TYPE, FAVORITES, ADDRESS, round(avg(REVIEW_SCORE), 2) as SCORE
FROM REST_INFO ri
    RIGHT JOIN REST_REVIEW rr ON ri.REST_ID = rr.REST_ID 
GROUP BY ADDRESS
HAVING ADDRESS LIKE '서울%'
ORDER BY SCORE desc, FAVORITES desc;