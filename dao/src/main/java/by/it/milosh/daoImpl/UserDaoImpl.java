package by.it.milosh.daoImpl;

import by.it.milosh.dao.UserDao;
import by.it.milosh.pojos.User;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
    private static Logger logger = Logger.getLogger(UserDaoImpl.class);

    private final String GET_ALL_USER_BY_ROLE = "select u from User u left join u.role r where r.roleName=:roleName";
    private final String GET_ALL_USER_BY_ROLE_PAGINATION = "select u from User u left join u.role r where r.roleName=:roleName";
    private final String NUMBER_OF_USERS_BY_ROLE = "select count(u) from User u left join u.role r where r.roleName=:roleName";
    private final String GET_ALL_USERS = "from User";

    /**
     * Extrsct one user from DB by username.
     * @param username
     * @return
     */
    @Override
    public User findUserByUsername(String username) {
        return (User) getSession().createCriteria(User.class).add(Restrictions.eq("username", username)).uniqueResult();
    }

    /**
     * Extract all users, which have specific role.
     * Role is determined by role name.
     * @param roleName
     * @return
     */
    @Override
    public List<User> getAllUserByRole(String roleName) {
        return getSession().createQuery(GET_ALL_USER_BY_ROLE).setParameter("roleName", roleName).list();
    }

    /**
     * Extract all users, which has specific role, using pagination.
     * Role is determined by role name.
     * @param offset - first record on the page
     * @param maxResult - number of record on the page
     * @param roleName
     * @return
     */
    @Override
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
     * @param roleName
     * @return
     */
    @Override
    public Long numberOfUsersByRole(String roleName) {
        return (Long) getSession().createQuery(NUMBER_OF_USERS_BY_ROLE).setParameter("roleName", roleName).uniqueResult();
    }

    /**
     * Extract all Users from DB.
     * @return
     */
    @Override
    public List<User> getAllUsers() {
        return getSession().createQuery(GET_ALL_USERS).list();
    }

}
