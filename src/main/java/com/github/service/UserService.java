package com.github.service;

import com.github.bo.UserBo;
import com.github.model.User;

import java.util.List;

public interface UserService {
    UserBo getUserById(int id);
    List<UserBo> listUsers();
    UserBo convertUserToUserBo(User user);
}
