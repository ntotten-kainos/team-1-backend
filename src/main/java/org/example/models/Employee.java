package org.example.models;
// employeeID smallint Primary Key AUTO_INCREMENT NOT NULL,
//    employeeName varchar(70),
//    employeeSalary decimal(7,2),
//    employeeBankAccountNumber char(8),
//    employeeNationalInsuranceNumber char(9),
//    employeeCommissionRate DECIMAL(2, 2),
//    roleID smallint not using, using inheritance instead
public class Employee
{
    private int employeeID;
    private String employeeName;
    private double employeeSalary;
    private String employeeBankAccountNumber;
    private String employeeNationalInsuranceNumber;
    private double employeeCommissionRate;

    public Employee(int employeeID, String employeeName,
                    double employeeSalary, String employeeBankAccountNumber,
                    String employeeNationalInsuranceNumber, double employeeCommissionRate)
    {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.employeeSalary = employeeSalary;
        this.employeeBankAccountNumber = employeeBankAccountNumber;
        this.employeeNationalInsuranceNumber = employeeNationalInsuranceNumber;
        this.employeeCommissionRate = employeeCommissionRate;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeeBankAccountNumber() {
        return employeeBankAccountNumber;
    }

    public void setEmployeeBankAccountNumber(String employeeBankAccountNumber) {
        this.employeeBankAccountNumber = employeeBankAccountNumber;
    }

    public String getEmployeeNationalInsuranceNumber() {
        return employeeNationalInsuranceNumber;
    }

    public void setEmployeeNationalInsuranceNumber(String employeeNationalInsuranceNumber) {
        this.employeeNationalInsuranceNumber = employeeNationalInsuranceNumber;
    }

    public double getEmployeeCommissionRate() {
        return employeeCommissionRate;
    }

    public void setEmployeeCommissionRate(double employeeCommissionRate) {
        this.employeeCommissionRate = employeeCommissionRate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeID=" + employeeID +
                ", employeeName='" + employeeName + '\'' +
                ", employeeSalary=" + employeeSalary +
                ", employeeBankAccountNumber='" + employeeBankAccountNumber + '\'' +
                ", employeeNationalInsuranceNumber='" + employeeNationalInsuranceNumber + '\'' +
                ", employeeCommissionRate=" + employeeCommissionRate +
                '}';
    }
}
