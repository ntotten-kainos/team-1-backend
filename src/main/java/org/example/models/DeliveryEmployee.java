package org.example.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeliveryEmployee extends Employee {

    public DeliveryEmployee(     final int employeeID,
                                 final String employeeName,
                                 final double employeeSalary,
                                 final String employeeBankAccountNumber,
                                 final String employeeNationalInsuranceNumber) {

        super(employeeID, employeeName, employeeSalary,
                employeeBankAccountNumber, employeeNationalInsuranceNumber);
    }


}
