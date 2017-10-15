package by.it.milosh.daoImpl;

import by.it.milosh.Enums.RoleEnum;
import by.it.milosh.dao.UserCourseDao;
import by.it.milosh.pojos.Course;
import by.it.milosh.pojos.User;
import by.it.milosh.pojos.UserCourse;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserCourseDaoImpl extends BaseDaoImpl<UserCourse> implements UserCourseDao {
    private static Logger logger = Logger.getLogger(UserCourseDaoImpl.class);

    private final static String GET_ALL_USER_COURSE_BY_USER_ID = "from UserCourse uc where uc.user.userId=:userId";
    private final static String GET_ALL_USER_COURSE_BY_COURSE_ID = "from UserCourse uc where uc.course.courseId=:courseId and uc.user.role.roleName=:roleName";
    private final static String CHECK_TEACHER_COURSE = "from UserCourse uc where uc.course.courseId=:courseId and uc.user.role.roleName=:roleName";
    private final static String GET_ALL_USER_COURSE = "from UserCourse";

    /**
     * Determine all courses, on which specific user subscribed.
     * User is determined by user_id.
     * @param userId - user id
     * @return - all UserCurse, in which contained information about user's courses and his grades
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<UserCourse> getAllUserCourseByUserId(Long userId) {
        return getSession()
                .createQuery(GET_ALL_USER_COURSE_BY_USER_ID)
                .setParameter("userId", userId)
                .list();
    }

    /**
     * User is subscribing on course.
     * @param userId - user id
     * @param courseId - course id
     */
    @Override
    public void addCourseToUser(Long userId, Long courseId) {
        Session session = getSession();
        User user = (User) session.get(User.class, userId);
        Course course = (Course) session.get(Course.class, courseId);
        UserCourse userCourse = new UserCourse();
        userCourse.setUser(user);
        userCourse.setCourse(course);
        session.saveOrUpdate(userCourse);
    }

    /**
     * Extract all students, which subscribed on specific course.
     * Course is determined by course_id.
     * @param courseId - course id
     * @return - list of all UserCourse by course id
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<UserCourse> getAllUserCourseByCourseId(Long courseId) {
        return getSession()
                .createQuery(GET_ALL_USER_COURSE_BY_COURSE_ID)
                .setParameter("courseId", courseId)
                .setParameter("roleName", RoleEnum.STUDENT.getType())
                .list();
    }

    /**
     * Extract all teachers, which subscribed on specific course.
     * Course is determined by course_id.
     * @param courseId - course id
     * @return - list all courses which teacher teach
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<UserCourse> checkTeacherCourse(Long courseId) {
        return getSession()
                .createQuery(CHECK_TEACHER_COURSE)
                .setParameter("courseId", courseId)
                .setParameter("roleName", "ROLE_TEACHER")
                .list();
    }

    /**
     * Extract all UserCourse from DB.
     * @return list of all UserCourses
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<UserCourse> getAllUserCourse() {
        return getSession().createQuery(GET_ALL_USER_COURSE).list();
    }

}
