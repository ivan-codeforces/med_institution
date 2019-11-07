package com.github.dao;

import com.github.model.Case;

import java.util.List;

public interface CaseDAO {
    List<Case> listCases();

    void addCase(Case medCase);

    void removeCase(int id);

    void updateCase(Case medCase);

    Case getCaseById(int id);
}
