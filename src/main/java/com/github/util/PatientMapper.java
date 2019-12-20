package com.github.util;

import com.github.bo.PatientBo;
import com.github.model.PatientEntity;

public final class PatientMapper {
    private PatientMapper() {
    }

    public static PatientBo convertPatientToPatientBo(PatientEntity patient) {
        PatientBo patientBo = new PatientBo();

        patientBo.setId(patient.getId());
        patientBo.setFirstName(patient.getFirstName());
        patientBo.setLastName(patient.getLastName());
        patientBo.setDateOfBirth(patient.getDateOfBirth());
        patientBo.setPassport(patient.getPassport());
        patientBo.setAddress(patient.getAddress());
        patientBo.setEmail(patient.getEmail());
        patientBo.setPhone(patient.getPhone());
        patientBo.setComment(patient.getComment());
        patientBo.setSsn(patient.getSsn());

        return patientBo;
    }

    public static PatientEntity convertPatientBoToPatientEntity(PatientBo patientBo){
        PatientEntity patientEntity = new PatientEntity();

        patientEntity.setId(patientBo.getId());
        patientEntity.setFirstName(patientBo.getFirstName());
        patientEntity.setLastName(patientBo.getLastName());
        patientEntity.setDateOfBirth(patientBo.getDateOfBirth());
        patientEntity.setPassport(patientBo.getPassport());
        patientEntity.setAddress(patientBo.getAddress());
        patientEntity.setEmail(patientBo.getEmail());
        patientEntity.setPhone(patientBo.getPhone());
        patientEntity.setComment(patientBo.getComment());
        patientEntity.setSsn(patientBo.getSsn());

        return patientEntity;
    }
}
