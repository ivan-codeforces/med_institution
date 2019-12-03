package com.github.dao;

import com.github.model.PatientEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatientDAOImpl implements PatientDAO {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<PatientEntity> listPatients() {
        Session session = this.sessionFactory.getCurrentSession();

        return session.createQuery("from PatientEntity").list();
    }

    @Override
    public void addPatient(PatientEntity patient) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(patient);
    }

    @Override
    public void removePatient(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        PatientEntity patient = session.load(PatientEntity.class, id);

        if (patient != null) {
            session.delete(patient);
        }
    }

    @Override
    public void updatePatient(PatientEntity patient) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(patient);
    }

    @Override
    public PatientEntity getPatientById(int id) {
        Session session = this.sessionFactory.getCurrentSession();

        return session.load(PatientEntity.class, id);
    }

    @Override
    public PatientEntity getPatientByFirstName(String firstName) {
        Session session = this.sessionFactory.getCurrentSession();

        return session.load(PatientEntity.class, firstName);
    }

    @Override
    public PatientEntity getPatientByLastName(String lastName) {
        Session session = this.sessionFactory.getCurrentSession();

        return session.load(PatientEntity.class, lastName);
    }

}
