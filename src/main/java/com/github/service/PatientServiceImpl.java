package com.github.service;

import com.github.bo.PatientBo;
import com.github.dao.PatientDAO;
import com.github.model.Patient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {
    private PatientDAO patientDAO;

    public void setPatientDAO(PatientDAO patientDAO) {
        this.patientDAO = patientDAO;
    }

    @Override
    public void addPatient(Patient patient) {
        this.patientDAO.addPatient(patient);
    }

    @Override
    public void removePatient(int id) {
this.patientDAO.removePatient(id);
    }

    @Override
    public void updatePatient(Patient patient) {
this.patientDAO.updatePatient(patient);
    }

    @Override
    public Patient getPatientById(int id) {
        return this.patientDAO.getPatientById(id);
    }

    @Override
    public Patient getPatientByFirstName(String firstName) {
        return this.patientDAO.getPatientByFirstName(firstName);
    }

    @Override
    public Patient getPatientByLastName(String lastName) {
        return this.patientDAO.getPatientByLastName(lastName);
    }

    @Override
    public List<PatientBo> listPatients() {
        List<Patient> patientList = this.patientDAO.listPatients();

        List<PatientBo> patientBoList = new ArrayList<>(patientList.size());
        for (Patient p : patientList
        ) {
            patientBoList.add(convertPatientToPatientBo(p));
        }

        return patientBoList;
    }

    @Override
    public PatientBo convertPatientToPatientBo(Patient patient) {
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
