package by.it.milosh.daoImpl;

import by.it.milosh.dao.RoleDao;
import by.it.milosh.pojos.Role;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {
    private static Logger logger = Logger.getLogger(RoleDaoImpl.class);

    /**
     * Extract one Role from DB by role name.
     * @param roleName
     * @return
     */
    @Override
    public Role getRoleByRoleName(String roleName) {
        Criteria criteria = getSession().createCriteria(Role.class);
        criteria.add(Restrictions.eq("roleName", roleName));
        return (Role) criteria.uniqueResult();
    }

    /**
     * Extract all Roles from DB.
     * @return
     */
    @Override
    public List<Role> getAllRoles() {
        String hql = "from Role";
        Query query = getSession().createQuery(hql);
        List<Role> roles = query.list();
        return roles;
    }

}
