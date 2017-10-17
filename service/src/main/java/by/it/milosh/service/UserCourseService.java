package by.it.milosh.service;

import by.it.milosh.pojos.UserCourse;

import java.util.List;

public interface UserCourseService extends BaseService<UserCourse> {

    /**
     * Extract all UserCourse from DB.
     * @return - list af all UserCourse
     */
    List<UserCourse> getAllUserCourse();

    /**
     * Determine all courses, on which specific user subscribed.
     * User is determined by username.
     * @param username - name of user
     * @return - list of all UserCourses, on which specific user subscribed
     */
    List<UserCourse> getAllUserCourseByUserId(String username);

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
     * @return - list of all students, which subscribed on specific course
     */
    List<UserCourse> getAllUserCourseByCourseId(Long courseId);

    /**
     * Extract all teachers, which subscribed on specific course.
     * Course is determined by course_id.
     * @param courseId - course id
     * @return - list of all teachers, which subscribed on specific course
     */
    List<UserCourse> checkTeacherCourse(Long courseId);

}
