package org.example.daos;

import org.example.models.Employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao
{

    public List<Employee> getAllEmployees() throws SQLException {
        List<Employee> employees = new ArrayList<>();

        try(Connection connection = DatabaseConnector.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "select employeeID, employeeName ,employeeSalary, employeeBankAccountNumber,employeeNationalInsuranceNumber,employeeCommissionRate from Employees ;";"

            while (resultSet.next()) {
                Employee order = new Employee(
                        resultSet.getInt("employeeID"),
                        resultSet.getString("employeeName"),
                        resultSet.getDouble("employeeSalary"),
                        resultSet.getString("employeeBankAccountNumber"),
                        resultSet.getString("employeeNationalInsuranceNumber"),
                        resultSet.getDouble("employeeCommissionRate"));

                employees.add(order);
            }
        }

        return employees;
    }
}
