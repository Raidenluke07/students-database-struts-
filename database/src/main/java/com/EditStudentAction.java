package com;

import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EditStudentAction extends ActionSupport {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "";

    private int id;
    private String name;
    private String address;

    @Override
    public String execute() {
        try (Connection c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = c.prepareStatement("SELECT * FROM StudentsDetails WHERE id = ?")) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    name = rs.getString("name");
                    address = rs.getString("address");
                    return SUCCESS;
                } else {
                    addActionError("Student not found.");
                    return ERROR;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            addActionError("Database error occurred.");
            return ERROR;
        }
    }

    public String update() {
        try (Connection c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = c.prepareStatement("UPDATE StudentsDetails SET name = ?, address = ? WHERE id = ?")) {
            pstmt.setString(1, name);
            pstmt.setString(2, address);
            pstmt.setInt(3, id);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                return SUCCESS;
            } else {
                addActionError("Update failed. Student not found.");
                return ERROR;
            }
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
