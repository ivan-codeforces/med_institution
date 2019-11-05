package com.github.service;

import com.github.dao.MedCaseDAO;
import com.github.dao.MedCaseDAOImpl;
import com.github.model.MedCase;

import java.util.List;

public class MedCaseServiceImpl implements MedCaseService {
    private MedCaseDAO medCaseDAO = new MedCaseDAOImpl();

    @Override
    public List<MedCase> allMedCases() {
        return medCaseDAO.allMedCases();
    }

    @Override
    public void add(MedCase medCase) {
        medCaseDAO.add(medCase);
    }

    @Override
    public void delete(MedCase medCase) {
        medCaseDAO.delete(medCase);
    }

    @Override
    public void edit(MedCase medCase) {
        medCaseDAO.edit(medCase);
    }

    @Override
    public MedCase getById(int id) {
        return medCaseDAO.getById(id);
    }
}
