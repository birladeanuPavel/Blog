package com.cazacioc.blog.service;

import com.cazacioc.blog.entity.Comment;
import com.cazacioc.blog.entity.Entry;

import java.util.List;

/**
 * Created by scorpion on 09.08.14.
 */
public interface CommentService {

    public void addComment(Comment comment);

    public void edit(Comment comment);

    public List<Comment> getAllComments();

    public void removeComment(Comment comment);

    public Comment getCommentById(Long id);

    void removeCommentByEntryIdAndCommentId(Long commentId, Long entryId);

    void addCommentByEntryId(Comment comment, Long entryId);

    List<Comment> getCommentsForEntry(Entry entry);

    Comment getCommentByEntryIdAndCommentId(Long entryId, Long commentId);
}
