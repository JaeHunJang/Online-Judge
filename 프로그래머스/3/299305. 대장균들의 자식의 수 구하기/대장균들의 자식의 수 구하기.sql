select ed.ID, (
    select(count(*))
    from ECOLI_DATA
    where ed.id = parent_id
    ) CHILD_COUNT
from ECOLI_DATA ed
group by id
