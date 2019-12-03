package com.github.dao;

import com.github.model.UserEntity;

import java.util.List;

public interface UserDAO {
    UserEntity getUserById(int id);
    List<UserEntity> listUsers();
}
