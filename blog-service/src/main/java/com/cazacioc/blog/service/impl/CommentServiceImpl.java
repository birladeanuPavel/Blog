package com.cazacioc.blog.service.impl;

import com.cazacioc.blog.dao.CommentDao;
import com.cazacioc.blog.dao.EntryDao;
import com.cazacioc.blog.entity.Comment;
import com.cazacioc.blog.entity.Entry;
import com.cazacioc.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by scorpion on 09.08.14.
 */
@Service
@Transactional(readOnly = true)
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private EntryDao entryDao;

    @Transactional(readOnly = false)
    @Override
    public void addComment(Comment comment) {
        commentDao.save(comment);
    }

    @Transactional(readOnly = false)
    @Override
    public void edit(Comment comment) {
        commentDao.update(comment);
    }

    @Override
    public List<Comment> getAllComments() {
        return commentDao.loadAll();
    }

    @Transactional(readOnly = false)
    @Override
    public void removeComment(Comment comment) {
        commentDao.delete(comment);
    }

    @Override
    public Comment getCommentById(Long id) {
        return commentDao.findById(id);
    }

    @Override
    @Transactional(readOnly = false)
    public void removeCommentByEntryIdAndCommentId(Long commentId, Long entryId) {
        Comment comment = commentDao.getCommentByEntryIdAndCommentId(entryId, commentId);
        if (comment != null) {
            commentDao.delete(comment);
        }
    }

    @Override
    @Transactional(readOnly = false)
    public void addCommentByEntryId(Comment comment, Long entryId) {
        comment.setEntry(entryDao.findById(entryId));
        comment.setDate(new Date());
        commentDao.save(comment);
    }

    @Override
    public List<Comment> getCommentsForEntry(Entry entry) {
        return commentDao.getCommentsForEntry(entry);
    }

    @Override
    public Comment getCommentByEntryIdAndCommentId(Long entryId, Long commentId) {
        return commentDao.getCommentByEntryIdAndCommentId(entryId, commentId);
    }
}
