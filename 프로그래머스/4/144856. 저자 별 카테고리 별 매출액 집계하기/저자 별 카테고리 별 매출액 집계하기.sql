-- 코드를 입력하세요
select a.AUTHOR_ID, AUTHOR_NAME, CATEGORY, sum(sales * price) TOTAL_SALES
from BOOK_SALES bs
left join BOOK b on b.book_id = bs.book_id
left join AUTHOR a on a.author_id = b.author_id
where left(bs.sales_date, 7) = '2022-01'
group by 1, 3
order by 1 asc, 3 desc;
