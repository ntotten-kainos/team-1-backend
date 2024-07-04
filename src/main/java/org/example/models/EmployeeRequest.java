package org.example.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeRequest {
    private int employeeID;
    private String employeeName;
    private double employeeSalary;
    private String employeeBankAccountNumber;
    private String employeeNationalInsuranceNumber;

    @JsonCreator
    public EmployeeRequest(
            @JsonProperty("employeeID")
                final int employeeID,
            @JsonProperty("employeeName")
                final String employeeName,
            @JsonProperty("employeeSalary")
                final double employeeSalary,
            @JsonProperty("employeeBankAccountNumber")
                final String employeeBankAccountNumber,
            @JsonProperty("employeeNationalInsuranceNumber")
                final String employeeNationalInsuranceNumber) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.employeeSalary = employeeSalary;
        this.employeeBankAccountNumber = employeeBankAccountNumber;
        this.employeeNationalInsuranceNumber =
                employeeNationalInsuranceNumber;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(final int employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(final String employeeName) {
        this.employeeName = employeeName;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(final double employeeSalary) {
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
            this.employeeNationalInsuranceNumber =
                employeeNationalInsuranceNumber;
    }
}
