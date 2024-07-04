package org.example.daos;

import org.example.models.Employee;
import org.example.models.EmployeeRequest;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

    public List<Employee> getAllEmployees() throws SQLException {
        List<Employee> employees = new ArrayList<>();

        try (Connection connection = DatabaseConnector.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "select employeeID, employeeName ,employeeSalary, "
                            + "employeeBankAccountNumber,"
                            + "employeeNationalInsuranceNumber,"
                            + "employeeCommissionRate from Employees;");

            while (resultSet.next()) {
                Employee order = new Employee(
                        resultSet.getInt(
                                "employeeID"),
                        resultSet.getString(
                                "employeeName"),
                        resultSet.getDouble(
                                "employeeSalary"),
                        resultSet.getString(
                                "employeeBankAccountNumber"),
                        resultSet.getString(
                                "employeeNationalInsuranceNumber"));

                employees.add(order);
            }
        }
        return employees;
    }

    public int createEmployee (final EmployeeRequest employeeRequest) throws SQLException {

        Connection connection = DatabaseConnector.getConnection();

        String insertStatement =
        "INSERT into `Employees`\n"
                + "(employeeName, employeeSalary,EmployeeBankAccountNumber, "
                + "employeeNationalInsuranceNumber,\n"
                + "values (?,?,?,?,?);";

        PreparedStatement st = connection.prepareStatement(insertStatement,
                Statement.RETURN_GENERATED_KEYS);

        st.setString(1, employeeRequest.getEmployeeName());
        st.setDouble(2, employeeRequest.getEmployeeSalary());
        st.setString(3, employeeRequest.getEmployeeBankAccountNumber());
        st.setString(4,employeeRequest.getEmployeeNationalInsuranceNumber());

        st.executeUpdate();

        ResultSet rs = st.getGeneratedKeys();

        if (rs.next()) {
            return rs.getInt(1);
        }
        return -1;
    }
}
