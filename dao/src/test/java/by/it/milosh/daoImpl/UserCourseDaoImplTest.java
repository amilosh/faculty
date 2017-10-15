package by.it.milosh.daoImpl;

import by.it.milosh.dao.CourseDao;
import by.it.milosh.dao.RoleDao;
import by.it.milosh.dao.UserCourseDao;
import by.it.milosh.dao.UserDao;
import by.it.milosh.pojos.Course;
import by.it.milosh.pojos.Role;
import by.it.milosh.pojos.User;
import by.it.milosh.pojos.UserCourse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;

@ContextConfiguration("/test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional()
public class UserCourseDaoImplTest {

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private UserCourseDao userCourseDao;

    private Role commonRole;
    private User commonUser;
    private Course commonCourse;

    @Before
    public void setupUserCourse(){
        Role customRole = new Role();
        customRole.setRoleName("ROLE_TEST");
        roleDao.addEntity(customRole);
        Role role = roleDao.getRoleByRoleName("ROLE_TEST");

        User customUser = new User();
        customUser.setUsername("testUsername");
        customUser.setPassword("testPassword");
        customUser.setRole(role);
        userDao.addEntity(customUser);
        User user = userDao.findUserByUsername(customUser.getUsername());

        Course customCourse = new Course();
        customCourse.setCourseName("testCourse");
        courseDao.addEntity(customCourse);
        Course course = courseDao.getCourseByName(customCourse.getCourseName());

        //UserCourse userCourse = new UserCourse();
        //userCourse.setUser(user);
        //userCourse.setCourse(course);
        //userCourseDao.addEntity(userCourse);
        userCourseDao.addCourseToUser(user.getUserId(), course.getCourseId());

        this.commonRole = role;
        this.commonUser = user;
        this.commonCourse = course;
    }

    @Test
    public void getAllUserCourseByUserIdTest() {
        List<UserCourse> userCourses = userCourseDao.getAllUserCourseByUserId(commonUser.getUserId());
        assertEquals(1, userCourses.size());
    }

}
