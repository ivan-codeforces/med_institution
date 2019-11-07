package com.github.bo;

import com.github.model.Case;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class CaseBo {


    private int id;

    private String numberOfCase;

    private Date dateOfStart;

    private Date dateOfEnd;

    @Column(name = "CASE_STATUS")
    private String status;

    public void setId(int id) {
        this.id = id;
    }

    public void setNumberOfCase(String numberOfCase) {
        this.numberOfCase = numberOfCase;
    }

    public void setDateOfStart(Date dateOfStart) {
        this.dateOfStart = dateOfStart;
    }

    public void setDateOfEnd(Date dateOfEnd) {
        this.dateOfEnd = dateOfEnd;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
