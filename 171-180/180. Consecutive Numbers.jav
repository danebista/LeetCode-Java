select distinct L1.num as 'ConsecutiveNums' from Logs L1 
INNER JOIN LOGS L2 ON (L2.Id=L1.Id+1 && L2.num=L1.num)
Inner join LOGS L3 ON (L3.Id= L2.Id+1 && L2.num = L3.num)
