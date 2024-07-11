package org.example.daos;

import org.example.models.LoginRequest;
import org.example.models.User;

import java.sql.*;

public class AuthDao {
    public User getUser(final LoginRequest loginRequest) throws SQLException {
        try (Connection conn = DatabaseConnector.getConnection()) {
            String userLoginQuery = "SELECT username, password, roleID "
                                    + "FROM `Users` "
                                    + "WHERE username = ? AND password = ?;";

            assert conn != null;
            PreparedStatement statement = conn.prepareStatement(userLoginQuery);

            statement.setString(1, loginRequest.getUsername());
            statement.setString(2, loginRequest.getPassword());

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                return new User(
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getInt("roleID")
                );
            }
        }
        return null;
    }

    public void registerUser(LoginRequest loginRequest) throws SQLException {
        try(Connection connection = DatabaseConnector.getConnection()) {
            String query = "INSERT INTO `User`(Username, Password, RoleID)" +
                    "VALUES (?, ?, ?);";

            assert connection != null;
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, loginRequest.getUsername());
            statement.setString(2, loginRequest.getPassword());
            statement.setInt(3, 4);

            statement.executeUpdate();
        }
    }
}
