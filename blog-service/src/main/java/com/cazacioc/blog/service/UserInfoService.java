package com.cazacioc.blog.service;

import com.cazacioc.blog.entity.UserInfo;

import java.util.List;

/**
 * Created by scorpion on 09.08.14.
 */
public interface UserInfoService {

    public void addUser(UserInfo userInfo);

    public void edit(UserInfo userInfo);

    public List<UserInfo> getAllUserInfo();

    public void removeUserInfo(UserInfo userInfo);

    void removeUserInfoById(Long id);

    public UserInfo getUserInfoById(Long id);

}
