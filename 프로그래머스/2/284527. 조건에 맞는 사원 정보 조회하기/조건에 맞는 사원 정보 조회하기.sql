select sum(score) score, e.emp_no, emp_name, position, email
from HR_EMPLOYEES e
inner join HR_GRADE g on e.emp_no = g.emp_no
group by e.emp_no
order by score desc
limit 1;