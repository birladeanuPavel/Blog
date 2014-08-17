package com.cazacioc.blog.service;

import com.cazacioc.blog.entity.Role;

import java.util.List;

/**
 * Created by scorpion on 09.08.14.
 */
public interface RoleService {

    public void addRole(Role role);

    public void edit(Role role);

    public List<Role> getAllRoles();

    public void removeRole(Role role);

    void removeRoleById(Long id);

    public Role getRoleById(Long id);
}
