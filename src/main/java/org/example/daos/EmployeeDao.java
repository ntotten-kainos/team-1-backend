package org.example.daos;

import org.example.models.EmployeeRequest;

import java.sql.*;

public class EmployeeDao {

    public int createEmployee(final EmployeeRequest employeeRequest)
            throws SQLException {
        try (Connection connection = DatabaseConnector.getConnection()) {

            String insertStatement =
                    "INSERT into `Employees`\n"
                            + "(employeeName, "
                            + "employeeSalary,"
                            + "EmployeeBankAccountNumber, "
                            + "employeeNationalInsuranceNumber,\n"
                            + "values (?,?,?,?,?);";

            PreparedStatement st = connection.prepareStatement(insertStatement,
                    Statement.RETURN_GENERATED_KEYS);

            st.setString(1,
                    employeeRequest.getEmployeeName());
            st.setDouble(2,
                    employeeRequest.getEmployeeSalary());
            st.setString(3,
                    employeeRequest.getEmployeeBankAccountNumber());
            st.setString(4,
                    employeeRequest.getEmployeeNationalInsuranceNumber());

            st.executeUpdate();

            ResultSet rs = st.getGeneratedKeys();

            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        return -1;
    }
}
