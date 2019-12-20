package com.github.service;

import com.github.bo.UserBo;
import com.github.dao.UserDAO;
import com.github.model.UserEntity;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;
    private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public UserBo getUserById(int id) {
        UserEntity userEntity = this.userDAO.getUserById(id);
        LOGGER.info(String.format("getUserById - %d", id));
        return convertUserToUserBo(userEntity);
    }

    @Override
    public List<UserBo> listUsers() {
        List<UserEntity> userList = this.userDAO.listUsers();

        List<UserBo> userBoList = new ArrayList<>(userList.size());
        for (UserEntity u : userList) {
            userBoList.add(convertUserToUserBo(u));
        }
        LOGGER.info(String.format("received listUsers: %d users", userBoList.size()));

        return userBoList;
    }

    public UserBo convertUserToUserBo(UserEntity user) {
        UserBo userBo = new UserBo();
        LOGGER.info("convertUserToUserBo - entryPoint");
        userBo.setId(user.getId());
        userBo.setUsername(user.getUsername());
        userBo.setPassword(user.getPassword());
        LOGGER.info("convertUserToUserBo - exitPoint");
        return userBo;
    }
}
