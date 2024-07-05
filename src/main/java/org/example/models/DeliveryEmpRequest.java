package org.example.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DeliveryEmpRequest {
    private String name;
    private String nationalInsurance;
    private int bankAccountNo;
    private double salary;

    @JsonCreator
    public DeliveryEmpRequest(
            @JsonProperty("Name") final String name,
            @JsonProperty("NationalInsuranceNumber")
            final String nationalInsurance,
            @JsonProperty("BankAccountNumber") final int bankAccountNo,
            @JsonProperty("Salary") final double salary) {
        this.name = name;
        this.nationalInsurance = nationalInsurance;
        this.bankAccountNo = bankAccountNo;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(final double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getNationalInsurance() {
        return nationalInsurance;
    }

    public void setNationalInsurance(final String nationalInsurance) {
        this.nationalInsurance = nationalInsurance;
    }

    public int getBankAccountNo() {
        return bankAccountNo;
    }

    public void setBankAccountNo(final int bankAccountNo) {
        this.bankAccountNo = bankAccountNo;
    }
}
