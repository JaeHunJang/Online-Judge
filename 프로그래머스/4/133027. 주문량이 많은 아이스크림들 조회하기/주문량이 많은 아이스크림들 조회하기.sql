-- 코드를 입력하세요
SELECT FLAVOR
FROM (
    SELECT FLAVOR, SUM(TOTAL_ORDER) AS TOTAL_ORDER
    FROM (
            SELECT *
            FROM FIRST_HALF
        UNION
            SELECT *
            FROM JULY
    ) a
    GROUP BY FLAVOR
    ORDER BY TOTAL_ORDER DESC
    LIMIT 3
) b