package by.it.milosh.dao;

import java.io.Serializable;

public interface BaseDao<T> {

    void addEntity(T entity);

    void updateEntity(T entity);

    T getEntityById(Class clazz, Serializable id);

}
