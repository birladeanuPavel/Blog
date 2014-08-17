package com.cazacioc.blog.dao;

import com.cazacioc.blog.entity.Comment;
import com.cazacioc.blog.entity.Entry;

import java.util.List;

/**
 * Created by scorpion on 09.08.14.
 */
public interface CommentDao extends GeneralDao<Comment>{

    List<Comment> getCommentsForEntry(Entry entry);

    Comment getCommentByEntryIdAndCommentId(Long entryId, Long commentId);
}
