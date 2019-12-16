package com.github.dao;

import com.github.model.Role;
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

    @Override
    public List<Role> findAll() {
        return null;
    }

    @Override
    public List<Role> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Role> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Role> findAll(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public void delete(Role entity) {

    }

    @Override
    public void delete(Iterable<? extends Role> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Role> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Role> List<S> save(Iterable<S> entities) {
        return null;
    }

    @Override
    public Role findOne(Long aLong) {
        return null;
    }

    @Override
    public boolean exists(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Role> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Role> entities) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Role getOne(Long aLong) {
        return null;
    }
}
