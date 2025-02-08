select
    case
        when month(DIFFERENTIATION_DATE) >= 1 and month(DIFFERENTIATION_DATE) <= 3 then '1Q'
        when month(DIFFERENTIATION_DATE) >= 4 and month(DIFFERENTIATION_DATE) <= 6 then '2Q'
        when month(DIFFERENTIATION_DATE) >= 7 and month(DIFFERENTIATION_DATE) <= 9 then '3Q'
        when month(DIFFERENTIATION_DATE) >= 10 and month(DIFFERENTIATION_DATE) <= 12 then '4Q'
    end QUARTER, count(*) ECOLI_COUNT
from ecoli_data
group by 1
order by 1