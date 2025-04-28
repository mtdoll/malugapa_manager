package com.malugapa.service;

import com.malugapa.dao.RoleDAO;
import com.malugapa.dao.RoleDAOImpl;
import com.malugapa.entities.Role;
import java.util.List;

/**
 *
 * @author mt
 */
public class RoleServiceImpl implements RoleService {
    private RoleDAO roleDAO = new RoleDAOImpl();
    
    @Override
    public List<Role> getAllRoles() {
        return roleDAO.getAllRoles();
    }
    
    @Override
    public Role getRoleById(int id) {
        return roleDAO.getRoleById(id);
    }
    
    @Override
    public Role getRoleByName(String name) {
        return roleDAO.getRoleByName(name);
    }
    
    @Override
    public void addRole(Role role) {
        roleDAO.addRole(role);
    }
    
    @Override
    public void updateRole(Role role) {
        roleDAO.updateRole(role);
    }
    
    @Override
    public void deleteRole(int id) {
        roleDAO.deleteRole(id);
    }
}
