package com.github.dao;

import com.github.model.MedCase;

import java.util.List;

public interface MedCaseDAO {
    List<MedCase> allMedCases();
    void add(MedCase medCase);
    void delete(MedCase medCase);
    void edit(MedCase medCase);
    MedCase getById(int medCase);
}
