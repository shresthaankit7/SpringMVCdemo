package com.ankit.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

/**
 * Created by ankit07 on 9/7/16.
 */
public abstract class AbstractDAO<PK extends Serializable,T> {

    private final Class<T> persistentClass;

    @SuppressWarnings("unchecked")
    public AbstractDAO(){
        this.persistentClass = (Class<T>)((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    public T getByKey(PK key){
        return (T) getSession().get(persistentClass,key);
    }

    public void persist(T entity){
        getSession().persist(entity);
    }

    public void delete(T entity){
        getSession().delete(entity);
    }

    protected Criteria createEntityCriteria(){
        return getSession().createCriteria(persistentClass);
    }
}

