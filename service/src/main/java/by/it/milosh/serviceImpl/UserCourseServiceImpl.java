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

    @Override
    @Transactional(readOnly = true)
    public List<UserCourse> getAllUserCourse() {
        return userCourseDao.getAllUserCourse();
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserCourse> getAllUserCourseByUserId(String username) {
        Long userId = userDao.findUserByUsername(username).getUserId();
        return userCourseDao.getAllUserCourseByUserId(userId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserCourse> getAllUserCourseByUserId(Long userId) {
        return userCourseDao.getAllUserCourseByUserId(userId);
    }

    @Override
    public void addCourseToUser(Long userId, Long courseId) {
        userCourseDao.addCourseToUser(userId, courseId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserCourse> getAllUserCourseByCourseId(Long courseId) {
        return userCourseDao.getAllUserCourseByCourseId(courseId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserCourse> checkTeacherCourse(Long courseId) {
        return userCourseDao.checkTeacherCourse(courseId);
    }

}
