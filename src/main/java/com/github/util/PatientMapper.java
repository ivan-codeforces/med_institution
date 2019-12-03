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
}
