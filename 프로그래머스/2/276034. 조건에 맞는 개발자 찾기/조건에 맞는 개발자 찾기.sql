SELECT distinct ID, EMAIL, FIRST_NAME, LAST_NAME
FROM DEVELOPERS d
INNER JOIN skillcodes s ON d.skill_code & s.code AND s.name in ('C#', 'Python')
ORDER BY id;