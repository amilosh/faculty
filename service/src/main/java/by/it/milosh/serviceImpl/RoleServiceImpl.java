package by.it.milosh.serviceImpl;

import by.it.milosh.dao.RoleDao;
import by.it.milosh.dao.UserDao;
import by.it.milosh.pojos.Role;
import by.it.milosh.pojos.User;
import by.it.milosh.service.RoleService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {
    private static Logger logger = Logger.getLogger(RoleServiceImpl.class);

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private UserDao userDao;

    /**
     * Extract one Role from DB by role name.
     * @param roleName - name of Role
     * @return - Role
     */
    @Override
    @Transactional(readOnly = true)
    public Role getRoleByRoleName(String roleName) {
        return roleDao.getRoleByRoleName(roleName);
    }

    /**
     * Determine name of role, which user has.
     * User is determined by username.
     * @param username - username of User
     * @return - name of role
     */
    @Override
    @Transactional(readOnly = true)
    public String getRoleNameByUsername(String username) {
        User user = userDao.findUserByUsername(username);
        Role role = user.getRole();
        String roleName = role.getRoleName();
        return roleName;
    }

    /**
     * Extract all Roles from DB.
     * @return - list of all roles
     */
    @Override
    @Transactional(readOnly = true)
    public List<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }

}
