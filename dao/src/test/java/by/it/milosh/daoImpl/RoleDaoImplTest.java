package by.it.milosh.daoImpl;

import by.it.milosh.dao.RoleDao;
import by.it.milosh.pojos.Role;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertNotNull;

@ContextConfiguration("/test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional()
public class RoleDaoImplTest {

    @Autowired
    private RoleDao roleDao;

    private Role commonRole;

    @Before
    public void setupUserCourse(){
        Role customRole = new Role();
        customRole.setRoleName("ROLE_TEST");
        roleDao.addEntity(customRole);
        Role role = roleDao.getRoleByRoleName("ROLE_TEST");

        this.commonRole = role;
    }

    @Test
    public void getRoleByRoleNameTest() {
        Role role = roleDao.getRoleByRoleName(commonRole.getRoleName());
        assertNotNull(role);
    }

}
