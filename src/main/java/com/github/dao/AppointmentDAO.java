package com.github.dao;

public interface AppointmentDAO {

    void addAppointment();
    void removeAppointment(int id);
    void updateAppointment(int id);
    boolean checkAppointment(int id);



}
