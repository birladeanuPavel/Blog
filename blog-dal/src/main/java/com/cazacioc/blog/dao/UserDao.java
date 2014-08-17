package com.cazacioc.blog.dao;

import com.cazacioc.blog.entity.User;

/**
 * Created by scorpion on 09.08.14.
 */
public interface UserDao extends GeneralDao<User> {

    public User getUserByNickName(String nickname);

}