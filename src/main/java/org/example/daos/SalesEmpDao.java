package org.example.daos;

import org.example.models.SalesEmpRequest;
import org.example.models.SalesEmployee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class SalesEmpDao {

    /**
     * DAO method to insert a SalesEmployee record into the database.
     * @param salesEmpRequest is an object containing the data to be inserted.
     * @return an integer status code from the SQL execution.
     * @throws SQLException if insert fails.
     */
    public int createSalesEmployee(final SalesEmpRequest salesEmpRequest)
            throws SQLException {
        try (Connection connection = DatabaseConnector.getConnection()) {

            String insertStatement = "INSERT INTO `SalesEmployee`("
                    + "Name, BankAcctNum, NINO, Salary, CommissionRate"
                    + ")"
                    + "VALUES (?, ?, ?, ?, ?);";

            assert connection != null;
            PreparedStatement statement = connection.prepareStatement(
                    insertStatement, Statement.RETURN_GENERATED_KEYS
            );

            statement.setString(1, salesEmpRequest.getName());
            statement.setInt(2, salesEmpRequest.getBankAccountNo());
            statement.setString(3, salesEmpRequest.getNationalInsurance());
            statement.setDouble(4, salesEmpRequest.getSalary());
            statement.setDouble(5, salesEmpRequest.getCommissionRate());

            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        return -1;
    }

    public List<SalesEmployee> getAllSalesEmployees() throws SQLException {
        List<SalesEmployee> salesEmployees = new ArrayList<>();

        Connection connection = DatabaseConnector.getConnection();
        // Create db connection
        try {
            // statement obj that sends SQL statements to db
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(
                    "SELECT id, Name, BankAcctNum, NINO, Salary,"
                            + "CommissionRate FROM SalesEmployee;");

            // iterate throw each row of the result set
            while (resultSet.next()) {
                SalesEmployee employee = new SalesEmployee(
                        resultSet.getInt("id"),
                        resultSet.getString("Name"),
                        resultSet.getDouble("Salary"),
                        resultSet.getString("BankAcctNum"),
                        resultSet.getString("NINO"),
                        resultSet.getDouble("CommissionRate"));

                salesEmployees.add(employee);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connection.close();
        }

        return salesEmployees;
    }


}
