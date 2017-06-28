package by.it.milosh.daoImpl;

import by.it.milosh.dao.BaseDao;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Class describes standard CRUD methods.
 * @param <T> - type of persistent class
 */

@Repository(value = "baseDao")
public class BaseDaoImpl<T> implements BaseDao<T> {
    private static Logger logger = Logger.getLogger(BaseDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addEntity(T entity) {
        getSession().saveOrUpdate(entity);
    }

    @Override
    public void updateEntity(T entity) {
        getSession().update(entity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public T getEntityById(Class clazz, Serializable id) {
        T t = (T) getSession().get(clazz, id);
        return t;
    }

}
