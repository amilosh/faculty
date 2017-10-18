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

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    @Transactional(readOnly = true)
    public User findUserByUsername(String username) {
        return userDao.findUserByUsername(username);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUserByRole(String roleName) {
        return userDao.getAllUserByRole(roleName);
    }

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

    @Override
    public void addCourseToUser(String username, String courseName) {
        Long userId = userDao.findUserByUsername(username).getUserId();
        Long courseId = courseDao.getCourseByName(courseName).getCourseId();
        userCourseDao.addCourseToUser(userId, courseId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUserByRolePagination(Integer offset, Integer maxResult, String roleName) {
        return userDao.getAllUserByRolePagination(offset, maxResult, roleName);
    }

    @Override
    @Transactional(readOnly = true)
    public Long numberOfUsersByRole(String roleName) {
        return userDao.numberOfUsersByRole(roleName);
    }

    @Override
    public void deleteStudentById(Long userId) {
        userDao.deleteStudentById(userId);
    }

    @Override
    public void deleteStudentByUsername(String username) {
        User user = userDao.findUserByUsername(username);
        userDao.deleteStudentById(user.getUserId());
    }
}
