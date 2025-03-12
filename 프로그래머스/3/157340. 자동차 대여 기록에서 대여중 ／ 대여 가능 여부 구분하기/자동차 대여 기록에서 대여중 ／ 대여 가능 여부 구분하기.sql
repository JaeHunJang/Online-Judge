-- 코드를 입력하세요
SELECT car_id, '대여중' AVAILABILITY
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where car_id in (
    select car_id
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
    where start_date <= '2022-10-16' and end_date >= '2022-10-16'
)
union
SELECT car_id, '대여 가능' AVAILABILITY
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where car_id not in (
    select car_id
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
    where start_date <= '2022-10-16' and end_date >= '2022-10-16'
)

group by car_id
order by car_id desc;

