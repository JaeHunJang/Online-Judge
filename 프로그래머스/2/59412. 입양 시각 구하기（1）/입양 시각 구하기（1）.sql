-- 코드를 입력하세요
SELECT HOUR, count(hour) 'COUNT'
FROM (
    SELECT *, hour(DATETIME) 'HOUR'
    FROM ANIMAL_OUTS
) a
WHERE hour >= 9 AND hour <= 19
GROUP BY hour
ORDER BY hour