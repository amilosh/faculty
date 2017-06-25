package by.it.milosh.daoImpl;

import by.it.milosh.dao.RoleDao;
import by.it.milosh.dao.UserDao;
import by.it.milosh.pojos.Role;
import by.it.milosh.pojos.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

@ContextConfiguration("/test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional()
public class UserDaoImplTest {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    private User user;
    private Role role;

    @Before
    public void setupRole(){
        Role r = new Role();
        r.setRoleName("ROLE_TEST");
        roleDao.addEntity(r);
        Role role = roleDao.getRoleByRoleName("ROLE_TEST");

        User customUser = new User();
        customUser.setUsername("testUsername");
        customUser.setPassword("testPassword");
        customUser.setRole(role);
        userDao.addEntity(customUser);
        User user = userDao.findUserByUsername(customUser.getUsername());

        this.user = user;
        this.role = role;
    }

    @Test
    public void findUserByUsernameTest() {
        User u = userDao.findUserByUsername(user.getUsername());
        assertNotNull(u);
    }


    @Test
    public void getAllUserByRoleTest() {
        List<User> users = userDao.getAllUserByRole(role.getRoleName());
        assertEquals(1, users.size());
    }

    @Test
    public void getAllUserByRolePaginationTest() {
        List<User> users = userDao.getAllUserByRolePagination(0, 5, role.getRoleName());
        assertEquals(1, users.size());
    }

    @Test
    public void numberOfUsersByRoleTest() {
        long numberOfUsers = userDao.numberOfUsersByRole(role.getRoleName());
        assertEquals(1L, numberOfUsers);
    }

    @Test
    public void getAllUsersTest() {
        List<User> users = userDao.getAllUsers();
        assertNotEquals(0, users.size());
    }

    @Test
    public void updateUserTest() {
        User innerUser = this.user;
        String usernameBefore = innerUser.getUsername();
        innerUser.setUsername("usernameAfter");
        userDao.updateEntity(innerUser);
        User innerUserBefore = userDao.findUserByUsername(innerUser.getUsername());
        String usernameAfter = innerUserBefore.getUsername();
        assertNotEquals(usernameBefore, usernameAfter);
    }

    @Test
    public void getUserByIdTest() {
        Long user_idBefore = user.getUser_id();
        User innerUser = userDao.findUserByUsername(user.getUsername());
        Long user_idAfter = innerUser.getUser_id();
        assertEquals(user_idBefore, user_idAfter);
    }

}
