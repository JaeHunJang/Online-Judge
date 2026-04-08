-- 코드를 입력하세요
SELECT animal_id, name
FROM ANIMAL_INS
WHERE INTAKE_CONDITION != 'Aged'
ORDER BY animal_id;