-- 코드를 입력하세요
SELECT year(sales_date) YEAR, month(sales_date) MONTH, u.gender GENDER, count(distinct u.user_id) USERS
from online_sale o
left join user_info u on o.user_id = u.user_id
where u.gender is not null
group by 1, 2, 3
order by 1, 2, 3;
