title:Second Highest Salary

--Oracle-sql
--ȥ����߹��ʺ����߹��ʾ��ǵڶ��ߵĹ���
select max(salary) as SecondHighestSalary from Employee where salary < (select max(salary) from Employee)