select FOOD_TYPE, REST_ID, REST_NAME, FAVORITES
from rest_info
where (food_type, favorites) in (select food_type, max(favorites) from rest_info group by FOOD_TYPE)
order by FOOD_TYPE desc, FAVORITES