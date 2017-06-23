package by.it.milosh.service;

import by.it.milosh.pojos.Role;

import java.util.List;

public interface RoleService extends BaseService<Role> {

    Role getRoleByRoleName(String roleName);

    String getRoleNameByUsername(String username);

    List<Role> getAllRoles();

}
