select ii.ITEM_ID,ii.ITEM_NAME,ii.RARITY
from ITEM_INFO ii 
where item_id in (
    select it.item_id
    from item_tree it
        inner join item_info ii2 on it.parent_item_id = ii2.item_id and ii2.rarity = 'rare'
)
order by ii.ITEM_ID desc
 