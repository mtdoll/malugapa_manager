package com.malugapa.dao;

import com.malugapa.entities.AttendanceLog;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author mt
 */
public interface AttendanceLogDAO {
    List<AttendanceLog> getAllAttendanceLogs();
    AttendanceLog getAttendanceLogById(int id);
    List<AttendanceLog> getAttendanceLogsByEmployeeId(int employeeId);
    List<AttendanceLog> getAttendanceLogsByDate(LocalDate date);
    List<AttendanceLog> getAttendanceLogsByEmployeeAndDate(int employeeId, LocalDate date);
    void addAttendanceLog(AttendanceLog log);
    void updateAttendanceLog(AttendanceLog log);
    void deleteAttendanceLog(int id);
}
