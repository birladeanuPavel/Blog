package com.cazacioc.blog.dao.impl;

import com.cazacioc.blog.dao.RoleDao;
import com.cazacioc.blog.entity.Role;
import org.springframework.stereotype.Repository;

/**
 * Created by scorpion on 09.08.14.
 */
@Repository
public class RoleDaoImpl extends GeneralDaoImpl<Role> implements RoleDao {

    protected RoleDaoImpl() {
        super(Role.class);
    }
}
