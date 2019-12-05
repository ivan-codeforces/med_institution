package com.github.service;

import com.github.bo.UserBo;
import com.github.dao.UserDAO;
import com.github.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public UserBo getUserById(int id) {
        UserEntity userEntity = this.userDAO.getUserById(id);

        return convertUserToUserBo(userEntity);
    }

    @Override
    public List<UserBo> listUsers() {
        List<UserEntity> userList = this.userDAO.listUsers();

        List<UserBo> userBoList= new ArrayList<>(userList.size());
        for (UserEntity u: userList) {
            userBoList.add(convertUserToUserBo(u));
        }

        return userBoList;
    }

    public UserBo convertUserToUserBo(UserEntity user){
        UserBo userBo = new UserBo();

        userBo.setId(user.getId());
        userBo.setUsername(user.getUsername());
        userBo.setPassword(user.getPassword());

        return userBo;
    }
}
