package com.cazacioc.blog.service;

import com.cazacioc.blog.entity.User;

import java.util.List;

/**
 * Created by scorpion on 09.08.14.
 */
public interface UserService {

    public void addUser(User user);

    public void edit(User user);

    public List<User> getAllUsers();

    public void removeUser(User user);

    public User getUserById(Long id);

    void removeUserById(Long id);

    public User getUserByNickName(String nickname);
}