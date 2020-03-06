/*
查找所有员工入职时候的薪水情况，给出emp_no以及salary， 并按照emp_no进行逆序
CREATE TABLE `employees` (
`emp_no` int(11) NOT NULL,
`birth_date` date NOT NULL,
`first_name` varchar(14) NOT NULL,
`last_name` varchar(16) NOT NULL,
`gender` char(1) NOT NULL,
`hire_date` date NOT NULL,
PRIMARY KEY (`emp_no`));
CREATE TABLE `salaries` (
`emp_no` int(11) NOT NULL,
`salary` int(11) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`from_date`));
查找所有员工入职时候的薪水情况，给出emp_no以及salary， 并按照emp_no进行逆序
*/

select emp.emp_no, sal.salary
from employees as emp inner join salaries as sal 
on emp.emp_no = sal.emp_no and emp.hire_date = sal.from_date
order by emp.emp_no desc;

/*
注意这里使用了order by (属性)，（顺序）


链接：https://www.nowcoder.com/questionTerminal/23142e7a23e4480781a3b978b5e0f33a?f=discussion
来源：牛客网

1、由于测试数据中，salaries.emp_no 不唯一（因为号码为 emp_no 的员***有多次涨薪的可能，所以在 salaries 中对应的记录不止一条）
，employees.emp_no 唯一，即 salaries 的数据会多于 employees，因此需先找到 employees.emp_no 在 salaries 
表中对应的记录salaries.emp_no，则有限制条件 e.emp_no = s.emp_no
2、根据题意注意到 salaries.from_date 和 employees.hire_date 的值应该要相等，因此有限制条件 e.hire_date = s.from_date
*/