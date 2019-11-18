package com.github.service;

import com.github.bo.CaseBo;
import com.github.model.Case;

import java.util.List;

public interface CaseService {

    void addCase(Case medCase);

    void removeCase(int id);

    void updateCase(Case medCase);

    void handleCase(Case medCase);

    CaseBo getCaseById(int id);

    List<CaseBo> listCases();

//    List<CaseBo> listCasesByPatientId(List<CaseBo> caseBoList, int id);

    CaseBo convertCaseToCaseBo(Case medCase);
}
