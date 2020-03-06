-- 获取所有非manager的员工emp_no
-- CREATE TABLE `dept_manager` (
-- `dept_no` char(4) NOT NULL,
-- `emp_no` int(11) NOT NULL,
-- `from_date` date NOT NULL,
-- `to_date` date NOT NULL,
-- PRIMARY KEY (`emp_no`,`dept_no`));
-- CREATE TABLE `employees` (
-- `emp_no` int(11) NOT NULL,
-- `birth_date` date NOT NULL,
-- `first_name` varchar(14) NOT NULL,
-- `last_name` varchar(16) NOT NULL,
-- `gender` char(1) NOT NULL,
-- `hire_date` date NOT NULL,
-- PRIMARY KEY (`emp_no`));

select e.emp_no
from  employees as e left join dept_manager as d
on d.emp_no = e.emp_no
where d.dept_no is null;


员工表员工数量是比较多的，left join 完以后， 管理表肯定会有null,
因为员工没有这个属性，对不上
所以我们把d.dept_no 是空的 挑出来，就等于是把员工给跳出来了