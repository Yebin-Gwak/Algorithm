SELECT fh.FLAVOR
from FIRST_HALF fh
join ICECREAM_INFO ii
    on fh.FLAVOR = ii.FLAVOR
where ii.INGREDIENT_TYPE = 'fruit_based'
    and fh.TOTAL_ORDER > 3000
order by fh.TOTAL_ORDER DESC