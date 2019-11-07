package com.github.service;

import com.github.model.Case;

import java.util.List;

public interface CaseService {

    void addCase(Case medCase);

    void removeCase(int id);

    void updateCase(Case medCase);

    void handleCase(Case medCase);

    Case getCaseById(int id);

    List<Case> listCases();
}
