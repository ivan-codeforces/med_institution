package com.github.service;

import com.github.bo.UserBo;
import com.github.dao.RoleDAO;
import com.github.dao.UserDAO;
import com.github.model.Role;
import com.github.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;
    private final RoleDAO roleDAO;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserDAO userDAO, RoleDAO roleDAO) {
        this.userDAO = userDAO;
        this.roleDAO = roleDAO;
    }

    @Override
    public void save(UserEntity user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleDAO.getOne(1L));
        user.setRoles(roles);
        userDAO.save(user);
    }

    @Override
    public UserEntity findByUsername(String username) {
        return userDAO.findByUsername(username);
    }

    @Override
    public UserBo getUserById(int id) {
        UserEntity userEntity = this.userDAO.getUserById(id);

        return convertUserToUserBo(userEntity);
    }

    @Override
    public List<UserBo> listUsers() {
        List<UserEntity> userList = this.userDAO.listUsers();

        List<UserBo> userBoList = new ArrayList<>(userList.size());
        for (UserEntity u : userList) {
            userBoList.add(convertUserToUserBo(u));
        }

        return userBoList;
    }

    public UserBo convertUserToUserBo(UserEntity user) {
        UserBo userBo = new UserBo();

        userBo.setId(user.getId());
        userBo.setUsername(user.getUsername());
        userBo.setPassword(user.getPassword());

        return userBo;
    }
}
