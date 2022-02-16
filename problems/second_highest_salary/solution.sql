# Write your MySQL query statement below
#select salary as SecondHighestSalary from employee order by salary desc MINUS

select max(salary) as SecondHighestSalary from Employee
where salary != (select max(salary) from Employee); #You can put <> in place of <> also.