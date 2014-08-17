package com.cazacioc.blog.authorization;

import com.cazacioc.blog.dao.UserDao;
import com.cazacioc.blog.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by scorpion on 09.08.14.
 */
@Service(value = "authService")
@Transactional
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        User user = userDao.getUserByNickName(username);

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().getAuthority()));

        org.springframework.security.core.userdetails.User springUser = new org.springframework.security.core.userdetails.User(
                user.getNickname(), user.getPassword(), authorities);

        return springUser;
    }
}