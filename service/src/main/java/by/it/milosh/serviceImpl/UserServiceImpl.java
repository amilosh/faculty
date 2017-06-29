package by.it.milosh.serviceImpl;

import by.it.milosh.dao.CourseDao;
import by.it.milosh.dao.RoleDao;
import by.it.milosh.dao.UserCourseDao;
import by.it.milosh.dao.UserDao;
import by.it.milosh.pojos.Course;
import by.it.milosh.pojos.User;
import by.it.milosh.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
    private static Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private UserCourseDao userCourseDao;

    /**
     * Extract all Users from DB.
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    /**
     * Extrsct one user from DB by username.
     * @param username
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public User findUserByUsername(String username) {
        return userDao.findUserByUsername(username);
    }

    /**
     * Extract all Users by his role.
     * @param roleName
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUserByRole(String roleName) {
        return userDao.getAllUserByRole(roleName);
    }

    /**
     * Extract all course names from DB.
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public List<String> getAllCourseNames() {
        List<Course> courses = courseDao.getAllCourses();
        List<String> courseNames = new ArrayList<String>();
        for (int i=0; i<courses.size(); i++) {
            String cN = courses.get(i).getCourseName();
            courseNames.add(cN);
        }
        return courseNames;
    }

    /**
     * User is subscribing on course.
     * @param username
     * @param courseName
     */
    @Override
    public void addCourseToUser(String username, String courseName) {
        Long user_id = userDao.findUserByUsername(username).getUser_id();
        Long course_id = courseDao.getCourseByName(courseName).getCourse_id();
        userCourseDao.addCourseToUser(user_id, course_id);
    }

    /**
     * Extract all users, which has specific role, using pagination.
     * Role is determined by role name.
     * @param offset - first record on the page
     * @param maxResult - number of record on the page
     * @param roleName
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUserByRolePagination(Integer offset, Integer maxResult, String roleName) {
        return userDao.getAllUserByRolePagination(offset, maxResult, roleName);
    }

    /**
     * Determine number of users, which has specific role.
     * Role is determined by role name.
     * @param roleName
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public Long numberOfUsersByRole(String roleName) {
        return userDao.numberOfUsersByRole(roleName);
    }

    @Override
    public void deleteStudentById(Long user_id) {
        userDao.deleteStudentById(user_id);
    }
}
