-- 코드를 입력하세요
SELECT INGREDIENT_TYPE, sum(TOTAL_ORDER) TOTAL_ORDER
FROM FIRST_HALF a
    INNER JOIN ICECREAM_INFO b ON a.FLAVOR = b.FLAVOR
GROUP BY INGREDIENT_TYPE
ORDER BY sum(TOTAL_ORDER)