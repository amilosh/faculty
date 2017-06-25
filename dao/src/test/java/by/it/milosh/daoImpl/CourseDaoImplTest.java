package by.it.milosh.daoImpl;

import by.it.milosh.dao.CourseDao;
import by.it.milosh.pojos.Course;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertNotNull;

@ContextConfiguration("/test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional()
public class CourseDaoImplTest {

    @Autowired
    private CourseDao courseDao;

    private Course commonCourse;

    @Before
    public void setupUserCourse(){
        Course customCourse = new Course();
        customCourse.setCourseName("testCourse");
        courseDao.addEntity(customCourse);
        Course course = courseDao.getCourseByName(customCourse.getCourseName());

        this.commonCourse = course;
    }

    @Test
    public void getCourseByNameTest() {
        Course course = courseDao.getCourseByName(commonCourse.getCourseName());
        assertNotNull(course);
    }

}
