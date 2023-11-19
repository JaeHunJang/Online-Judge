-- 코드를 입력하세요
SELECT USER_ID, NICKNAME, concat(CITY,' ', STREET_ADDRESS1,' ', STREET_ADDRESS2) AS '전체주소',
    concat(substring(TLNO, 1, 3), '-', substring(TLNO, 4, 4), '-', substring(TLNO, 8, 4)) AS '전화번호'
FROM USED_GOODS_USER
WHERE USER_ID in (
    SELECT WRITER_ID
    FROM USED_GOODS_BOARD 
    GROUP BY WRITER_ID
    HAVING count(*) >= 3
)
ORDER BY 1 DESC