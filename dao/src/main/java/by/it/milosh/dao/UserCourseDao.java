package by.it.milosh.dao;

import by.it.milosh.pojos.UserCourse;

import java.util.List;

public interface UserCourseDao extends BaseDao<UserCourse> {

    /**
     * Determine all courses, on which specific user subscribed.
     * User is determined by user_id.
     * @param userId - user id
     * @return - all UserCurse, in which contained information about user's courses and his grades
     */
    List<UserCourse> getAllUserCourseByUserId(Long userId);

    /**
     * User is subscribing on course.
     * @param userId - user id
     * @param courseId - course id
     */
    void addCourseToUser(Long userId, Long courseId);

    /**
     * Extract all students, which subscribed on specific course.
     * Course is determined by course_id.
     * @param courseId - course id
     * @return - list of all UserCourse by course id
     */
    List<UserCourse> getAllUserCourseByCourseId(Long courseId);

    /**
     * Extract all teachers, which subscribed on specific course.
     * Course is determined by course_id.
     * @param courseId - course id
     * @return - list all courses which teacher teach
     */
    List<UserCourse> checkTeacherCourse(Long courseId);

    /**
     * Extract all UserCourse from DB.
     * @return list of all UserCourses
     */
    List<UserCourse> getAllUserCourse();

}
