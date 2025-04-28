package com.malugapa.dao;

import com.malugapa.entities.AttendanceLog;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AttendanceLogImpl implements AttendanceLogDAO {

    private static final String JDBC_URL = "jdbc:mariadb://localhost:3306/malugapa_db";
    private static final String JDBC_USER = "mt"; // Reemplaza con tu usuario de MariaDB
    private static final String JDBC_PASSWORD = "m3l4n33t@"; // Reemplaza con tu contraseña de MariaDB

    public AttendanceLogImpl() {
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
    public List<AttendanceLog> getAllAttendanceLogs() {
        List<AttendanceLog> logs = new ArrayList<>();
        String sql = "SELECT log_id, employee_id, log_date, log_time, event_type FROM attendance_log";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                AttendanceLog log = new AttendanceLog();
                log.setLogId(rs.getInt("log_id"));
                log.setEmployeeId(rs.getInt("employee_id"));
                log.setLogDate(rs.getDate("log_date").toLocalDate());
                log.setLogTime(rs.getTime("log_time").toLocalTime());
                log.setEventType(rs.getString("event_type"));
                logs.add(log);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar la excepción apropiadamente
        }
        return logs;
    }

    @Override
    public AttendanceLog getAttendanceLogById(int id) {
        AttendanceLog log = null;
        String sql = "SELECT log_id, employee_id, log_date, log_time, event_type FROM attendance_log WHERE log_id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                log = new AttendanceLog();
                log.setLogId(rs.getInt("log_id"));
                log.setEmployeeId(rs.getInt("employee_id"));
                log.setLogDate(rs.getDate("log_date").toLocalDate());
                log.setLogTime(rs.getTime("log_time").toLocalTime());
                log.setEventType(rs.getString("event_type"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar la excepción apropiadamente
        }
        return log;
    }

    @Override
    public List<AttendanceLog> getAttendanceLogsByEmployeeId(int employeeId) {
        List<AttendanceLog> logs = new ArrayList<>();
        String sql = "SELECT log_id, log_date, log_time, event_type FROM attendance_log WHERE employee_id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, employeeId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                AttendanceLog log = new AttendanceLog();
                log.setLogId(rs.getInt("log_id"));
                log.setEmployeeId(employeeId);
                log.setLogDate(rs.getDate("log_date").toLocalDate());
                log.setLogTime(rs.getTime("log_time").toLocalTime());
                log.setEventType(rs.getString("event_type"));
                logs.add(log);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar la excepción apropiadamente
        }
        return logs;
    }

    @Override
    public List<AttendanceLog> getAttendanceLogsByDate(LocalDate date) {
        List<AttendanceLog> logs = new ArrayList<>();
        String sql = "SELECT log_id, employee_id, log_time, event_type FROM attendance_log WHERE log_date = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDate(1, Date.valueOf(date));
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                AttendanceLog log = new AttendanceLog();
                log.setLogId(rs.getInt("log_id"));
                log.setEmployeeId(rs.getInt("employee_id"));
                log.setLogDate(date);
                log.setLogTime(rs.getTime("log_time").toLocalTime());
                log.setEventType(rs.getString("event_type"));
                logs.add(log);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar la excepción apropiadamente
        }
        return logs;
    }

    @Override
    public List<AttendanceLog> getAttendanceLogsByEmployeeAndDate(int employeeId, LocalDate date) {
        List<AttendanceLog> logs = new ArrayList<>();
        String sql = "SELECT log_id, log_time, event_type FROM attendance_log WHERE employee_id = ? AND log_date = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, employeeId);
            pstmt.setDate(2, Date.valueOf(date));
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                AttendanceLog log = new AttendanceLog();
                log.setLogId(rs.getInt("log_id"));
                log.setEmployeeId(employeeId);
                log.setLogDate(date);
                log.setLogTime(rs.getTime("log_time").toLocalTime());
                log.setEventType(rs.getString("event_type"));
                logs.add(log);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar la excepción apropiadamente
        }
        return logs;
    }

    @Override
    public void addAttendanceLog(AttendanceLog log) {
        String sql = "INSERT INTO attendance_log (employee_id, log_date, log_time, event_type) VALUES (?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, log.getEmployeeId());
            pstmt.setDate(2, Date.valueOf(log.getLogDate()));
            pstmt.setTime(3, Time.valueOf(log.getLogTime()));
            pstmt.setString(4, log.getEventType());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar la excepción apropiadamente
        }
    }

    @Override
    public void updateAttendanceLog(AttendanceLog log) {
        String sql = "UPDATE attendance_log SET employee_id = ?, log_date = ?, log_time = ?, event_type = ? WHERE log_id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, log.getEmployeeId());
            pstmt.setDate(2, Date.valueOf(log.getLogDate()));
            pstmt.setTime(3, Time.valueOf(log.getLogTime()));
            pstmt.setString(4, log.getEventType());
            pstmt.setInt(5, log.getLogId());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar la excepción apropiadamente
        }
    }

    @Override
    public void deleteAttendanceLog(int id) {
        String sql = "DELETE FROM attendance_log WHERE log_id = ?";

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