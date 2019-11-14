package com.github.dao;

import com.github.model.User;

import java.util.List;

public interface UserDAO {
    User getUserById(int id);
    List<User> listUsers();
}
