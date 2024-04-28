select ID, 
(
    case 
    when rank() over (order by SIZE_OF_COLONY desc) <= (
        (select count(*) from ECOLI_DATA) / 4) then 'CRITICAL'
    when rank() over (order by SIZE_OF_COLONY desc) <= 
        (select count(*) from ECOLI_DATA) / 2 then 'HIGH'
    when rank() over (order by SIZE_OF_COLONY desc) <= 
        (select count(*) from ECOLI_DATA) / 2 + ((select count(*) from ECOLI_DATA) / 4) then 'MEDIUM'
    else 'LOW'
    end
) COLONY_NAME
from ECOLI_DATA
order by id