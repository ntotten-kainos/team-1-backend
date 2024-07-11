package org.example.models;

public class User {
    private final String username;
    private final String password;
    private final int roleID;

    public User(final String username, final String password, final int roleID) {
        this.username = username;
        this.password = password;
        this.roleID = roleID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getRoleID() {
        return roleID;
    }
}
