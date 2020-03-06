/*
查找所有员工的last_name和first_name以及对应部门编号dept_no，也包括展示没有分配具体部门的员工
CREATE TABLE `dept_emp` (
`emp_no` int(11) NOT NULL,
`dept_no` char(4) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`dept_no`));

CREATE TABLE `employees` (
`emp_no` int(11) NOT NULL,
`birth_date` date NOT NULL,
`first_name` varchar(14) NOT NULL,
`last_name` varchar(16) NOT NULL,
`gender` char(1) NOT NULL,
`hire_date` date NOT NULL,
PRIMARY KEY (`emp_no`));
*/

select 
    e.last_name, e.first_name, d.dept_no
from
    employees as e left join dept_emp as d
    -- dept_emp as d right join employees as e
on
    d.emp_no = e.emp_no;



/*
链接：https://www.nowcoder.com/questionTerminal/dbfafafb2ee2482aa390645abd4463bf?f=discussion
注意：
INNER JOIN 两边表同时有对应的数据，即任何一边缺失数据就不显示。(join默认inner)
LEFT JOIN 会读取左边数据表的全部数据，即便右边表无对应数据。
RIGHT JOIN 会读取右边数据表的全部数据，即便左边表无对应数据。

在本题我们想要保留employee的所有数据（因为“包括没有分配具体部门的员工”）

问题，为什么right join不可以，是因为牛客网的原因
*/