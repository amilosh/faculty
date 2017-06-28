package by.it.milosh.dao;

import java.io.Serializable;

/**
 * The interface represents a standard set of functions
 * for Hibernate Session using parametrization
 * @param <T> - type of the inherited class
 */

public interface BaseDao<T> {

    void addEntity(T entity);

    void updateEntity(T entity);

    T getEntityById(Class clazz, Serializable id);

}
