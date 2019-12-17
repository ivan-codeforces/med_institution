package com.github.util;

import com.github.bo.AppointmentBo;
import com.github.model.AppointmentEntity;

public final class AppointmentMapper {

    public AppointmentMapper() {
    }

    public static AppointmentBo convertToAppointmentBo(AppointmentEntity appointmentEntity){
        AppointmentBo appointmentBo = new AppointmentBo();

        appointmentBo.setId(appointmentEntity.getId());
        appointmentBo.setMedCaseId(appointmentEntity.getMedCaseId());
        appointmentBo.setStartDate(appointmentEntity.getStartDate());
        appointmentBo.setEndDate(appointmentBo.getEndDate());
        appointmentBo.setDescription(appointmentEntity.getDescription());
        appointmentBo.setStatus(appointmentEntity.getStatus());

        return appointmentBo;
    }
}
