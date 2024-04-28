SELECT USER_ID, NICKNAME, sum(price) TOTAL_SALES
from USED_GOODS_BOARD ugb
    inner join USED_GOODS_USER ubu on ugb.writer_id = ubu.user_id
where ugb.STATUS = 'DONE' 
group by user_id
having TOTAL_SALES >= 700000
order by TOTAL_SALES