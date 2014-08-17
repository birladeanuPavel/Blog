package com.cazacioc.blog.dao;

import org.hibernate.criterion.Criterion;

import java.io.Serializable;
import java.util.List;

/**
 * Created by scorpion on 08.07.14.
 */
public interface GeneralDao<E extends Serializable> {

    /**
     * Method that returns the number of entries from a table that meet some
     * criteria (where clause params)
     *
     * @param params sql parameters
     * @return the number of records meeting the criteria
     */

    public List<E> findByCriteria(Criterion criterion);

    public <E> List<E> loadAll();

    public void save(E e);

    public void update(E e);

    public void delete(E e);

    void deleteById(Long id);

    public E findById(Long id);

}