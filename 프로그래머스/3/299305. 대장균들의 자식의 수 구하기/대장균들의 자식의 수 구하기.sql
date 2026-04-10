-- 코드를 작성해주세요
SELECT ID, ifnull(t.count, 0) as CHILD_COUNT
FROM ECOLI_DATA e
LEFT JOIN (
    SELECT parent_id, count(*) as 'count'
    FROM ECOLI_DATA
    WHERE parent_id is not null
    group by parent_id
) as t ON e.id = t.parent_id
