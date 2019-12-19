package com.github.service;

import com.github.bo.UserBo;
import com.github.model.UserEntity;

import java.util.List;

public interface UserService {
    UserBo getUserById(int id);
    List<UserBo> listUsers();
    UserBo convertUserToUserBo(UserEntity user);
}
