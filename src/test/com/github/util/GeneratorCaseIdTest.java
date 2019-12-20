package com.github.util;

import com.github.model.CaseEntity;
import com.github.util.GeneratorCaseId;
import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class GeneratorCaseIdTest {

    @Test
    public void run()
    {
        CaseEntity caseEntity = new CaseEntity();
        caseEntity.setId("AAA1234567");
        String s = GeneratorCaseId.autoIncrement(Collections.singletonList(caseEntity));
        assertEquals(s, "AAA1234568");
    }
}
