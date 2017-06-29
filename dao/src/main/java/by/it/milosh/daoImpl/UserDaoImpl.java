package by.it.milosh.daoImpl;

import by.it.milosh.dao.UserDao;
import by.it.milosh.pojos.User;
import by.it.milosh.pojos.UserCourse;
import org.apache.log4j.Logger;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
    private static Logger logger = Logger.getLogger(UserDaoImpl.class);

    private final static String GET_ALL_USER_BY_ROLE = "select u from User u left join u.role r where r.roleName=:roleName";
    private final static String GET_ALL_USER_BY_ROLE_PAGINATION = "select u from User u left join u.role r where r.roleName=:roleName";
    private final static String NUMBER_OF_USERS_BY_ROLE = "select count(u) from User u left join u.role r where r.roleName=:roleName";
    private final static String GET_ALL_USERS = "from User";
    private final static String GET_USER_COURSE_BY_USER_ID = "from UserCourse uc where uc.user.user_id=:user_id";


    /**
     * Extrsct one user from DB by username.
     * @param username - name of user
     * @return - user by username
     */
    @Override
    public User findUserByUsername(String username) {
        return (User) getSession()
                .createCriteria(User.class)
                .add(Restrictions.eq("username", username))
                .uniqueResult();
    }

    /**
     * Extract all users, which have specific role.
     * Role is determined by role name.
     * @param roleName - name of role
     * @return - list of all users, who have this role
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllUserByRole(String roleName) {
        return getSession().createQuery(GET_ALL_USER_BY_ROLE).setParameter("roleName", roleName).list();
    }

    /**
     * Extract all users, which has specific role, using pagination.
     * Role is determined by role name.
     * @param offset - first record on the page
     * @param maxResult - number of record on the page
     * @param roleName - name of role
     * @return - list of users, who have this role, using pagination
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllUserByRolePagination(Integer offset, Integer maxResult, String roleName) {
        int firstPage = 0;
        if (offset != null) {
            firstPage = offset;
        }
        int numberUsers = 10;
        if (maxResult != null) {
            numberUsers = maxResult;
        }
        return (List<User>) getSession()
                .createQuery(GET_ALL_USER_BY_ROLE_PAGINATION)
                .setParameter("roleName", roleName)
                .setFirstResult(firstPage)
                .setMaxResults(numberUsers)
                .list();
    }

    /**
     * Determine number of users, which has specific role.
     * Role is determined by role name.
     * @param roleName - name of role
     * @return - number of user, who have this role
     */
    @Override
    public Long numberOfUsersByRole(String roleName) {
        return (Long) getSession()
                .createQuery(NUMBER_OF_USERS_BY_ROLE)
                .setParameter("roleName", roleName)
                .uniqueResult();
    }

    /**
     * Extract all Users from DB.
     * @return - list of all users
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        return getSession().createQuery(GET_ALL_USERS).list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deleteStudentById(Long user_id) {
        getSession().createQuery(GET_USER_COURSE_BY_USER_ID).setParameter("user_id", user_id);
        List<UserCourse> userCourses = getSession()
                .createQuery(GET_USER_COURSE_BY_USER_ID)
                .setParameter("user_id", user_id)
                .list();

        for (UserCourse userCourse : userCourses) {
            userCourse.setUser(null);
            userCourse.setCourse(null);
            getSession().delete(userCourse);
        }

        User user = (User) getSession().get(User.class, user_id);
        getSession().delete(user);

    }
}
