package com.github.util;

import com.github.bo.CaseBo;
import com.github.model.CaseEntity;
import com.github.model.CaseStatus;
import org.junit.Assert;
import org.junit.Test;

//import static org.junit.Assert.*;

public class CaseMapperTest {

    @Test
    public void convertCaseToCaseBo() {
        CaseEntity caseEntity = new CaseEntity();
        caseEntity.setId("AAA3456789");
        caseEntity.setStatus(CaseStatus.INITIAL);
        CaseBo caseBo = CaseMapper.convertCaseToCaseBo(caseEntity);

        Assert.assertEquals("AAA3456789", caseBo.getId());
    }
}