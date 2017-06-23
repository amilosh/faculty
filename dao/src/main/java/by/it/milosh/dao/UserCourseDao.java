package by.it.milosh.dao;

import by.it.milosh.pojos.UserCourse;

import java.util.List;

public interface UserCourseDao extends BaseDao<UserCourse> {

    List<UserCourse> getAllUserCourseByUserId(Long user_id);

    void addCourseToUser(Long user_id, Long course_id);

    List<UserCourse> getAllUserCourseByCourseId(Long course_id);

    List<UserCourse> checkTeacherCourse(Long course_id);

    List<UserCourse> getAllUserCourse();

}
