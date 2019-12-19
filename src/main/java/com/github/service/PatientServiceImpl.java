package com.github.service;

import com.github.bo.PatientBo;
import com.github.dao.PatientDAO;
import com.github.model.PatientEntity;
import com.github.util.PatientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {
    private final PatientDAO patientDAO;
    private static final Logger LOGGER = Logger.getLogger(PatientServiceImpl.class);

    @Autowired
    public PatientServiceImpl(PatientDAO patientDAO) {
        this.patientDAO = patientDAO;
    }

    @Override
    public void addPatient(PatientEntity patient) {

        this.patientDAO.addPatient(patient);
        LOGGER.info("Add patient: id - " + patient.getId());
    }

    @Override
    public void removePatient(int id) {

        this.patientDAO.removePatient(id);
        LOGGER.info("Remove patient: id - " + id);
    }

    @Override
    public void updatePatient(PatientEntity patient) {

        this.patientDAO.updatePatient(patient);
        LOGGER.info("Update patient: id - " + patient.getId());
    }

    @Override
    public PatientBo getPatientById(int id) {
        PatientEntity patientById = this.patientDAO.getPatientById(id);
        LOGGER.info("Get patient by id - " + id);

        return PatientMapper.convertPatientToPatientBo(patientById);
    }

    @Override
    public PatientEntity getPatientByFirstName(String firstName) {

        return this.patientDAO.getPatientByFirstName(firstName);
    }

    @Override
    public PatientEntity getPatientByLastName(String lastName) {

        return this.patientDAO.getPatientByLastName(lastName);
    }

    @Override
    public List<PatientBo> listPatients() {
        List<PatientEntity> patientList = this.patientDAO.listPatients();

        List<PatientBo> patientBoList = new ArrayList<>(patientList.size());
        for (PatientEntity p : patientList) {
            patientBoList.add(PatientMapper.convertPatientToPatientBo(p));
        }

        LOGGER.info("Receive list of patients: " + patientBoList.size() + " patients");
        return patientBoList;
    }

}
