package com.github.dao;

import com.github.model.AppointmentEntity;

public interface AppointmentDAO {

    void addAppointment(AppointmentEntity appointmentEntity);
    void removeAppointment(int id);
    void updateAppointment(AppointmentEntity appointmentEntity);
    boolean checkAppointment(int id);



}
