package by.it.milosh.service;

import by.it.milosh.pojos.Course;

import java.util.List;

public interface CourseService extends BaseService<Course> {

    /**
     * Extract one Course from DB by course name.
     * @param courseName - name of course
     * @return - course by its name
     */
    Course findCourseByName(String courseName);

    /**
     * Extract all Courses from DB.
     * @return - list of all courses
     */
    List<Course> getAllCourses();

}
