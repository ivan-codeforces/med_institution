package com.github.service;

import com.github.bo.PatientBo;
import com.github.model.PatientEntity;

import java.util.List;

public interface PatientService {

    void addPatient(PatientEntity patient);

    void removePatient(int id);

    void updatePatient(PatientEntity patient);

    PatientBo getPatientById(int id);

    PatientEntity getPatientByFirstName(String firstName);

    PatientEntity getPatientByLastName(String lastName);

    List<PatientBo> listPatients();

}
