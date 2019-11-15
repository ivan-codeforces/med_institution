package com.github.service;

import com.github.bo.CaseBo;
import com.github.dao.CaseDAO;
import com.github.model.Case;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CaseServiceImpl implements CaseService {
    private CaseDAO medCaseDAO;

    public void setMedCaseDAO(CaseDAO medCaseDAO) {
        this.medCaseDAO = medCaseDAO;
    }

    @Override
    public void addCase(Case medCase) {
        this.medCaseDAO.addCase(medCase);
    }

    @Override
    public void removeCase(int id) {
        this.medCaseDAO.removeCase(id);
    }

    @Override
    public void updateCase(Case medCase) {
        this.medCaseDAO.updateCase(medCase);
    }

    @Override
    public void handleCase(Case medCase) {
        if(medCase.getId() == 0){
            addCase(medCase);
        }else {
            updateCase(medCase);
        }
    }

    @Override
    public CaseBo getCaseById(int id) {
        Case caseById = this.medCaseDAO.getCaseById(id);

        return convertCaseToCaseBo(caseById);
    }

    @Override
    public List<CaseBo> listCases() {
        List<Case> caseList = this.medCaseDAO.listCases();

        List<CaseBo> caseBoList = new ArrayList<>(caseList.size());
        for (Case c: caseList
             ) {
            caseBoList.add(convertCaseToCaseBo(c));
        }

        return caseBoList;
    }

    @Override
    public CaseBo convertCaseToCaseBo(Case medCase) {
        CaseBo caseBo = new CaseBo();

        caseBo.setId(medCase.getId());
        caseBo.setNumberOfCase(medCase.getNumberOfCase());
        caseBo.setDateOfStart(medCase.getDateOfStart());
        caseBo.setDateOfEnd(medCase.getDateOfEnd());
        caseBo.setStatus(medCase.getStatus());
        caseBo.setOwnerU(medCase.getOwnerU());
        caseBo.setOwnerP(medCase.getOwnerP());

        return caseBo;
    }


}
