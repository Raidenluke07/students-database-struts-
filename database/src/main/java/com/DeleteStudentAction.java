package com;


import java.sql.ResultSet;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteStudentAction extends ActionSupport {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = ""; // Replace with actual password

    private int id;

    @Override
    public String execute() {
        try (Connection c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement checkStmt = c.prepareStatement("SELECT COUNT(*) FROM StudentsDetails WHERE id = ?")) {
            checkStmt.setInt(1, id);
            try (ResultSet rs = checkStmt.executeQuery()) {
                if (rs.next() && rs.getInt(1) == 0) {
                    addActionError("Student not found.");
                    return ERROR;
                }
            }

            // Delete student
            String deleteQuery = "DELETE FROM StudentsDetails WHERE id = ?";
            try (PreparedStatement pstmt = c.prepareStatement(deleteQuery)) {
                pstmt.setInt(1, id);
                pstmt.executeUpdate();
                return SUCCESS;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            addActionError("Database error occurred.");
            return ERROR;
        }
    }

    // Getter and setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
}
