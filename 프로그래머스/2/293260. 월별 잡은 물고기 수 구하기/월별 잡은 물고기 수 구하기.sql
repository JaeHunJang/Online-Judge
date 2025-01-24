select count(time) 'FISH_COUNT', month(time) 'MONTH'
from fish_info
group by month
order by month;