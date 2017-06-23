package by.it.milosh.service;

import java.io.Serializable;

public interface BaseService<T> {

    void addEntity(T entity);

    void updateEntity(T entity);

    T getEntityById(Class clazz, Serializable id);

}
