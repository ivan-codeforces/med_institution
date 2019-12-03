package com.github.util;

import com.github.bo.CaseBo;
import com.github.model.CaseEntity;

public final class CaseMapper {

    private CaseMapper() {
    }

    public static CaseBo convertCaseToCaseBo(CaseEntity medCase) {
        CaseBo caseBo = new CaseBo();

        caseBo.setId(medCase.getId());
        caseBo.setDateOfStart(medCase.getDateOfStart());
        caseBo.setDateOfEnd(medCase.getDateOfEnd());
        caseBo.setStatus(medCase.getStatus().getText());
        caseBo.setOwnerU(medCase.getOwnerU());
        caseBo.setOwnerP(medCase.getOwnerP());

        return caseBo;
    }
}
