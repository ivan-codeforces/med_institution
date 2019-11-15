package com.github.service;

import com.github.bo.PatientBo;
import com.github.model.Patient;

import java.util.List;

public interface PatientService {
    void addPatient(Patient patient);

    void removePatient(int id);

    void updatePatient(Patient patient);

    Patient getPatientById(int id);

    Patient getPatientByFirstName(String firstName);

    Patient getPatientByLastName(String lastName);

    List<PatientBo> listPatients();

    PatientBo convertPatientToPatientBo(Patient patient);
}
