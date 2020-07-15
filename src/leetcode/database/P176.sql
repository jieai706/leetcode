title:Second Highest Salary

--Oracle-sql
--去掉最高工资后的最高工资就是第二高的工资
select max(salary) as SecondHighestSalary from Employee where salary < (select max(salary) from Employee)