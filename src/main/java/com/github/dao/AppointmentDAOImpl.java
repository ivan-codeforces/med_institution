package com.github.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class AppointmentDAOImpl implements AppointmentDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public AppointmentDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;

    }

    @Override
    public void addAppointment() {

    }

    @Override
    public void removeAppointment(int id) {

    }

    @Override
    public void updateAppointment(int id) {

    }

    @Override
    public boolean checkAppointment(int id) {
        return false;
    }
}
