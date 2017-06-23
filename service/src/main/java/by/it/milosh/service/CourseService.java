package by.it.milosh.service;

import by.it.milosh.pojos.Course;

import java.util.List;

public interface CourseService extends BaseService<Course> {

    Course findCourseByName(String courseName);

    List<Course> getAllCourses();

}
