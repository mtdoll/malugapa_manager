package com.malugapa.dao;

import com.malugapa.entities.Role;
import java.util.List;
/**
 *
 * @author mt
 */
public interface RoleDAO {
    List<Role> getAllRoles();
    Role getRoleById(int id);
    Role getRoleByName(String name);
    void addRole(Role role);
    void updateRole(Role role);
    void deleteRole(int id);
}
