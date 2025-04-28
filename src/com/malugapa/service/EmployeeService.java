package com.malugapa.service;

import com.malugapa.entities.Employee;
import java.util.List;

/**
 *
 * @author mt
 */
public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(int id);
    void addEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(int id);
}
