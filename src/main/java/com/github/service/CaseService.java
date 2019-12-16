package com.github.service;

import com.github.bo.CaseBo;
import com.github.model.CaseEntity;
import com.github.model.PatientEntity;

import java.util.List;

public interface CaseService {

    void addCase(CaseEntity medCase, int id);

    void removeCase(String id);

    void updateCase(CaseEntity medCase);

    CaseBo getCaseById(String id);

    List<CaseBo> listCases();

    List<CaseBo> listCasesByPage(int page);

    List<CaseBo> listCasesByPatientId(PatientEntity patient);

    List<CaseBo> listCasesByPatientId(int patient);

    void takeToWork(String caseId, String targetStatus);
}
