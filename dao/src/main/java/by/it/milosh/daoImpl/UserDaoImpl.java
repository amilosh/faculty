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

    /**
     * Extrsct one user from DB by username.
     * @param username
     * @return
     */
    @Override
    public User findUserByUsername(String username) {
        Criteria criteria = getSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("username", username));
        User user = (User) criteria.uniqueResult();
        return user;
    }

    /**
     * Extract all users, which have specific role.
     * Role is determined by role name.
     * @param roleName
     * @return
     */
    @Override
    public List<User> getAllUserByRole(String roleName) {
        String hql = "select u from User u left join u.role r where r.roleName=:roleName";
        Query query = getSession().createQuery(hql);
        query.setParameter("roleName", roleName);
        List<User> users = query.list();
        System.out.println(users);
        return users;
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
        String hql = "select u from User u left join u.role r where r.roleName=:roleName";
        Query query = getSession().createQuery(hql);
        query.setParameter("roleName", roleName);
        int firstPage = 0;
        if (offset != null) {
            firstPage = offset;
        }
        query.setFirstResult(firstPage);
        int numberUsers = 10;
        if (maxResult != null) {
            numberUsers = maxResult;
        }
        query.setMaxResults(numberUsers);
        List<User> users = (List<User>) query.list();
        return users;
    }

    /**
     * Determine number of users, which has specific role.
     * Role is determined by role name.
     * @param roleName
     * @return
     */
    @Override
    public Long numberOfUsersByRole(String roleName) {
        String hql = "select count(u) from User u left join u.role r where r.roleName=:roleName";
        Query query = getSession().createQuery(hql);
        query.setParameter("roleName", roleName);
        Long numberOfUsers = (Long) query.uniqueResult();
        return numberOfUsers;
    }

    /**
     * Extract all Users from DB.
     * @return
     */
    @Override
    public List<User> getAllUsers() {
        String hql = "from User";
        Query query = getSession().createQuery(hql);
        List<User> users = query.list();
        return users;
    }

}
