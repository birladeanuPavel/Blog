package com.cazacioc.blog.service.impl;

import com.cazacioc.blog.dao.UserInfoDao;
import com.cazacioc.blog.entity.UserInfo;
import com.cazacioc.blog.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by scorpion on 09.08.14.
 */
@Service
@Transactional(readOnly = true)
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    @Transactional(readOnly = false)
    public void addUser(UserInfo userInfo) {
        userInfoDao.save(userInfo);
    }

    @Override
    @Transactional(readOnly = false)
    public void edit(UserInfo userInfo) {
        userInfoDao.update(userInfo);
    }

    @Override
    public List<UserInfo> getAllUserInfo() {
        return userInfoDao.loadAll();
    }

    @Override
    @Transactional(readOnly = false)
    public void removeUserInfo(UserInfo userInfo) {
        userInfoDao.delete(userInfo);
    }

    @Override
    @Transactional(readOnly = false)
    public void removeUserInfoById(Long id) {
        userInfoDao.deleteById(id);
    }

    @Override
    public UserInfo getUserInfoById(Long id) {
        return userInfoDao.findById(id);
    }
}
