package by.it.milosh.dao;

import by.it.milosh.pojos.Course;

import java.util.List;

public interface CourseDao extends BaseDao<Course> {

    /**
     * Extract one Course from DB by course name.
     * @param courseName - name of course
     * @return - course by its name
     */
    Course getCourseByName(String courseName);

    /**
     * Extract all Courses from DB.
     * @return - list of all courses
     */
    List<Course> getAllCourses();

}
