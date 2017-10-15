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
     * @return - list af all UserCourse
     */
    @Override
    @Transactional(readOnly = true)
    public List<UserCourse> getAllUserCourse() {
        return userCourseDao.getAllUserCourse();
    }

    /**
     * Determine all courses, on which specific user subscribed.
     * User is determined by username.
     * @param username - name of user
     * @return - list of all UserCourses, on which specific user subscribed
     */
    @Override
    @Transactional(readOnly = true)
    public List<UserCourse> getAllUserCourseByUserId(String username) {
        Long userId = userDao.findUserByUsername(username).getUserId();
        return userCourseDao.getAllUserCourseByUserId(userId);
    }

    /**
     * Determine all courses, on which specific user subscribed.
     * User is determined by user_id.
     * @param userId - user id
     * @return - all UserCurse, in which contained information about user's courses and his grades
     */
    @Override
    @Transactional(readOnly = true)
    public List<UserCourse> getAllUserCourseByUserId(Long userId) {
        return userCourseDao.getAllUserCourseByUserId(userId);
    }

    /**
     * User is subscribing on course.
     * @param userId - user id
     * @param courseId - course id
     */
    @Override
    public void addCourseToUser(Long userId, Long courseId) {
        userCourseDao.addCourseToUser(userId, courseId);
    }

    /**
     * Extract all students, which subscribed on specific course.
     * Course is determined by course_id.
     * @param courseId - course id
     * @return - list of all students, which subscribed on specific course
     */
    @Override
    @Transactional(readOnly = true)
    public List<UserCourse> getAllUserCourseByCourseId(Long courseId) {
        return userCourseDao.getAllUserCourseByCourseId(courseId);
    }

    /**
     * Extract all teachers, which subscribed on specific course.
     * Course is determined by course_id.
     * @param courseId - course id
     * @return - list of all teachers, which subscribed on specific course
     */
    @Override
    @Transactional(readOnly = true)
    public List<UserCourse> checkTeacherCourse(Long courseId) {
        return userCourseDao.checkTeacherCourse(courseId);
    }

}
