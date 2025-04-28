package com.malugapa.service;

import com.malugapa.entities.Role;
import java.util.List;

/**
 *
 * @author mt
 */
public interface RoleService {
    List<Role> getAllRoles();
    Role getRoleById(int id);
    Role getRoleByName(String name);
    void addRole(Role role);
    void updateRole(Role role);
    void deleteRole(int id);
}
