package by.it.milosh.serviceImpl;

import by.it.milosh.dao.BaseDao;
import by.it.milosh.service.BaseService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@Service(value = "baseService")
@Transactional
public class BaseServiceImpl<T> implements BaseService<T> {
    private static Logger logger = Logger.getLogger(BaseServiceImpl.class);

    @Autowired
    @Qualifier("baseDao")
    private BaseDao<T> baseDao;

    @Override
    public void addEntity(T entity) {
        baseDao.addEntity(entity);
    }

    @Override
    public void updateEntity(T entity) {
        baseDao.updateEntity(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public T getEntityById(Class clazz, Serializable id) {
        return baseDao.getEntityById(clazz, id);
    }

}
