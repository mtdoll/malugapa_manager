package com.malugapa.dao;

import com.malugapa.entities.Role;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoleDAOImpl implements RoleDAO {

    private static final String JDBC_URL = "jdbc:mariadb://localhost:3306/malugapa_db";
    private static final String JDBC_USER = "tu_usuario"; // Reemplaza con tu usuario de MariaDB
    private static final String JDBC_PASSWORD = "tu_contraseña"; // Reemplaza con tu contraseña de MariaDB

    public RoleDAOImpl() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            // Manejar la excepción apropiadamente
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    @Override
    public List<Role> getAllRoles() {
        List<Role> roles = new ArrayList<>();
        String sql = "SELECT role_id, role_name FROM roles";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Role role = new Role();
                role.setRoleId(rs.getInt("role_id"));
                role.setRoleName(rs.getString("role_name"));
                roles.add(role);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar la excepción apropiadamente
        }
        return roles;
    }

    @Override
    public Role getRoleById(int id) {
        Role role = null;
        String sql = "SELECT role_id, role_name FROM roles WHERE role_id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                role = new Role();
                role.setRoleId(rs.getInt("role_id"));
                role.setRoleName(rs.getString("role_name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar la excepción apropiadamente
        }
        return role;
    }

    @Override
    public Role getRoleByName(String name) {
        Role role = null;
        String sql = "SELECT role_id, role_name FROM roles WHERE role_name = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                role = new Role();
                role.setRoleId(rs.getInt("role_id"));
                role.setRoleName(rs.getString("role_name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar la excepción apropiadamente
        }
        return role;
    }

    @Override
    public void addRole(Role role) {
        String sql = "INSERT INTO roles (role_name) VALUES (?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, role.getRoleName());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar la excepción apropiadamente
        }
    }

    @Override
    public void updateRole(Role role) {
        String sql = "UPDATE roles SET role_name = ? WHERE role_id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, role.getRoleName());
            pstmt.setInt(2, role.getRoleId());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar la excepción apropiadamente
        }
    }

    @Override
    public void deleteRole(int id) {
        String sql = "DELETE FROM roles WHERE role_id = ?";

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