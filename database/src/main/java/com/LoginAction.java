package com;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
    private static final String DEFAULT_USERNAME = "admin";
    private static final String DEFAULT_PASSWORD = "12345"; // Replace with your default password

    private String username;
    private String password;

    @Override
    public String execute() {
        if (DEFAULT_USERNAME.equals(username) && DEFAULT_PASSWORD.equals(password)) {
            return "success"; // Indicating successful login
        } else {
            addActionError("Invalid username or password.");
            return ERROR;
        }
    }

    public String redirectToDisplay() {
        // This method is to handle redirection after login
        return "redirectToDisplay";
    }

    // Getters and setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
