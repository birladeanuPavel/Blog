package com.cazacioc.blog.dao.impl;

import com.cazacioc.blog.dao.CommentDao;
import com.cazacioc.blog.entity.Comment;
import com.cazacioc.blog.entity.Entry;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by scorpion on 09.08.14.
 */
@Repository
public class CommentDaoImpl extends GeneralDaoImpl<Comment> implements CommentDao {

    protected CommentDaoImpl() {
        super(Comment.class);
    }

    @Override
    public List<Comment> getCommentsForEntry(Entry entry) {
        return getCurrentSession()
                .createCriteria(Comment.class)
                .add(Restrictions.eq("entry", entry))
                .addOrder(Order.asc("date"))
                .list();
    }

    @Override
    public Comment getCommentByEntryIdAndCommentId(Long entryId, Long commentId) {
        return (Comment) getCurrentSession()
                .createCriteria(Comment.class)
                .add(
                        Restrictions.and(
                                Restrictions.eq("entry.id", entryId),
                                Restrictions.eq("id", commentId)
                        )
                )
                .uniqueResult();
    }
}
