# Write your MySQL query statement below
Select d.Name as Department, a.Name as Employee, a.Salary
from
(select e.*, dense_rank() over (partition by DepartmentId order by Salary desc) as DeptPayRank 
from Employee e) a

join Department d 
on a.departmentId = d.Id
where DeptPayRank<=3
