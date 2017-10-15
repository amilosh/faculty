package by.it.milosh.dao;

import by.it.milosh.pojos.UserCourse;

import java.util.List;

public interface UserCourseDao extends BaseDao<UserCourse> {

    List<UserCourse> getAllUserCourseByUserId(Long userId);

    void addCourseToUser(Long userId, Long courseId);

    List<UserCourse> getAllUserCourseByCourseId(Long courseId);

    List<UserCourse> checkTeacherCourse(Long courseId);

    List<UserCourse> getAllUserCourse();

}
