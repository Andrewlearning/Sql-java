/*
查找入职员工时间排名倒数第三的员工所有信息
CREATE TABLE `employees` (
`emp_no` int(11) NOT NULL,
`birth_date` date NOT NULL,
`first_name` varchar(14) NOT NULL,
`last_name` varchar(16) NOT NULL,
`gender` char(1) NOT NULL,
`hire_date` date NOT NULL,
PRIMARY KEY (`emp_no`));
*/

select * from employees
    where hire_date = ( select distinct hire_date from employees 
                        order by hire_date desc 
                        limit 2,1);

/*
链接：https://www.nowcoder.com/questionTerminal/ec1ca44c62c14ceb990c3c40def1ec6c?f=discussion
来源：牛客网

LIMIT m,n : 表示从第m+1条开始，取n条数据；
LIMIT n ： 表示从第0条开始，取n条数据，是limit(0,n)的缩写。

（1）首先需要加distinct去重。
假设 5-23（入职最晚日期）入职的有a,b,c 3人；
        5-22（入职第二晚日期）入职的有d,e 2人；
        5-21(入职倒数第三晚)入职的有f,g,h 3人；
        5-21前入职的若干...
若 不加distinct去重，那么按照日期倒序，limit 2,1（从倒数第2行开始，取一条数据）的查询结果为 5-23
加了distinct去重，会按入职日期进行分组，多个相同入职日期会分为一组，这样limit 2,1的结果即为 5-21。
（2）外层的where条件中根据子查询查出的倒数第三晚入职的日期，就能查询出符合条件的员工信息。
*/