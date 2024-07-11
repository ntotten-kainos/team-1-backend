package org.example.services;

import io.jsonwebtoken.Jwts;
import org.example.daos.AuthDao;
import org.example.exceptions.Entity;
import org.example.exceptions.InvalidException;
import org.example.models.LoginRequest;
import org.example.models.User;

import java.security.Key;
import java.sql.Date;
import java.sql.SQLException;

public class AuthService {
    private final AuthDao authDao;
    private final Key authKey;

    public AuthService(AuthDao authDao, Key authKey) {
        this.authDao = authDao;
        this.authKey = authKey;
    }

    public String login(LoginRequest loginRequest)
        throws SQLException, InvalidException {
        User user = authDao.getUser(loginRequest);
        if (user == null) {
            throw new InvalidException(Entity.USER, "Invalid Credentials");
        }
        return generateJwtToken(user);
    }

    private String generateJwtToken(User user) {
        return Jwts.builder()
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 28800000))
                .claim("Role", user.getRoleID())
                .subject(user.getUsername())
                .issuer("Team1_Web_App")
                .signWith(authKey)
                .compact();
    }
}
