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

    private final static String GET_ALL_USER_COURSE_BY_USER_ID = "from UserCourse uc where uc.user.user_id=:user_id";
    private final static String GET_ALL_USER_COURSE_BY_COURSE_ID = "from UserCourse uc where uc.course.course_id=:course_id and uc.user.role.roleName=:roleName";
    private final static String CHECK_TEACHER_COURSE = "from UserCourse uc where uc.course.course_id=:course_id and uc.user.role.roleName=:roleName";
    private final static String GET_ALL_USER_COURSE = "from UserCourse";

    /**
     * Determine all courses, on which specific user subscribed.
     * User is determined by user_id.
     * @param user_id
     * @return
     */
    @Override
    public List<UserCourse> getAllUserCourseByUserId(Long user_id) {
        return getSession()
                .createQuery(GET_ALL_USER_COURSE_BY_USER_ID)
                .setParameter("user_id", user_id)
                .list();
    }

    /**
     * User is subscribing on course.
     * @param user_id
     * @param course_id
     */
    @Override
    public void addCourseToUser(Long user_id, Long course_id) {
        Session session = getSession();
        User user = (User) session.get(User.class, user_id);
        Course course = (Course) session.get(Course.class, course_id);
        UserCourse userCourse = new UserCourse();
        userCourse.setUser(user);
        userCourse.setCourse(course);
        session.saveOrUpdate(userCourse);
    }

    /**
     * Extract all students, which subscribed on specific course.
     * Course is determined by course_id.
     * @param course_id
     * @return
     */
    @Override
    public List<UserCourse> getAllUserCourseByCourseId(Long course_id) {
        return getSession()
                .createQuery(GET_ALL_USER_COURSE_BY_COURSE_ID)
                .setParameter("course_id", course_id)
                .setParameter("roleName", RoleEnum.STUDENT.getType())
                .list();
    }

    /**
     * Extract all teachers, which subscribed on specific course.
     * Course is determined by course_id.
     * @param course_id
     * @return
     */
    @Override
    public List<UserCourse> checkTeacherCourse(Long course_id) {
        return getSession()
                .createQuery(CHECK_TEACHER_COURSE)
                .setParameter("course_id", course_id)
                .setParameter("roleName", "ROLE_TEACHER")
                .list();
    }

    /**
     * Extract all UserCourse from DB.
     * @return list of all UserCourses
     */
    @Override
    public List<UserCourse> getAllUserCourse() {
        return getSession().createQuery(GET_ALL_USER_COURSE).list();
    }

}
