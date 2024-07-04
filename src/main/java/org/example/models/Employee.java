package org.example.models;

public class Employee {
    private int employeeID;
    private String employeeName;
    private double employeeSalary;
    private String employeeBankAccountNumber;
    private String employeeNationalInsuranceNumber;

    public Employee(
            final int employeeID,
            final String employeeName,
            final double employeeSalary,
            final String employeeBankAccountNumber,
            final String employeeNationalInsuranceNumber) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.employeeSalary = employeeSalary;
        this.employeeBankAccountNumber = employeeBankAccountNumber;
        this.employeeNationalInsuranceNumber = employeeNationalInsuranceNumber;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(
            final int employeeID) {
            this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(
            final String employeeName) {
            this.employeeName = employeeName;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(
            final double employeeSalary) {
            this.employeeSalary = employeeSalary;
    }

    public String getEmployeeBankAccountNumber() {
        return employeeBankAccountNumber;
    }

    public void setEmployeeBankAccountNumber(
            final String employeeBankAccountNumber) {
            this.employeeBankAccountNumber = employeeBankAccountNumber;
    }

    public String getEmployeeNationalInsuranceNumber() {
        return employeeNationalInsuranceNumber;
    }

    public void setEmployeeNationalInsuranceNumber(
            final String employeeNationalInsuranceNumber) {
            this.employeeNationalInsuranceNumber = employeeNationalInsuranceNumber;
    }


    @Override
    public String toString() {
        return "Employee{"
                + "employeeID="
                + employeeID
                + ", employeeName='"
                + employeeName
                + '\''
                + ", employeeSalary=" + employeeSalary
                + ", employeeBankAccountNumber='" + employeeBankAccountNumber
                + '\''
                + ", employeeNationalInsuranceNumber='"
                + employeeNationalInsuranceNumber
                + '\''
                + '}';
    }
}
