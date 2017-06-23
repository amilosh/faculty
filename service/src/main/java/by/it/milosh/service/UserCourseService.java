package by.it.milosh.service;

import by.it.milosh.pojos.UserCourse;

import java.util.List;

public interface UserCourseService extends BaseService<UserCourse> {

    List<UserCourse> getAllUserCourse();

    List<UserCourse> getAllUserCourseByUserId(String username);

    List<UserCourse> getAllUserCourseByUserId(Long user_id);

    void addCourseToUser(Long user_id, Long course_id);

    List<UserCourse> getAllUserCourseByCourseId(Long course_id);

    List<UserCourse> checkTeacherCourse(Long course_id);

}
