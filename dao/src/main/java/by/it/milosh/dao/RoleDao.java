package by.it.milosh.dao;

import by.it.milosh.pojos.Role;

import java.util.List;

public interface RoleDao extends BaseDao<Role> {

    Role getRoleByRoleName(String roleName);

    List<Role> getAllRoles();

}
