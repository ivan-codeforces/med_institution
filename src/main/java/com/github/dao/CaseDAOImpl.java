package com.github.dao;

import com.github.model.Case;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CaseDAOImpl implements CaseDAO {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<Case> listCases() {
        Session session = this.sessionFactory.getCurrentSession();

        return session.createQuery("from Case").list();
    }

    @Override
    public void addCase(Case medCase) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(medCase);
    }

    @Override
    public void removeCase(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Case medCase = session.load(Case.class, id);

        if (medCase != null) {
            session.delete(medCase);
        }
    }

    @Override
    public void updateCase(Case medCase) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(medCase);
    }

    @Override
    public Case getCaseById(int id) {
        Session session = this.sessionFactory.getCurrentSession();

        return session.load(Case.class, id);
    }
}
