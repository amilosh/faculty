package by.it.milosh.serviceImpl;

import by.it.milosh.dao.CourseDao;
import by.it.milosh.pojos.Course;
import by.it.milosh.service.CourseService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CourseServiceImpl extends BaseServiceImpl<Course> implements CourseService {
    private static Logger logger = Logger.getLogger(CourseServiceImpl.class);

    @Autowired
    private CourseDao courseDao;

    @Override
    @Transactional(readOnly = true)
    public Course findCourseByName(String courseName) {
        return courseDao.getCourseByName(courseName);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Course> getAllCourses() {
        return courseDao.getAllCourses();
    }

    @Override
    public Course saveCourseByCourseName(String courseName) {
        Course course = new Course();
        course.setCourseName(courseName);
        addEntity(course);
        return course;
    }
}
