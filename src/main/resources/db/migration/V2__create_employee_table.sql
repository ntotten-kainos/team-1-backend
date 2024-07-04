create table Employees (
    employeeID smallint Primary Key AUTO_INCREMENT NOT NULL,
    employeeName varchar(70),
    employeeSalary decimal(7,2),
    employeeBankAccountNumber char(8),
    employeeNationalInsuranceNumber char(9),


);

INSERT into `Employees`
(employeeName, employeeSalary,EmployeeBankAccountNumber, employeeNationalInsuranceNumber,
employeeCommissionRate)
values
("Buddy",22000.00,12345678,'ab123456C');
