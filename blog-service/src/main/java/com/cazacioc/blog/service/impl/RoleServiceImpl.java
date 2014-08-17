package com.cazacioc.blog.service.impl;

import com.cazacioc.blog.dao.RoleDao;
import com.cazacioc.blog.entity.Role;
import com.cazacioc.blog.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by scorpion on 09.08.14.
 */

@Service
@Transactional(readOnly = true)
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    @Transactional(readOnly = false)
    public void addRole(Role role) {
        roleDao.save(role);
    }

    @Override
    @Transactional(readOnly = false)
    public void edit(Role role) {
        roleDao.update(role);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleDao.loadAll();
    }

    @Override
    @Transactional(readOnly = false)
    public void removeRole(Role role) {
        roleDao.delete(role);
    }

    @Override
    @Transactional(readOnly = false)
    public void removeRoleById(Long id) {
        roleDao.deleteById(id);
    }

    @Override
    public Role getRoleById(Long id) {
        return roleDao.findById(id);
    }
}
