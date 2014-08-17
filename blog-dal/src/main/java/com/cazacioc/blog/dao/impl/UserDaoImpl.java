package com.cazacioc.blog.dao.impl;

import com.cazacioc.blog.dao.UserDao;
import com.cazacioc.blog.entity.User;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Created by scorpion on 09.08.14.
 */
@Repository
public class UserDaoImpl extends GeneralDaoImpl<User> implements UserDao {

    protected UserDaoImpl() {
        super(User.class);
    }

    @Override
    public User getUserByNickName(String nickname) {
        return (User) getCurrentSession().createCriteria(User.class)
                .add(Restrictions.eq("nickname", nickname)).uniqueResult();
    }
}
