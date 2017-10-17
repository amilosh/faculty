package by.it.milosh.daoImpl;

import by.it.milosh.dao.CourseDao;
import by.it.milosh.pojos.Course;
import org.apache.log4j.Logger;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseDaoImpl extends BaseDaoImpl<Course> implements CourseDao {
    private static Logger logger = Logger.getLogger(CourseDaoImpl.class);

    private final static String GET_ALL_COURSES = "from Course";

    @Override
    public Course getCourseByName(String courseName) {
        return (Course) getSession()
                .createCriteria(Course.class)
                .add(Restrictions.eq("courseName", courseName))
                .uniqueResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Course> getAllCourses() {
        return getSession().createQuery(GET_ALL_COURSES).list();
    }

}
