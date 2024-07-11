package org.example.daos;

import org.example.models.DeliveryEmpRequest;
import org.example.models.DeliveryEmployee;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeliveryEmpDao {
    public int createDeliveryEmployee(
            final DeliveryEmpRequest deliveryEmpRequest)
            throws SQLException {
        try (Connection connection =
                     DatabaseConnector.getConnection()) {
            String insertStatement =
                    "INSERT INTO `DeliveryEmployee`"
                            + "(Name, BankAcctNum, NINO, Salary)"
                    + "VALUES (?, ?, ?, ?);";

            assert connection != null;
            PreparedStatement statement = connection
                    .prepareStatement(insertStatement, Statement
                            .RETURN_GENERATED_KEYS);

            statement.setString(1, deliveryEmpRequest.getName());
            statement.setInt(2, deliveryEmpRequest.getBankAccountNo());
            statement.setString(3, deliveryEmpRequest.getNationalInsurance());
            statement.setDouble(4, deliveryEmpRequest.getSalary());

            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        return -1;
    }
    public List<DeliveryEmployee> getAllDeliveryEmployees() throws SQLException{
        List<DeliveryEmployee> deliveryEmployees = new ArrayList<>();
        try(Connection connection = DatabaseConnector.getConnection()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT id, Name, BankAcctNum, NINO, Salary FROM DeliveryEmployee;");

            while(resultSet.next()){
                DeliveryEmployee deliveryEmployee = new DeliveryEmployee(
                        resultSet.getInt("id"),
                        resultSet.getString("Name"),
                        resultSet.getInt("BankAcctNum"),
                        resultSet.getString("NINO"),
                        resultSet.getString("Salary"));

                deliveryEmployees.add(deliveryEmployee);
            }

        }return deliveryEmployees;
    }
}
