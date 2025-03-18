# -- 코드를 작성해주세요
select e.emp_no, e.emp_name,
    (case 
        when avg_score >= 96 then 'S'
        when avg_score >= 90 then 'A'
        when avg_score >= 80 then 'B'
        else 'C' 
    end) grade, 
    (case 
        when avg_score >= 96 then 0.2
        when avg_score >= 90 then 0.15
        when avg_score >= 80 then 0.1
        else 0
    end) * sal bonus
from (
    select emp_no, avg(score) avg_score
    from hr_grade
    group by emp_no
) g
left join hr_employees e on e.emp_no = g.emp_no