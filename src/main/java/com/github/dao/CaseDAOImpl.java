package com.github.dao;

import com.github.model.CaseEntity;
import com.github.model.CaseStatus;
import com.github.model.PatientEntity;
import com.github.util.GeneratorCaseId;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CaseDAOImpl implements CaseDAO {
    private final SessionFactory sessionFactory;

    @Autowired
    public CaseDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<CaseEntity> listCases() {
        Session session = this.sessionFactory.getCurrentSession();

        return session.createQuery("from CaseEntity").list();
    }

    public CaseEntity lastCaseId(){
        Session session = this.sessionFactory.getCurrentSession();

        return (CaseEntity) session.createQuery("select iselect max (id) from CaseEntity").getSingleResult();
    }

    @Override
    public List<CaseEntity> listCasesByPatientId(PatientEntity patient) {
        Session session = this.sessionFactory.getCurrentSession();

        Query query = session.createQuery("from CaseEntity where :id = ownerP");
        query.setParameter("id", patient.getId());

        return query.list();
    }

    @Override
    public void addCase(CaseEntity medCase, PatientEntity patient) {
        Session session = this.sessionFactory.getCurrentSession();
        medCase.setId(GeneratorCaseId.autoIncrement(listCases()));
        medCase.setOwnerP(patient);
        session.persist(medCase);
    }

    @Override
    public void removeCase(String id) {
        Session session = this.sessionFactory.getCurrentSession();
        CaseEntity medCase = session.get(CaseEntity.class, id);

        if (medCase != null) {
            session.delete(medCase);
        }
    }

    @Override
    public void updateCase(CaseEntity medCase) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(medCase);
    }

    @Override
    public CaseEntity getCaseById(String id) {
        Session session = this.sessionFactory.getCurrentSession();

        return session.get(CaseEntity.class, id);
    }

    @Override
    public void getInWork(CaseEntity medCase) {
        Session session = this.sessionFactory.getCurrentSession();
//        if (medCase.getStatus().equals("INITIAL")){
            session.update(medCase);
//        } else if (medCase.getStatus().equals("IN PROGRESS")){
//
//        }
    }
}