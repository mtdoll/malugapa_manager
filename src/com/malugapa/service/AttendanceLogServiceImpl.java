package com.malugapa.service;

import com.malugapa.dao.AttendanceLogDAO;
import com.malugapa.dao.AttendanceLogImpl;
import com.malugapa.entities.AttendanceLog;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author mt
 */
public class AttendanceLogServiceImpl implements AttendanceLogService{
    private AttendanceLogDAO attendanceLogDAO = new AttendanceLogImpl();
    
    @Override
    public List<AttendanceLog> getAllAttendanceLogs() {
        return attendanceLogDAO.getAllAttendanceLogs();
    }
    
    @Override
    public AttendanceLog getAttendanceLogById(int id) {
        return attendanceLogDAO.getAttendanceLogById(id);
    }
    
    @Override
    public List<AttendanceLog> getAttendanceLogsByEmployeeId(int employeeId) {
        return attendanceLogDAO.getAttendanceLogsByEmployeeId(employeeId);
    }
    
    @Override
    public List<AttendanceLog> getAttendanceLogsByDate(LocalDate date) {
        return attendanceLogDAO.getAttendanceLogsByDate(date);
    }
    
    @Override
    public List<AttendanceLog> getAttendanceLogsByEmployeeAndDate(int employeeId, LocalDate date) {
        return attendanceLogDAO.getAttendanceLogsByEmployeeAndDate(employeeId, date);
    }
    
    @Override
    public void addAttendanceLog(AttendanceLog log) {
        attendanceLogDAO.addAttendanceLog(log);
    }
    
    @Override
    public void updateAttendanceLog(AttendanceLog log) {
        attendanceLogDAO.updateAttendanceLog(log);
    }
    
    @Override
    public void deleteAttendanceLog(int id) {
        attendanceLogDAO.deleteAttendanceLog(id);
    }
}
