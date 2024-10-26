package com;

import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddStudentAction extends ActionSupport {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "";

    private int id;
    private String name;
    private String address;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("PostgreSQL JDBC Driver not found.");
        }
    }

    @Override
    public String execute() {
        try (Connection c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            // Check if ID already exists
            String checkQuery = "SELECT COUNT(*) FROM StudentsDetails WHERE id = ?";
            try (PreparedStatement checkStmt = c.prepareStatement(checkQuery)) {
                checkStmt.setInt(1, id);
                try (ResultSet rs = checkStmt.executeQuery()) {
                    if (rs.next() && rs.getInt(1) > 0) {
                        addActionError("ID already exists.");
                        return ERROR;
                    }
                }
            }

            // Insert new student
            String insertQuery = "INSERT INTO StudentsDetails (id, name, address) VALUES (?, ?, ?)";
            try (PreparedStatement pstmt = c.prepareStatement(insertQuery)) {
                pstmt.setInt(1, id);
                pstmt.setString(2, name);
                pstmt.setString(3, address);
                pstmt.executeUpdate();
            }
            return SUCCESS;
        } catch (SQLException e) {
            e.printStackTrace();
            addActionError("Database error occurred.");
            return ERROR;
        }
    }

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}
