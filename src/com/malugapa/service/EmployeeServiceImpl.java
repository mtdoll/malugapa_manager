package com.malugapa.service;

import com.malugapa.dao.EmployeeDAO;
import com.malugapa.dao.EmployeeDAOImpl;
import com.malugapa.entities.Employee;
import java.util.List;

/**
 *
 * @author mt
 */
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDAO employeeDAO = new EmployeeDAOImpl();
    
    @Override
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }
    
    @Override
    public Employee getEmployeeById(int id) {
        return employeeDAO.getEmployeeById(id);
    }
    
    @Override
    public void addEmployee(Employee employee) {
        // Aqui podriamos agregar validaciones antes de llamar al DAO
        employeeDAO.addEmployee(employee);
    }
    
    @Override
    public void updateEmployee(Employee employee) {
        // Aqui podriamos agregar validaciones
        employeeDAO.updateEmployee(employee);
    }
    
    @Override
    public void deleteEmployee(int id) {
        // Aqui podriamos agregar logica antes o despues de la eliminacion
        employeeDAO.deleteEmployee(id);
    }
}
