select year(DIFFERENTIATION_DATE) year, max_colony - SIZE_OF_COLONY as 'YEAR_DEV', ID 
from ecoli_data e
left join (
    select year(DIFFERENTIATION_DATE) year, max(SIZE_OF_COLONY) max_colony
    from ecoli_data
    group by year
) m on year(DIFFERENTIATION_DATE) = m.year
order by 1, 2