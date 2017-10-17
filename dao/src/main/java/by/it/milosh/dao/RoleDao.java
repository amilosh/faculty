package by.it.milosh.dao;

import by.it.milosh.pojos.Role;

import java.util.List;

public interface RoleDao extends BaseDao<Role> {

    /**
     * Extract one Role from DB by role name.
     * @param roleName - name of Role
     * @return - Role
     */
    Role getRoleByRoleName(String roleName);

    /**
     * Extract all Roles from DB.
     * @return - list of all roles
     */
    List<Role> getAllRoles();

}
