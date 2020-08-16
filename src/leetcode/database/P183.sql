title:Customers Who Never Order

--Oracle-sql
select Name as Customers from Customers where id not in (select CustomerId from Orders)