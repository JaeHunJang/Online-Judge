select id, fish_name, length
from fish_info f
left join fish_name_info n on f.fish_type = n.fish_type
where (f.fish_type, length) in (select fish_type, max(length) from fish_info group by fish_type)
order by 1