package com.cazacioc.blog.service.impl;

import com.cazacioc.blog.dao.UserDao;
import com.cazacioc.blog.entity.User;
import com.cazacioc.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by scorpion on 09.08.14.
 */
@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional(readOnly = false)
    public void addUser(User user) {
        userDao.save(user);
    }

    @Override
    @Transactional(readOnly = false)
    public void edit(User user) {
        userDao.update(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.loadAll();
    }

    @Override
    @Transactional(readOnly = false)
    public void removeUser(User user) {
        userDao.delete(user);
    }

    @Override
    public User getUserById(Long id) {
        return userDao.findById(id);
    }

    @Override
    @Transactional(readOnly = false)
    public void removeUserById(Long id) {
        userDao.deleteById(id);
    }

    @Override
    public User getUserByNickName(String nickname) {
        return userDao.getUserByNickName(nickname);
    }

}