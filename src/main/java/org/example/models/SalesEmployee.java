package org.example.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SalesEmployee extends Employee {


    @JsonProperty
    private double commissionRate;

    public SalesEmployee(final int employeeID,
           final String employeeName,
           final double employeeSalary,
           final String employeeBankAccountNumber,
           final String employeeNationalInsuranceNumber,
           final double commRate) {

        super(employeeID, employeeName, employeeSalary,
                employeeBankAccountNumber, employeeNationalInsuranceNumber);
        this.commissionRate = commRate;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(final double commRate) {
        this.commissionRate = commRate;
    }

}
