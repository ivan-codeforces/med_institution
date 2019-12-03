package com.github.dao;

import com.github.model.CaseEntity;
import com.github.model.PatientEntity;

import java.util.List;

public interface CaseDAO {
    List<CaseEntity> listCases();

    List<CaseEntity> listCasesByPatientId(PatientEntity patient);

    void addCase(CaseEntity medCase, PatientEntity patient);

    void removeCase(String id);

    void updateCase(CaseEntity medCase);

    CaseEntity getCaseById(String id);
}
