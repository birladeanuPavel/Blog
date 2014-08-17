package com.cazacioc.blog.facade;

import com.cazacioc.blog.dto.UserDTO;
import com.cazacioc.blog.entity.User;
import com.cazacioc.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by scorpion on 09.08.14.
 */
@Service
public class UserFacade {

    @Autowired
    private UserService userService;

    private UserDTO userToUserDto(User user) {

        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setPassword(user.getPassword());
        userDTO.setEnabled(user.getEnabled());

        return userDTO;

    }

    private User userDtoToUser(UserDTO userDTO) {

        User user = new User();
        user.setId(user.getId());
        user.setPassword(userDTO.getPassword());
        user.setEnabled(userDTO.getEnabled());

        return user;

    }

    public void addUser(UserDTO userDTO) {
        userService.addUser(userDtoToUser(userDTO));
    }

    public List<UserDTO> getAllUsers() {
        List<User> users = userService.getAllUsers();
        List<UserDTO> userDTOs = new ArrayList<UserDTO>();
        for (User user : users) {
            userDTOs.add(userToUserDto(user));
        }
        return userDTOs;
    }

    public UserDTO getUserById(Long id) {
        return userToUserDto(userService.getUserById(id));
    }

    public void updateUser(UserDTO userDTO) {
        userService.edit(userDtoToUser(userDTO));
    }

    public void deleteUser(UserDTO userDTO) {
        userService.removeUser(userDtoToUser(userDTO));
    }
}
