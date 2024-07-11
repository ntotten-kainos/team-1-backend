package org.example.mappers;

import org.example.models.SalesEmpResponse;
import org.example.models.SalesEmployee;

import java.util.List;
import java.util.stream.Collectors;

public class SalesEmpMapper {

    public static List<SalesEmpResponse>
    mapSalesEmployeeListToSalesEmployeeResponseList(
            final List<SalesEmployee> salesEmployees) {
        return salesEmployees.stream()
                .map(employee -> new SalesEmpResponse(employee.getEmployeeID(),
                        employee.getEmployeeName(),
                        employee.getEmployeeSalary(),
                        employee.getEmployeeBankAccountNumber(),
                        employee.getEmployeeNationalInsuranceNumber(),
                        employee.getCommissionRate()))
                .collect(Collectors.toList());


    }
}
