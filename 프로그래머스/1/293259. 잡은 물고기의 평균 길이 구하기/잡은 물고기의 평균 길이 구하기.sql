select round(sum(ifnull(length, 10)) / count(*), 2) 'AVERAGE_LENGTH'
from fish_info