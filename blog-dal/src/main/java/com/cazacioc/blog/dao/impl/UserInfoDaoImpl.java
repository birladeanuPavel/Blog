package com.cazacioc.blog.dao.impl;

import com.cazacioc.blog.dao.UserInfoDao;
import com.cazacioc.blog.entity.UserInfo;
import org.springframework.stereotype.Repository;

/**
 * Created by scorpion on 09.08.14.
 */

@Repository
public class UserInfoDaoImpl extends GeneralDaoImpl<UserInfo> implements UserInfoDao {

    protected UserInfoDaoImpl() {
        super(UserInfo.class);
    }
}
