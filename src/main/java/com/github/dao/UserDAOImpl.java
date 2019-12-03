package com.github.dao;

import com.github.model.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
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
}
