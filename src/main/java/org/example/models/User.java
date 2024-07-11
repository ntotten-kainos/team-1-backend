package org.example.models;

public class User {
    String username;
    String password;
    int roleID;

    public User(String username, String password, int roleID) {
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
