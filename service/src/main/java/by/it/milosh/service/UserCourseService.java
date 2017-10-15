package by.it.milosh.service;

import by.it.milosh.pojos.UserCourse;

import java.util.List;

public interface UserCourseService extends BaseService<UserCourse> {

    List<UserCourse> getAllUserCourse();

    List<UserCourse> getAllUserCourseByUserId(String username);

    List<UserCourse> getAllUserCourseByUserId(Long userId);

    void addCourseToUser(Long userId, Long courseId);

    List<UserCourse> getAllUserCourseByCourseId(Long courseId);

    List<UserCourse> checkTeacherCourse(Long courseId);

}
