package com.github.service;

import com.github.model.CaseEntity;
import com.github.model.UserEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {

    @Override
    public void addAppointment(UserEntity userEntity, CaseEntity caseEntity) {

    }

    @Override
    public void setStartDate() {

    }

    @Override
    public void setEndDate() {

    }

    @Override
    public void updateAppointment(int id) {

    }

    @Override
    public void deleteAppointment(int id) {

    }
}
