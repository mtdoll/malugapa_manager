package com.malugapa.service;

import com.malugapa.entities.AttendanceLog;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author mt
 */
public interface AttendanceLogService {
    List<AttendanceLog> getAllAttendanceLogs();
    AttendanceLog getAttendanceLogById(int id);
    List<AttendanceLog> getAttendanceLogsByEmployeeId(int employeeId);
    List<AttendanceLog> getAttendanceLogsByDate(LocalDate date);
    List<AttendanceLog> getAttendanceLogsByEmployeeAndDate(int employee, LocalDate date);
    void addAttendanceLog(AttendanceLog log);
    void updateAttendanceLog(AttendanceLog log);
    void deleteAttendanceLog(int id);
}
