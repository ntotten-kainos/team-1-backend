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
            @JsonProperty final String name,
            @JsonProperty final String nationalInsurance,
            @JsonProperty final int bankAccountNo,
            @JsonProperty final double salary) {
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
