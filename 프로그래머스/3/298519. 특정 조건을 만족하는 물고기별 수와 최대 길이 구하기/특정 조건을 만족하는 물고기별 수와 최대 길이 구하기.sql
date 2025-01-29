select count(f.fish_type) FISH_COUNT, max(if(length < 10 or length is null, 10,length)) MAX_LENGTH, f.FISH_TYPE
from fish_info f
group by f.fish_type
having avg(nullif(length, 10)) >= 33
order by f.fish_type