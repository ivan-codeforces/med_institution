package com.github.dao;

import com.github.model.PatientEntity;

import java.util.List;

public interface PatientDAO {
    List<PatientEntity> listPatients();

    void addPatient(PatientEntity patient);

    void removePatient(int id);

    void updatePatient(PatientEntity patient);

    PatientEntity getPatientById(int id);

    PatientEntity getPatientByFirstName(String firstName);

    PatientEntity getPatientByLastName(String lastName);
}
