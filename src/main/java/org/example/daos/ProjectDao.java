package org.example.daos;

import org.example.models.ProjectRequest;

import java.sql.*;

public class ProjectDao {


    public int createProject(final ProjectRequest project) throws SQLException {


        try (Connection c = DatabaseConnector.getConnection()) {

            String insertStatement =
                    "INSERT INTO Project (projectName, "
                            + "projectValue, clientID) VALUES (?,?,?)";

            PreparedStatement st =
                    c.prepareStatement(insertStatement,
                            Statement.RETURN_GENERATED_KEYS);

            st.setString(1, project.getProjectName());
            st.setDouble(2, project.getProjectValue());
            st.setInt(3, project.getClientID());

            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
    return -1;
    }
}
