package com.cazacioc.blog.dto;

/**
 * Created by scorpion on 09.08.14.
 */
public class UserDTO {

    private Long id;

    private String password;

    private String nickname;

    private Boolean enabled;

    private UserInfoDTO userInfo;

    private RoleDTO role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public UserInfoDTO getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfoDTO userInfo) {
        this.userInfo = userInfo;
    }

    public RoleDTO getRole() {
        return role;
    }

    public void setRole(RoleDTO role) {
        this.role = role;
    }
}
