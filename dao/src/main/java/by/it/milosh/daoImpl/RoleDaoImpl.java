package by.it.milosh.daoImpl;

import by.it.milosh.dao.RoleDao;
import by.it.milosh.pojos.Role;
import org.apache.log4j.Logger;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {
    private static Logger logger = Logger.getLogger(RoleDaoImpl.class);

    private final static String GET_ALL_ROLES = "from Role";

    @Override
    public Role getRoleByRoleName(String roleName) {
        return (Role) getSession()
                .createCriteria(Role.class)
                .add(Restrictions.eq("roleName", roleName))
                .uniqueResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Role> getAllRoles() {
        return getSession().createQuery(GET_ALL_ROLES).list();
    }

}
