package com.github.util;

import com.github.bo.PatientBo;
import com.github.model.PatientEntity;
import org.junit.Assert;
import org.junit.Test;

public class PatientMapperTest {

    @Test
    public void convertPatientToPatientBo() {
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setSsn(312312);

        PatientBo patientBo = PatientMapper.convertPatientToPatientBo(patientEntity);
        Assert.assertEquals(312312, patientBo.getSsn());
    }
}
