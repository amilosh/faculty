package by.it.milosh.service;

import by.it.milosh.pojos.Role;

import java.util.List;

public interface RoleService extends BaseService<Role> {

    /**
     * Extract one Role from DB by role name.
     * @param roleName - name of Role
     * @return - Role
     */
    Role getRoleByRoleName(String roleName);

    /**
     * Determine name of role, which user has.
     * User is determined by username.
     * @param username - username of User
     * @return - name of role
     */
    String getRoleNameByUsername(String username);

    /**
     * Extract all Roles from DB.
     * @return - list of all roles
     */
    List<Role> getAllRoles();

    /**
     * Add new role to database by its role name.
     * @param roleName - name of role
     * @return - entity Role
     */
    Role saveRoleByRoleName(String roleName);

}
