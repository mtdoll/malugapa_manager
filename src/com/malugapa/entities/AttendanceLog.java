package com.malugapa.entities;
import java.time.LocalDate;
import java.time.LocalTime;
/**
 *
 * @author mt
 */
public class AttendanceLog {
    private int logId;
    private int employeeId;
    private LocalDate logDate;
    private LocalTime logTime;
    private String eventType;               // 'IN' u 'OUT'
    
    // Constructor(es)
    public AttendanceLog() {
    }
    
    public AttendanceLog(int logId, int employeeId, LocalDate logDate, LocalTime logTime, String eventType) {
        this.logId = logId;
        this.employeeId = employeeId;
        this.logDate = logDate;
        this.logTime = logTime;
        this.eventType = eventType;
    }
    
    // Getters y setters
    public int getLogId() {
        return logId;
    }
    
    public void setLogID(int logId) {
        this.logId = logId;
    }
    
    public int getEmployeeId() {
        return employeeId;
    }
    
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    
    public LocalDate getLogDate() {
        return logDate;
    }
    
    public void setLogDate(LocalDate logDate) {
        this.logDate = logDate;
    }
    
    public LocalTime getLogTime() {
        return logTime;
    }
   
    public void setLogTime(LocalTime logTime) {
        this.logTime = logTime;
    }
    
    public String getEventType() {
        return eventType;
    }
    
    public void setEventType(String eventType) {
        this.eventType = eventType;
    }
    
    @Override
    public String toString() {
        return "AttendanceLog{" +
                "logId=" + logId +
                ", employeeId=" + employeeId +
                ", logDate=" + logDate +
                ", logTime=" + logTime +
                ", eventType='" + eventType + '\'' +
                '}';
    }

    public void setLogId(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
