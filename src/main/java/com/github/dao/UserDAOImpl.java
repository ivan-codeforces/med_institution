package com.github.dao;

//import com.github.model.Role;
import com.github.model.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public UserEntity getUserById(int id) {
        Session session = this.sessionFactory.getCurrentSession();

        return session.load(UserEntity.class, id);
    }

    @Override
    public List<UserEntity> listUsers() {
        Session session = this.sessionFactory.getCurrentSession();

        return session.createQuery("from UserEntity").list();
    }

    @Override
    public UserEntity findByUsername(String username) {
        return null;
    }


}
