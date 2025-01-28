select e.DEPT_ID, DEPT_NAME_EN, round(avg(SAL), 0) AVG_SAL
from HR_EMPLOYEES e
left join HR_DEPARTMENT d on e.dept_id = d.dept_id
group by e.DEPT_ID
order by AVG_SAL desc