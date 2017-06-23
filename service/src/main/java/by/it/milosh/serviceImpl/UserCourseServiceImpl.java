package by.it.milosh.serviceImpl;

import by.it.milosh.dao.UserCourseDao;
import by.it.milosh.dao.UserDao;
import by.it.milosh.pojos.UserCourse;
import by.it.milosh.service.UserCourseService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserCourseServiceImpl extends BaseServiceImpl<UserCourse> implements UserCourseService {
    private static Logger logger = Logger.getLogger(UserCourseServiceImpl.class);

    @Autowired
    private UserCourseDao userCourseDao;

    @Autowired
    private UserDao userDao;

    /**
     * Extract all UserCourse from DB.
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public List<UserCourse> getAllUserCourse() {
        return userCourseDao.getAllUserCourse();
    }

    /**
     * Determine all courses, on which specific user subscribed.
     * User is determined by username.
     * @param username
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public List<UserCourse> getAllUserCourseByUserId(String username) {
        Long user_id = userDao.findUserByUsername(username).getUser_id();
        return userCourseDao.getAllUserCourseByUserId(user_id);
    }

    /**
     * Determine all courses, on which specific user subscribed.
     * User is determined by user_id.
     * @param user_id
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public List<UserCourse> getAllUserCourseByUserId(Long user_id) {
        return userCourseDao.getAllUserCourseByUserId(user_id);
    }

    /**
     * User is subscribing on course.
     * @param user_id
     * @param course_id
     */
    @Override
    public void addCourseToUser(Long user_id, Long course_id) {
        userCourseDao.addCourseToUser(user_id, course_id);
    }

    /**
     * Extract all students, which subscribed on specific course.
     * Course is determined by course_id.
     * @param course_id
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public List<UserCourse> getAllUserCourseByCourseId(Long course_id) {
        return userCourseDao.getAllUserCourseByCourseId(course_id);
    }

    /**
     * Extract all teachers, which subscribed on specific course.
     * Course is determined by course_id.
     * @param course_id
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public List<UserCourse> checkTeacherCourse(Long course_id) {
        return userCourseDao.checkTeacherCourse(course_id);
    }

}
