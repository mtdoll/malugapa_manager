package com.malugapa.dao;

import com.malugapa.entities.Employee;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    private static final String JDBC_URL = "jdbc:mariadb://localhost:3306/malugapa_db";
    private static final String JDBC_USER = "tu_usuario"; // Reemplaza con tu usuario de MariaDB
    private static final String JDBC_PASSWORD = "tu_contraseña"; // Reemplaza con tu contraseña de MariaDB

    public EmployeeDAOImpl() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            // Manejar la excepción apropiadamente (e.g., lanzar una excepción personalizada)
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT employee_id, first_name, last_name_paternal, last_name_maternal, gender, role_id FROM employees";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Employee employee = new Employee();
                employee.setEmployeeId(rs.getInt("employee_id"));
                employee.setFirstName(rs.getString("first_name"));
                employee.setLastNamePaternal(rs.getString("last_name_paternal"));
                employee.setLastNameMaternal(rs.getString("last_name_maternal"));
                employee.setGender(rs.getString("gender"));
                employee.setRoleId(rs.getInt("role_id"));
                employees.add(employee);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar la excepción apropiadamente
        }
        return employees;
    }

    @Override
    public Employee getEmployeeById(int id) {
        Employee employee = null;
        String sql = "SELECT employee_id, first_name, last_name_paternal, last_name_maternal, gender, role_id FROM employees WHERE employee_id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                employee = new Employee();
                employee.setEmployeeId(rs.getInt("employee_id"));
                employee.setFirstName(rs.getString("first_name"));
                employee.setLastNamePaternal(rs.getString("last_name_paternal"));
                employee.setLastNameMaternal(rs.getString("last_name_maternal"));
                employee.setGender(rs.getString("gender"));
                employee.setRoleId(rs.getInt("role_id"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar la excepción apropiadamente
        }
        return employee;
    }

    @Override
    public void addEmployee(Employee employee) {
        String sql = "INSERT INTO employees (first_name, last_name_paternal, last_name_maternal, gender, role_id) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, employee.getFirstName());
            pstmt.setString(2, employee.getLastNamePaternal());
            pstmt.setString(3, employee.getLastNameMaternal());
            pstmt.setString(4, employee.getGender());
            pstmt.setInt(5, employee.getRoleId());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar la excepción apropiadamente
        }
    }

    @Override
    public void updateEmployee(Employee employee) {
        String sql = "UPDATE employees SET first_name = ?, last_name_paternal = ?, last_name_maternal = ?, gender = ?, role_id = ? WHERE employee_id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, employee.getFirstName());
            pstmt.setString(2, employee.getLastNamePaternal());
            pstmt.setString(3, employee.getLastNameMaternal());
            pstmt.setString(4, employee.getGender());
            pstmt.setInt(5, employee.getRoleId());
            pstmt.setInt(6, employee.getEmployeeId());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar la excepción apropiadamente
        }
    }

    @Override
    public void deleteEmployee(int id) {
        String sql = "DELETE FROM employees WHERE employee_id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar la excepción apropiadamente
        }
    }
}