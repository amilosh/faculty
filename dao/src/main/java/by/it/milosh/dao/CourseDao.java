package by.it.milosh.dao;

import by.it.milosh.pojos.Course;

import java.util.List;

public interface CourseDao extends BaseDao<Course> {

    Course getCourseByName(String courseName);

    List<Course> getAllCourses();

}
