package com.github.service;

import com.github.bo.CaseBo;
import com.github.dao.CaseDAO;
import com.github.model.CaseEntity;
import com.github.model.CaseStatus;
import com.github.model.PatientEntity;
import com.github.util.CaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CaseServiceImpl implements CaseService {
    private final CaseDAO medCaseDAO;

    @Autowired
    public CaseServiceImpl(CaseDAO medCaseDAO) {
        this.medCaseDAO = medCaseDAO;
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addCase(CaseEntity medCase, long patientId) {

        PatientEntity patient = entityManager.find(PatientEntity.class, patientId);
        medCase.setOwnerP(patient);
        medCase.setStatus(CaseStatus.INITIAL);
        this.medCaseDAO.addCase(medCase, patient);
    }

    @Override
    public void removeCase(String id) {
        this.medCaseDAO.removeCase(id);
    }

    @Override
    public void updateCase(CaseEntity medCase) {

        this.medCaseDAO.updateCase(medCase);
    }

    @Override
    public CaseBo getCaseById(String id) {
        CaseEntity caseById = this.medCaseDAO.getCaseById(id);

        return CaseMapper.convertCaseToCaseBo(caseById);
    }

    @Override
    public List<CaseBo> listCases() {
        List<CaseEntity> caseList = this.medCaseDAO.listCases();
        List<CaseBo> caseBoList = new ArrayList<>(caseList.size());

        for (CaseEntity c : caseList) {
            caseBoList.add(CaseMapper.convertCaseToCaseBo(c));
        }

        return caseBoList;
    }

    @Override
    public List<CaseBo> listCasesByPatientId(PatientEntity patient) {
        return listCasesByPatientId(patient.getId());
    }

    @Override
    public List<CaseBo> listCasesByPatientId(int patientId) {
        List<CaseEntity> caseList = this.medCaseDAO.listCases();
        List<CaseBo> caseBoList = new ArrayList<>(caseList.size());

        for (CaseEntity c : caseList) {
            if (c.getOwnerP().getId() == patientId) {
                caseBoList.add(CaseMapper.convertCaseToCaseBo(c));
            }
        }
        return caseBoList;
    }

}
