package com.github.dao;

import com.github.model.Patient;

import java.util.List;

public interface PatientDAO {
    List<Patient> listPatients();

    void addPatient(Patient patient);

    void removePatient(int id);

    void updatePatient(Patient patient);

    Patient getPatientById(int id);

    Patient getPatientByFirstName(String firstName);

    Patient getPatientByLastName(String lastName);
}
