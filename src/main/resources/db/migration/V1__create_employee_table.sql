create table Employees (
    employeeID smallint Primary Key AUTO_INCREMENT NOT NULL,
    employeeName varchar(70),
    employeeSalary decimal(7,2),
    employeeBankAccountNumber char(8),
    employeeNationalInsuranceNumber char(9)
);

INSERT into `Employees`
(employeeName, employeeSalary,EmployeeBankAccountNumber, employeeNationalInsuranceNumber)
values
("Barb",28000.00,12345677,'FG123456C'),
("Sarah",24000.00,12345699,'GH123456C'),
("Mary",27000.00,12345699,'HI123456C'),
("Max",22000.00,12345699,'JK123456C'),
("John",44000.00,12345699,'LM123456C'),
("Jack",34000.00,12345699,'MN123456C'),
("Joe",38000.00,12345699,'NO123456C'),
("Jen",32000.00,12345699,'PQ123456C'),
("Jessica",28000.00,12345699,'RS123456C')
;

