package com.github.service;

import com.github.model.MedCase;

import java.util.List;

public interface MedCaseService {
    List<MedCase> allMedCases();
    void add(MedCase medCase);
    void delete(MedCase medCase);
    void edit(MedCase medCase);
    MedCase getById(int id);
}
