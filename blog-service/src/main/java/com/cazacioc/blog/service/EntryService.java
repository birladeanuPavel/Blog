package com.cazacioc.blog.service;

import com.cazacioc.blog.entity.Entry;

import java.util.List;

/**
 * Created by scorpion on 09.08.14.
 */
public interface EntryService {

    public void addEntry(Entry entry);

    public void edit(Entry entry);

    public List<Entry> getAllEntries();

    public void removeEntry(Entry entry);

    public Entry getEntryById(Long id);

    void removeEntryById(Long id);
}
