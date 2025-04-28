
package com.malugapa.entities;

/**
 *
 * @author mt
 */
public class Role {
    private int roleId;
    private String roleName;
    
    // Constructor(es)
    public Role() {
    }
    
    public Role (int roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }
    
    // Getters y setters
    public int getRoleId() {
        return roleId;
    }
    
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
    
    public String getRoleName() {
        return roleName;
    }
    
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    
    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
