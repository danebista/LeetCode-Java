select max(salary) as SecondHighestSalary from Employee WHERE
salary< (select max(salary) from Employee)
