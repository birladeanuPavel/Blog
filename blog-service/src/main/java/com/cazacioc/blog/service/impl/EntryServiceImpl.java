package com.cazacioc.blog.service.impl;

import com.cazacioc.blog.dao.EntryDao;
import com.cazacioc.blog.entity.Entry;
import com.cazacioc.blog.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by scorpion on 09.08.14.
 */
@Service
@Transactional(readOnly = true)
public class EntryServiceImpl implements EntryService {

    @Autowired
    private EntryDao entryDao;

    @Override
    @Transactional(readOnly = false)
    public void addEntry(Entry entry) {
        entryDao.save(entry);
    }

    @Override
    @Transactional(readOnly = false)
    public void edit(Entry entry) {
        entryDao.update(entry);
    }

    @Override
    public List<Entry> getAllEntries() {
        return entryDao.loadAll();
    }

    @Override
    @Transactional(readOnly = false)
    public void removeEntry(Entry entry) {
        entryDao.delete(entry);
    }

    @Override
    public Entry getEntryById(Long id) {
        return entryDao.findById(id);
    }

    @Override
    public void removeEntryById(Long id) {

    }
}
