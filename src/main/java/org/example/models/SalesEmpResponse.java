package org.example.models;

public class SalesEmpResponse {

    private int id;
    private String name;
    private double salary;
    private String bankAccountNumber;
    private String natInsurance;
    private double commRate;

    public SalesEmpResponse(final int employeeId, final String name,
                                 final double salary,
                                 final String bankAccountNumber,
                                 final String natInsurance,
                                 final double commRate) {

        this.id = employeeId;
        this.name = name;
        this.salary = salary;
        this.bankAccountNumber = bankAccountNumber;
        this.natInsurance = natInsurance;
        this.commRate = commRate;
    }

    public double getCommRate() {
        return commRate;
    }

    public void setCommRate(final float commRate) {
        this.commRate = commRate;
    }

    public int getEmployeeId() {
        return id;
    }

    public void setEmployeeId(final int employeeId) {
        this.id = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(final double salary) {
        this.salary = salary;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(final String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getNatInsurance() {
        return natInsurance;
    }

    public void setNatInsurance(final String natInsurance) {
        this.natInsurance = natInsurance;
    }

}
