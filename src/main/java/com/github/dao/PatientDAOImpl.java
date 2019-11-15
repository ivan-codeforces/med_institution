package com.github.dao;

import com.github.model.Patient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatientDAOImpl implements PatientDAO{
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Patient> listPatients() {
        Session session = this.sessionFactory.getCurrentSession();

        return session.createQuery("from Patient").list();
    }

    @Override
    public void addPatient(Patient patient) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(patient);
    }

    @Override
    public void removePatient(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Patient patient = session.load(Patient.class, id);

        if (patient != null) {
            session.delete(patient);
        }
    }

    @Override
    public void updatePatient(Patient patient) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(patient);
    }

    @Override
    public Patient getPatientById(int id) {
        Session session = this.sessionFactory.getCurrentSession();

        return session.load(Patient.class, id);
    }

    @Override
    public Patient getPatientByFirstName(String firstName) {
        Session session = this.sessionFactory.getCurrentSession();

        return session.load(Patient.class, firstName);
    }

    @Override
    public Patient getPatientByLastName(String lastName) {
        Session session = this.sessionFactory.getCurrentSession();

        return session.load(Patient.class, lastName);
    }

}
