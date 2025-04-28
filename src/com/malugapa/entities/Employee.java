
package com.malugapa.entities;

/**
 *
 * @author mt
 */
public class Employee {
    private int employeeId;
    private String firstName;
    private String lastNamePaternal;
    private String lastNameMaternal;
    private String gender;
    private int roleId; // Clave Foranea a la tabla 'roles'
    
    // Constructor(es)
    public Employee() {
    }
    
    public Employee(int employeeId, String firstName, String lastNamePaternal, String lastNameMaternal, String gender, int roleId) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastNamePaternal = lastNamePaternal;
        this.lastNameMaternal = lastNameMaternal;
        this.gender = gender;
        this.roleId = roleId;
    }
    
    // Getters y setters para todos los atributos
    public int getEmployeeId(){
        return employeeId;
    }
    
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastNamePaternal() {
        return lastNamePaternal;
    }
    
    public void setLastNamePaternal(String lastNamePaternal) {
        this.lastNamePaternal = lastNamePaternal;
    }
    
    public String getLastNameMaternal() {
        return lastNameMaternal;
    }
    
    public void setLastNameMaternal(String lastNameMaternal){
        this.lastNameMaternal = lastNameMaternal;
    }
    
    public String getGender() {
        return gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public int getRoleId() {
        return roleId;
    }
    
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
    
    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastNamePaternal='" + lastNamePaternal + '\'' +
                ", lastNameMaternal='" + lastNameMaternal + '\'' +
                ", gender='" + gender + '\'' +
                ", roleId=" + roleId +
                '}';
    }
}
