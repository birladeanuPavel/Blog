package com.cazacioc.blog.dao.impl;

import com.cazacioc.blog.dao.EntryDao;
import com.cazacioc.blog.entity.Entry;
import org.springframework.stereotype.Repository;

/**
 * Created by scorpion on 09.08.14.
 */

@Repository
public class EntryDaoImpl extends GeneralDaoImpl<Entry> implements EntryDao {

    protected EntryDaoImpl() {
        super(Entry.class);
    }
}
