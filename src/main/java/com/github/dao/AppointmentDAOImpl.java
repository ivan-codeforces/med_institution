package com.github.dao;

import com.github.model.AppointmentEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AppointmentDAOImpl implements AppointmentDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public AppointmentDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;

    }

    @Override
    public void addAppointment(AppointmentEntity appointmentEntity) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(appointmentEntity);
    }

    @Override
    public void removeAppointment(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        AppointmentEntity appointmentEntity = session.get(AppointmentEntity.class, id);

        if (appointmentEntity != null) {
            session.delete(appointmentEntity);
        }
    }

    @Override
    public void updateAppointment(AppointmentEntity appointmentEntity) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(appointmentEntity);
    }

    @Override
    public boolean checkAppointment(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        AppointmentEntity appointmentEntity = session.get(AppointmentEntity.class, id);
        if (appointmentEntity.getId()==id){
            return true;
        }
        return false;
    }
}
