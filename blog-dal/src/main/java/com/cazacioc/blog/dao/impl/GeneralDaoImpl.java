package com.cazacioc.blog.dao.impl;

import com.cazacioc.blog.dao.GeneralDao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by scorpion on 08.07.14.
 */
@Repository
public abstract class GeneralDaoImpl<E extends Serializable> implements
        GeneralDao<E> {

    private Class<E> entityClass;

    protected GeneralDaoImpl(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    @Autowired
    private SessionFactory sessionFactory;

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();

    }

    @SuppressWarnings("unchecked")
    public List<E> findByCriteria(Criterion criterion) {
        Criteria criteria = getCurrentSession().createCriteria(entityClass);
        criteria.add(criterion);
        return criteria.list();
    }

    @SuppressWarnings("unchecked")
    public <E> List<E> loadAll() {
        final Criteria criteria = sessionFactory.getCurrentSession()
                .createCriteria(entityClass);
        return criteria.list();
    }

    public void save(E e) {
        getCurrentSession().save(e);
    }

    public void update(E e) {
        getCurrentSession().update(e);
    }

    public void delete(E e) {
        getCurrentSession().delete(e);
    }

    public void deleteById(Long id){
        getCurrentSession().delete(getCurrentSession().get(entityClass, id));
    }
    @SuppressWarnings("unchecked")
    public E findById(Long id) {
        return (E) getCurrentSession().get(entityClass, id);
    }

}
