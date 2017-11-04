package by.it.milosh.serviceImpl;

import by.it.milosh.Enums.RoleEnum;
import by.it.milosh.dao.RoleDao;
import by.it.milosh.dao.UserDao;
import by.it.milosh.pojos.Role;
import by.it.milosh.pojos.User;
import by.it.milosh.service.InitializeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class InitializeServiceImpl implements InitializeService {

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private UserDao userDao;

    @Override
    public void initializeRoles() {
        List<Role> roles = roleDao.getAllRoles();
        if (roles.isEmpty()) {
            roleDao.addEntity(new Role(RoleEnum.ADMIN.getType()));
            roleDao.addEntity(new Role(RoleEnum.STUDENT.getType()));
            roleDao.addEntity(new Role(RoleEnum.TEACHER.getType()));
        }
    }

    @Override
    public User initializeAdmin(User user) {
        Role role = roleDao.getRoleByRoleName(RoleEnum.ADMIN.getType());
        user.setRole(role);
        userDao.addEntity(user);
        return user;
    }
}
