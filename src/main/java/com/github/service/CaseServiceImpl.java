package com.github.service;

import com.github.dao.CaseDAO;
import com.github.model.Case;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CaseServiceImpl implements CaseService {
    private CaseDAO medCaseDAO;

    @Transactional
    public void setMedCaseDAO(CaseDAO medCaseDAO) {
        this.medCaseDAO = medCaseDAO;
    }

    @Override
    @Transactional
    public void addCase(Case medCase) {
        this.medCaseDAO.addCase(medCase);
    }

    @Override
    @Transactional
    public void removeCase(int id) {
        this.medCaseDAO.removeCase(id);
    }

    @Override
    @Transactional
    public void updateCase(Case medCase) {
        this.medCaseDAO.updateCase(medCase);
    }

    @Override
    @Transactional
    public void handleCase(Case medCase) {
        if(medCase.getId() == 0){
            addCase(medCase);
        }else {
            updateCase(medCase);
        }
    }


    @Override
    @Transactional
    public Case getCaseById(int id) {
        Case caseById = this.medCaseDAO.getCaseById(id);

        return caseById;
    }

    @Override
    @Transactional
    public List<Case> listCases() {
        List<Case> caseList = this.medCaseDAO.listCases();
        return caseList;
    }
}
