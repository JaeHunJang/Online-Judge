-- 코드를 작성해주세요
WITH RECURSIVE t as (
    SELECT id, parent_id, 1 as gen
    FROM ECOLI_DATA
    WHERE PARENT_ID IS NULL
    
    UNION ALL
    
    SELECT c.id, c.parent_id, t.gen + 1
    FROM ECOLI_DATA c
    JOIN t ON t.id = c.PARENT_ID
)

SELECT ID
FROM t
WHERE gen = 3