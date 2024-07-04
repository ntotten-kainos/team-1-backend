package org.example.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao
{
    public List<String> testConnection() throws SQLException
    {   List<String> databases = new ArrayList<>();
        try (Connection connection = DatabaseConnector.getConnection())
        {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(
              "SHOW DATABAES;"
            );

            while (resultSet.next())
            {
                databases.add(resultSet.getString("Database"));
            }
        }
        return databases;
    }
}
