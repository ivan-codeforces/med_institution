package com.github.service;

import com.github.model.CaseEntity;
import com.github.model.UserEntity;

public interface AppointmentService {
    void addAppointment(UserEntity userEntity, CaseEntity caseEntity);
    void setStartDate();
    void setEndDate();
    void updateAppointment(int id);
    void deleteAppointment(int id);
}
