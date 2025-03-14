select item_id, item_name
from item_info
where item_id in (
    select item_id 
    from item_tree
    where PARENT_ITEM_ID is null
)
order by 1;