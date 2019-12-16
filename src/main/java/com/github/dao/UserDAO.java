package com.github.dao;

import com.github.model.Role;
import com.github.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDAO extends JpaRepository<Role, Long> {
    UserEntity getUserById(int id);
    List<UserEntity> listUsers();
    UserEntity findByUsername(String username);
}
