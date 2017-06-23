package by.it.milosh.daoImpl;

import by.it.milosh.dao.CourseDao;
import by.it.milosh.pojos.Course;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseDaoImpl extends BaseDaoImpl<Course> implements CourseDao {
    private static Logger logger = Logger.getLogger(CourseDaoImpl.class);

    /**
     * Extract one Course from DB by course name.
     * @param courseName
     * @return
     */
    @Override
    public Course getCourseByName(String courseName) {
        Criteria criteria = getSession().createCriteria(Course.class);
        criteria.add(Restrictions.eq("courseName", courseName));
        return (Course) criteria.uniqueResult();
    }

    /**
     * Extract all Courses from DB.
     * @return
     */
    @Override
    public List<Course> getAllCourses() {
        String hql = "from Course";
        Query query = getSession().createQuery(hql);
        List<Course> courses = query.list();
        return courses;
    }

}
