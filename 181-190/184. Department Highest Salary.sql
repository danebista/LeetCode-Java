# Write your MySQL query statement below

Select E2.name as 'Department', E1.name as 'Employee',
E1.salary as 'Salary' from Employee E1 join Department E2
on E1.departmentId = E2.id where (E1.departmentId,E1.salary)
in(
    select DepartmentId, max(salary) from Employee
    Group By DepartmentId
)
