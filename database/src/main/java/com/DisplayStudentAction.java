package com;

import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DisplayStudentAction extends ActionSupport {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = ""; // Replace with actual password

    private List<Student> students = new ArrayList<>();

    @Override
    public String execute() {
        try (Connection c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement stmt = c.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM StudentsDetails")) {
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setAddress(rs.getString("address"));
                students.add(student);
            }
            return SUCCESS;
        } catch (SQLException e) {
            e.printStackTrace();
            addActionError("Database error occurred.");
            return ERROR;
        }
    }

    // Getters and setters
    public List<Student> getStudents() { return students; }
    public void setStudents(List<Student> students) { this.students = students; }
}
