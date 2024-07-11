package org.example.daos;

import org.example.models.LoginRequest;
import org.example.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthDao {
    public User getUser(LoginRequest loginRequest) throws SQLException {
        try (Connection conn = DatabaseConnector.getConnection()) {
            String userLoginQuery = "SELECT `username`, `password`, `roleID`" +
                                    "FROM `Users`" +
                                    "WHERE `username` = ?" +
                                    "AND `password` = ?;";
            assert conn != null;
            PreparedStatement statement = conn.prepareStatement(userLoginQuery);

            statement.setString(1, loginRequest.getUsername());
            statement.setString(2, loginRequest.getPassword());

            ResultSet userData = statement.executeQuery();

            while (userData.next()) {
                return new User(
                        userData.getString("username"),
                        userData.getString("password"),
                        userData.getInt("roleID")
                );
            }
        }
        return null;
    }
}
